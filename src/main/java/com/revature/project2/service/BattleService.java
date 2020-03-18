package com.revature.project2.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.revature.project2.pojo.Action;
import com.revature.project2.pojo.Actor;
import com.revature.project2.pojo.Player;
import com.revature.project2.util.STS;

public class BattleService {

	public List<Actor> combatants = new ArrayList<Actor>();
	private List<Integer> party1 = new ArrayList<Integer>();
	private  List<Integer> party2 = new ArrayList<Integer>();
	
	//public int turn;	// The index keeping track of which Actor is presently selected (Whose turn it is.)
	public int status = 0; // 1 is a victory, -1 is a defeat.
	
	public boolean initialize() { // Set up the initial battle state.
		boolean status = true;
		// Verify that combatants have been registered.
		if(combatants == null) {
			System.out.println("Failed to initialize Battle System: Null Combatants.");
			return false;
		}
		if(combatants.size() == 0) {
			System.out.println("Failed to initialize Battle System: No Combatants.");
			return false;
		}
		if(combatants.size() == 1) {
			System.out.println("Failed to initialize Battle System: Not enough Combatants.");
			return false;
		}
		
		// Generate Target List
		generateTargets();
		
		// Check that each party has members.
		if(party1.size() == 0 ) {
			System.out.println("Failed to initialize Battle System: No Party Members.");
			return false;
		}
		if(party1.size() == 0 ) {
			System.out.println("Failed to initialize Battle System: No Party Members.");
			return false;
		}
		
		// set the current turn to the first actor in the turn order.
		//turn = combatants.size();
		
		return status; // No problems with battle initialization.
		
	}
	
	public void generateTargets() { // resets the party lists to include valid targets. (fast fix)
		// Generate Party List
		party1.clear();
		party2.clear();
		
		for(int index = 0; index < combatants.size(); index++) {
			if(combatants.get(index) instanceof Player) {
				if (combatants.get(index).getStat(STS.HP) > 0) {
					party1.add(index);
				}
			} else {
				if (combatants.get(index).getStat(STS.HP) > 0) {
					party2.add(index);
				}
			}
		}
	}
	
	public void round() { // Function that plays a full Round (Each Actor takes one turn.)
		// This function is called after the user inputs all their character action and target selections.
		// It generates actions for each monster. Then it traverses the combatants array, and
		// performs the actions selected for each actor against their selected target. It ceases
		// execution at the end of the round while the Battle Service awaits new input for the next round.
		
		// Pre-Round calculations...
		
		// call on the action for each combatant.
		System.out.println("START OF NEW ROUND");
		
		for(int turn = combatants.size() - 1; turn >= 0 ; turn-- ) {
			int damage = 0;
			Actor actor = combatants.get(turn);
			// If the Actor can take a turn (Future Logic reminder)
			if(actor.isAlive()) {
				Action action = actor.act(party1, party2); // pass in parties to let actors make their own selections.
				action.setUser(turn);
				System.out.println(action.declare());
				int[] targets = action.getTargets();
				for (int index = 0; index < targets.length; index++) {
					Actor target = combatants.get(targets[index]);
					damage = target.defend(action);
					if(target.getStat(STS.HP) <= 0) {
						System.out.println(target.getName() + " fell!");
					}
				} 
			} else { System.out.println(actor.getName() + " is not able to fight."); }
				System.out.println("");
			// Post-Turn Calculations
			generateTargets();
			victoryCheck();
		}

		
		// Post-Round calculations...
		
	}
	
	public void victoryCheck() {
		boolean playersAlive = false;
		boolean monstersAlive = false;
		//System.out.println("In Victory Check");
		//System.out.println("Player Party size: " + party1.size());
		for(int index = 0; index < party1.size(); index++) {
			//System.out.println("Player Check Index: " + index);
			//System.out.println("Checking " + combatants.get(party1.get(index)).getName());
			if(combatants.get(party1.get(index)).getStat(STS.HP) > 0 ) {
				//System.out.println("Alive");
				playersAlive = true;
			}
		}
		//System.out.println("Monster Party size: " + party2.size());
		for(int index = 0; index < party2.size(); index++) {
			//System.out.println("Monster Check Index: " + index);
			//System.out.println("Checking " + combatants.get(party2.get(index)).getName());
			if(combatants.get(party2.get(index)).getStat(STS.HP) > 0 ) {
				//System.out.println("Alive");
				monstersAlive = true;
			}
		}
		// if either party is entirely knocked out, declare a victory status.
		// monsters checked first, because a victory doesn't matter if the
		// player's party is somehow also dead.
		if(!monstersAlive) {status = 1;}
		if(!playersAlive) {status = -1;}
	}
	public void action() { // stub function. Will eventually need data passed into it.
		// To generate a target, we need to know valid selections. Monsters should target players.
		// players should target monsters - until/if other valid selections are implemented.
		// In the meantime, separating the combatants into two lists - one for monsters and one
		// for players will suffice in creating target options.
		
		// If the current actor is a monster, choose a random action and target from its spell list.
		// (currently, mock a standard attack.)
		// Output the result as a string (to be given to the front end.)
		
		
		// else: The logic should pause to wait for instructions from the user,
		// in the form of a spell and a target.
		// Output the result as a string (to be given to the front end.)
		
		// After all the action logic has passed, subtract one from the turn.
		// The Battle Service will then select the next Actor in the array and call action().
	}
	
	public Comparator<Actor> speedCompare = new Comparator<Actor>() {
		@Override
		public int compare(Actor o1, Actor o2) {
			Integer s1 = o1.getStat(STS.SPD);
			Integer s2 = o2.getStat(STS.SPD);
			return s1.compareTo(s2);
		}
	};
}