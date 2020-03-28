package com.revature.project2.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.project2.pojo.Actor;
import com.revature.project2.pojo.TargetParams;
import com.revature.project2.util.STS;
import com.revature.project2.util.TGT;

public class FieldService {

	private List<Actor> combatants;
	private static FieldService fs;
	
	public static FieldService getField() {
		if(fs == null) {
			fs = new FieldService();
		}
		return fs;
	}
	
	public List<Actor> getCombatants() {
		return combatants;
	}
	
	public void setCombatants(List<Actor> combatants) {
		this.combatants = combatants;
	}

	public Actor getCombatant(int index) {
		return this.combatants.get(index);
	}
	
	public void setCombatant(int index, Actor combatant) {
		this.combatants.set(index, combatant);
	}
	
	public void addCombatant(Actor combatant) {
		int size = combatants.size();			// get the current size before adding.
		this.combatants.add(combatant);
		combatants.get(size).setFid(size);		// use the previous size to set the fid of the new combatant.
	}
	
	public void clearCombatants() {
		combatants.clear();
	}
	
	public int numberOfCombatants() {
		return combatants.size();
	}
	
	// Method to return the index of a given combatant
	
	// Method to return the number of parties.
	
	// Method to return the number of combatants in a given party.
	public int numberInParty(String party) {
		int result = 0;
		for(int index = 0; index < combatants.size(); index++) {
			if(combatants.get(index).getParty().equals(party)) {
				result++;
			}
		}
		return result;
	}
	
	public boolean isPartyWiped(String party) {
		boolean result = true;
		for(int index = 0; index < combatants.size(); index++) {
			Actor query = combatants.get(index);
			if(query.getParty().equals(party)) {
				if(query.isAlive()) { result = false; break;}
			}
		}
		return result;
	}
	// method to return a party list with number of members?
	
	public int next(){
		int result = -1;
		int compare = 0;
		// return the next combatant (whoever is alive/ready and has the highest speed.)
		//System.out.println(combatants.size());
		for(int index = 0; index < combatants.size(); index++) {
			//System.out.println(combatants.get(index).getName() + " Alive: " + combatants.get(index).isAlive());
			//System.out.println(combatants.get(index).getName() + " IsReady: " + combatants.get(index).isReady());
			if(combatants.get(index).isAlive() && combatants.get(index).isReady()) {
				int speed = combatants.get(index).getStat(STS.SPD);
				if(compare < speed) {
					compare = speed;
					result = index;
				}
			}	
		}
		return result;
	}
	
	public List<Integer> getTargets(int selfIndex, TargetParams params){
		// return a list of valid targets following the target rules given.
		List<Integer> targets = new ArrayList<Integer>();
		String userParty = combatants.get(selfIndex).getParty();
		
		for(int index = 0; index < combatants.size(); index++) {
			
			String query = combatants.get(index).getName();
			boolean valid = false;
			boolean isAlive = combatants.get(index).isAlive();
			
			if (params.getParty() == TGT.ALL.getValue()) { valid = true; }	else { // if looking for everyone.
				 //System.out.println("Checking " + index + ": " + query + " - Alive = " + isAlive);
				// Is target in the same party (an ally)?
				 //System.out.println(combatants.get(index).getParty() + " " + userParty);
				if (combatants.get(index).getParty().equals(userParty)){ // is an ally...
					///System.out.println(query + " is an Ally.");
					if (params.getParty() == TGT.ALLY.getValue()) {		// looking for an ally...
						valid = true;
					} // else {  System.out.println(query + " is an invalid target as an ally.");}
				} else {												// is not an ally...
					//System.out.println(query + " is an Enemy.");
					if (params.getParty() == TGT.ENEMY.getValue()) {	// looking for an enemy...
						valid = true;
					}  //else {  System.out.println(query + " is an invalid target as an enemy."); }
				}
			}
			// If in the correct party, check independent validity.
			// instead of validating, we are now trying to invalidate.
			
			if(valid) {
				//System.out.println("Checking for invalidators (Death or Self)");
				// Is the target self?
				if (index == selfIndex) {
					if (params.getSelf() == TGT.NOTSELF.getValue()) {
						//System.out.println(query + " cannot target themselves.");
						valid = false;
					}
				}
				// is the target dead?
				if (!isAlive) { // if is not alive...
					if(params.getDead() == TGT.ALIVE.getValue()) { // only living targets wanted...
						 //System.out.println(query + " cannot target dead characters.");
						valid = false;
					}
				} else { // if is alive...
					if(params.getDead() == TGT.DEADONLY.getValue()) { // only dead targets wanted...
						 //System.out.println(query + " cannot target living characters with dead only actions.");
						valid = false;
					}
				}
			} // end invalidation check.
			
			if(valid) {	// if still valid
				targets.add(index);
			}
		}// end loop through combatants.

		return targets;
	}

	private FieldService() {
		super();
		combatants = new ArrayList<Actor>();
	}
	
}