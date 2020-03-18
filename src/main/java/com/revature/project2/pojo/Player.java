package com.revature.project2.pojo;

import java.util.List;

import com.revature.project2.util.STS;

public class Player extends Actor implements BattleInterface{

	@Override
	public Action act(List<Integer> p1, List<Integer> p2) {
		int[] target = {p2.get(( 0 + (int)(Math.random() * p2.size())))};
		Action action = getAction();
		//action.setName("Punch");
		action.setUName(this.name);
		action.setAmount(this.stats.getStat(this.action.getAstat()));
		action.setTargets( target );
		//System.out.println("In Player.action(), result: " + result);
		return action;
	}
	
	@Override
	public int defend(Action action) {
		int current = this.getStat(action.getTstat()); // This should be the target stat passed in (future logic.)
		int apply = action.getAmount();
		// calculate hit/miss/critical? (future logic.)
		// reduce apply by the defending stat passed in (future logic.)
		apply -= getStat(action.getDstat());
		// apply the difference to the target stat.
		current -= apply;
		this.stats.setStat(action.getTstat(), current);
		// Declare the result of the action on the defender.
		System.out.println(this.getName() + " took " + apply + " damage! " 
		+ STS.valueOf(action.getTstat()) + "(" + this.getStat(action.getTstat()) + ")");
		//return the amount of damage actually done.
		return apply;
	}	
		
	public Player() {
		super();
		this.name = "Player";
	}

}
