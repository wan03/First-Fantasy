package com.revature.project2.pojo;

import com.revature.project2.util.ELM;
import com.revature.project2.util.STS;
import com.revature.project2.util.TGT;

public class Action {

	private String name;			// Name of the Action.
	private int user;				// Which character is using it (Combatant Index)
	private String uName;			// The name of the character using it.
	TargetParams targets;			// The Conditions determining valid Targets.
	private int amount;				// The amount of offending damage to be applied to the defender.
	private int astat;				// The stat which the offending damage is calculated from.	(Attack by default.)
	private int dstat;				// The stat which defends against the offending damage.		(Defense by default.)
	private int tstat;				// The stat being targeted to be damaged.					(HP by default.)
	int element;					// The element of that damage (future stuff)
	//int dtype;					// The damage type - or how that damage is calculated. (Future stuff.)
	//int power;					// A modifier to enhance the damage. (future stuff.)
	int focus;						// expresses how many targets the action can hit (One or All currently.)

	
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
	
	public TargetParams getTargets() {
		return targets;
	}
	
	public void setTargets(TargetParams targets) {
		this.targets = targets;
	}
	
	public void setTargets(TGT party, TGT self, TGT dead) {
		this.targets.setParty(party);
		this.targets.setSelf(self);
		this.targets.setDead(dead);
	}
	
	public void setTargets(int party, int self, int dead) {
		this.targets.setParty(party);
		this.targets.setSelf(self);
		this.targets.setDead(dead);
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
	
	public void setDstat(STS dstat) {
		this.dstat = dstat.getValue();
	}
	
	public int getTstat() {
		return tstat;
	}
	
	public void setTstat(int tstat) {
		this.tstat = tstat;
	}
	
	public void setTstat(STS tstat) {
		this.tstat = tstat.getValue();
	}
	
	public int getAstat() {
		return astat;
	}

	public void setAstat(int astat) {
		this.astat = astat;
	}
	
	public void setAstat(STS astat) {
		this.astat = astat.getValue();
	}
	
	public String declare() {
		return uName + " used " + name + "!";
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}
	
	public void setElement(ELM element) {
		this.element = element.getValue();
	}
	
	public int getFocus() {
		return focus;
	}

	public void setFocus(int focus) {
		this.focus = focus;
	}
	
	public void setFocus(TGT focus) {
		this.focus = focus.getValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + astat;
		result = prime * result + dstat;
		result = prime * result + element;
		result = prime * result + focus;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((targets == null) ? 0 : targets.hashCode());
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
		if (element != other.element)
			return false;
		if (focus != other.focus)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (targets == null) {
			if (other.targets != null)
				return false;
		} else if (!targets.equals(other.targets))
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
		return "Action [name=" + name + ", user=" + user + ", uName=" + uName + ", targets=" + targets + ", amount="
				+ amount + ", astat=" + astat + ", dstat=" + dstat + ", tstat=" + tstat + ", element=" + element + "]";
	}

	public Action() {
		super();
		this.name = "Default";
		this.user = 0;
		this.uName = "";
		this.targets = new TargetParams(TGT.ALL, TGT.NOTSELF, TGT.ALIVE);
		this.amount = 0;
		this.astat = STS.ATK.getValue();
		this.dstat = STS.DEF.getValue();
		this.tstat = STS.HP.getValue();
		this.element = ELM.PHYS.getValue();
		this.focus = TGT.FOCUS.getValue();
	}

	public Action(String name, int user, String uName, TargetParams targets, int amount, int astat, int dstat, int tstat, int element, int focus) {
		super();
		this.name = name;
		this.user = user;
		this.uName = uName;
		this.targets = targets;
		this.amount = amount;
		this.astat = astat;
		this.dstat = dstat;
		this.tstat = tstat;
		this.element = element;
		this.focus = focus;
	}
	
	public Action(String name, int user, String uName, TargetParams targets, int amount, STS astat, STS dstat, STS tstat, ELM element, TGT focus) {
		super();
		this.name = name;
		this.user = user;
		this.uName = uName;
		this.targets = targets;
		this.amount = amount;
		this.astat = astat.getValue();
		this.dstat = dstat.getValue();
		this.tstat = tstat.getValue();
		this.focus = focus.getValue();
	}
}
