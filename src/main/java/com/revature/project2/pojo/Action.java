package com.revature.project2.pojo;

import java.util.Arrays;

import com.revature.project2.util.STS;

public class Action {

	private String name;			// Name of the Action.
	private int user;				// Which character is using it (Combatant Index)
	private String uName;			// The name of the character using it.
	private int[] targets = {0};	// Which characters are being targeted by it.
	private int amount;				// The amount of offending damage to be applied to the defender.
	private int astat;				// The stat which the offending damage is calculated from.	(Attack by default.)
	private int dstat;				// The stat which defends against the offending damage.		(Defense by default.)
	private int tstat;				// The stat being targeted to be damaged.					(HP by default.)
	//int element;					// The element of that damage (future stuff)
	//int dtype;					// The damage type - or how that damage is calculated. (Future stuff.)
	//int power;					// A modifier to enhance the damage. (future stuff.)
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getUser() {
		return user;
	}
	
	public void setUser(int user) {
		this.user = user;
	}
	
	public String getUName() {
		return uName;
	}
	
	public void setUName(String name) {
		this.uName = name;
	}
	
	public int[] getTargets() {
		return targets;
	}
	
	public void setTargets(int[] targets) {
		this.targets = targets;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getDstat() {
		return dstat;
	}
	
	public void setDstat(int dstat) {
		this.dstat = dstat;
	}
	
	public int getTstat() {
		return tstat;
	}
	
	public void setTstat(int tstat) {
		this.tstat = tstat;
	}
	
	public int getAstat() {
		return astat;
	}

	public void setAstat(int astat) {
		this.astat = astat;
	}
	
	public String declare() {
		return uName + " used " + name + "!";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + astat;
		result = prime * result + dstat;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(targets);
		result = prime * result + tstat;
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
		result = prime * result + user;
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
		Action other = (Action) obj;
		if (amount != other.amount)
			return false;
		if (astat != other.astat)
			return false;
		if (dstat != other.dstat)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(targets, other.targets))
			return false;
		if (tstat != other.tstat)
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		if (user != other.user)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Action [name=" + name + ", user=" + user + ", uName=" + uName + ", targets=" + Arrays.toString(targets)
				+ ", amount=" + amount + ", astat=" + astat + ", dstat=" + dstat + ", tstat=" + tstat + "]";
	}

	public Action() {
		super();
		this.name = "Default";
		this.user = 0;
		this.uName = "";
		this.amount = 0;
		this.astat = STS.ATK.getValue();
		this.dstat = STS.DEF.getValue();
		this.tstat = STS.HP.getValue();
	}

	public Action(String name, int user, String uName, int[] targets, int amount, int astat, int dstat, int tstat) {
		super();
		this.name = name;
		this.user = user;
		this.uName = uName;
		this.targets = targets;
		this.amount = amount;
		this.astat = astat;
		this.dstat = dstat;
		this.tstat = tstat;
	}

}