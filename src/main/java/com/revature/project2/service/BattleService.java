package com.revature.project2.service;

import java.util.List;

import com.revature.project2.pojo.Action;
import com.revature.project2.pojo.Actor;
import com.revature.project2.util.ELM;
import com.revature.project2.util.STS;
import com.revature.project2.service.BattleService;

public class BattleService {

	private static FieldService fs;
	private static BattleService bs;
	
	private static String battlelog;
	
	
	private int status = 0; // 1 is a victory, -1 is a defeat.
	
	public static BattleService getBattleService() {
		if(bs == null) {
			bs = new BattleService();
		}
		return bs;
	}
	
	public int getStatus() {
		return status;
	}
	
	public boolean initialize() { // Set up the initial battle state.
		boolean status = true;
		// Verify that combatants have been registered.
		if(fs.getCombatants() == null) {
			System.out.println("Failed to initialize Battle System: Null Combatants.");
			return false;
		}
		if(fs.numberOfCombatants() == 0) {
			System.out.println("Failed to initialize Battle System: No Combatants.");
			return false;
		}
		if(fs.numberOfCombatants() == 1) {
			System.out.println("Failed to initialize Battle System: Not enough Combatants.");
			return false;
		}

		return status; // No problems with battle initialization.
		
	}
	
	public String round() { // Function that plays a full Round (Each Actor takes one turn.)
		// This function is called after the user inputs all their character action and target selections.
		// It generates actions for each monster. Then it traverses the combatants array, and
		// performs the actions selected for each actor against their selected target. It ceases
		// execution at the end of the round while the Battle Service awaits new input for the next round.
		
		// Pre-Round calculations...
		battlelog = "";
		// call on the action for each combatant.
		System.out.println("START OF NEW ROUND");
		//System.out.println(fs.next());
		
		while(fs.next() >= 0 && status == 0) { // while there is a next character (who is not dead or has moved.)
			//System.out.println("In While Loop: " + fs.getCombatant(fs.next()).getName());
			Actor actor = fs.getCombatant(fs.next());
			
			if(actor.getParty().equals("Heroes")) {
				actChosen(actor);					// The Actor will use its own stored action if belonging to the Heroes party.
			} else {
			actAI(actor);		// The actor will automatically use its own action to call on fs to find targets and execute its action.
			}
			battlelog += "\n";
			// Post-Turn Calculations
			//System.out.println(""); //Put a space between lines to make each turn more readable.
			actor.setReady(false);
			victoryCheck();
		}
		// Post-Round calculations...
		return battlelog;
	}
	
	public void actAI(Actor user) {
		StringBuilder attacklog = new StringBuilder();
		Action action = user.getAction();
		List<Integer> targets = fs.getTargets(user.getFid(), action.getTargets()); 	// Retrieve a list of possible targets from the field.
		action.setAmount(user.getStat(action.getAstat()));
		
		attacklog.append(user.getName());
		attacklog.append(" used ");
		attacklog.append(action.getName());
		attacklog.append("!\n");
		
		battlelog += attacklog.toString();
		
		if(action.getFocus() == 0) { 												// If Focus, there is only one target to choose.
			int target = targets.get( 0 + (int)(Math.random() * targets.size())); 	// choose a random target from the list.
			defend(action, fs.getCombatant(target));								// And initiate the action by passing it to the defender.
		}
		if(action.getFocus() == 1) {												// If Spread, apply action to every target on the list.
			for(int index = 0; index < targets.size(); index++) {
				//System.out.println(targets.get(index));
				defend(action, fs.getCombatant(targets.get(index)));
			}
		}
	}
	
	public void actChosen(Actor user) {
		StringBuilder attacklog = new StringBuilder();
		Action action = user.getAction();
		
		List<Integer> targets = fs.getTargets(user.getFid(), action.getTargets()); 	// Retrieve a list of possible targets from the field.
		
		action.setAmount(user.getStat(action.getAstat()));
		
		attacklog.append(user.getName());
		attacklog.append(" used ");
		attacklog.append(action.getName());
		attacklog.append("!\n");
		
		battlelog += attacklog.toString();
		
			for(int index = 0; index < user.getTargets().size(); index++) {
				if(targets.contains(user.getTargets().get(index))) { // If this is a valid target...
					defend(action, fs.getCombatant(user.getTargets().get(index)));
				} else {
					battlelog += "Invalid Target!\n";
				}
				
		}
	}
	
	public void defend(Action action, Actor defender) {
		StringBuilder deflog = new StringBuilder();
		int current = defender.getStat(action.getTstat()); 							// This is the stat being damaged.
		int apply = action.getAmount();												// This is the incomming damage as calculated by the attacker.
		// calculate hit/miss/critical? (future logic.)
		
		deflog.append(defender.getName());
		
		// reduce apply by the defending stat passed in.
		if(action.getDstat() >= 0) 													// if less than zero, then a "no defense" stat passed.
		{ apply -= defender.getStat(action.getDstat()); } 
		
		// prevent negative gains/losses.
		if (apply < 0 ) { apply = 0; } 	
		
		// apply the difference to the target stat.
		if(action.getElement() == ELM.HEAL.getValue()) {							// if the incomming element is Heal then...
			current += apply;														// add the damage to the stat instead of deduct.
			defender.setStat(action.getTstat(), current);							// apply the calculated change.
			// Declare the result of the action on the defender.
			
			deflog.append(" recovered ");
			deflog.append(apply);
			if(action.getTstat() == STS.HP.getValue()) { deflog.append(" health!"); }
			else { deflog.append( " " + STS.valueOf(action.getTstat()) + "!");}
		} else {
			current -= apply;														// otherwise, deduct.
			defender.setStat(action.getTstat(), current);							// apply the calculated change.
			
			if(action.getTstat() == STS.HP.getValue()) { 
				deflog.append(" took "); 
				deflog.append(apply);
				deflog.append(" damage!");
				}
			else { 
				deflog.append(" lost "); 
				deflog.append(apply);
				deflog.append(" " + STS.valueOf(action.getTstat()) + "!");
				}
		}
		
		deflog.append(" (");
		deflog.append(defender.getStat(action.getTstat()));
		deflog.append(")\n");
		
		if(defender.getStat(STS.HP) == 0) { 
			deflog.append(defender.getName());
			deflog.append(" fell!\n"); 
			}
		battlelog += deflog.toString();
	}
		
	public void victoryCheck() {
		boolean playersWiped = fs.isPartyWiped("Heroes");
		boolean monstersWiped = fs.isPartyWiped("Monsters");

		// if either party is entirely knocked out, declare a victory status.
		// monsters checked first, because a victory doesn't matter if the
		// player's party is somehow also dead.
		if(monstersWiped) {status = 1;}
		if(playersWiped) {status = -1;}
	}
	
	private BattleService() {
		super();
		fs = FieldService.getField();
		battlelog = "";
	}
}