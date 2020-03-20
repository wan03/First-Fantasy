package com.revature.project2.pojo;

import java.util.List;

import com.revature.project2.util.STS;

public abstract class Actor implements BattleInterface {
	String name;
	//String cclass;
	Stats stats;
	//int exp;
	//Buffs[]
	//Equipment[] equip;
	//Spells[] spell;
	Action action;			// The prepared action the Actor will take this round.
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Stats getStats() {
		return stats;
	}
	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	public int getStat(STS stat) {
		return this.stats.getStat(stat);
	}
	
	public int getStat(int stat) {
		return this.stats.getStat(stat);
	}
	
	public void setStat(STS stat, int value) {
		this.stats.setStat(stat, value);
	}
	
	public void setStat(int stat, int value) {
		this.stats.setStat(stat, value);
	}
	
	public boolean isAlive() {
		boolean result = false;
		if (this.getStat(STS.HP) > 0) { result = true; }
		return result;
	}
	
	public boolean isReady() {
		if(action.getName().matches("Default")) { // This action hasn't been set outside the constructor.
			return false;
		} else { return true; }
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	
	public Action getAction() {
		return action;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stats == null) ? 0 : stats.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stats == null) {
			if (other.stats != null)
				return false;
		} else if (!stats.equals(other.stats))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Character [name=" + name + ", stats=" + stats + "]";
	}
	
	public Actor() {
		super();
		stats = new Stats();
		name = "Character";
		action = new Action();
	}

	public abstract Action act(List<Integer> p1, List<Integer> p2);
	
}
