package com.revature.project2.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.revature.project2.service.FieldService;
import com.revature.project2.util.STS;

@Entity
@Table(name = "actor")
public class Actor {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Transient
	private int fid;				// The Character's Field ID - their location in the Field Service Combatants array.
	
	@Column(name = "name")
	private String name;
	
	//private String cclass;
	
	private Stats stats;
	
	//private int exp;
	
	//private Buffs[]
	
	//private Equipment[] equip;
	
	//private Spells[] spell;
	
	@Transient
	private Action action;			// The prepared action the Actor will take this round.
	
	@Column(name = "party")
	private String party;
	
	@Transient
	private boolean ready;			// Whether the character is ready to perform an action (or has performed already.)
	
	@Transient
	private List<Integer> targets;
	
	@Transient
	FieldService fs;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFid() {
		return fid;
	}
	
	public void setFid(int id) {
		this.fid = id;
	}
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
	
	public void setReady(boolean ready) {
		this.ready = ready;
	}
	public boolean isReady() {
		return ready;
	}
	
	public void setAction(Action action) {
		this.action = action;
		this.action.setUser(this.fid);
		this.action.setUName(this.name);
	}
	
	public Action getAction() {
		return action;
	}
	
	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}
	
	
	public List<Integer> getTargets() {
		return targets;
	}

	public void setTargets(List<Integer> targets) {
		this.targets = targets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + fid;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((party == null) ? 0 : party.hashCode());
		result = prime * result + (ready ? 1231 : 1237);
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
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (fid != other.fid)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (party == null) {
			if (other.party != null)
				return false;
		} else if (!party.equals(other.party))
			return false;
		if (ready != other.ready)
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
		return "Actor [id=" + id + ", fid=" + fid + ", name=" + name + ", stats=" + stats + ", action=" + action
				+ ", party=" + party + ", ready=" + ready + ", targets=" + targets + "]";
	}

	public Actor() {
		super();
		this.id = 0;
		this.fid = 0;
		this.name = "Character";
		this.stats = new Stats();
		this.action = new Action();
		this.party = "None";
		this.ready = false;
		this.fs = FieldService.getField();
		this.targets = new ArrayList<Integer>();
	}

	public Actor(int id, String name, Stats stats, String party) {
		super();
		this.id = id;
		this.name = name;
		this.stats = stats;
		this.party = party;
	}

}