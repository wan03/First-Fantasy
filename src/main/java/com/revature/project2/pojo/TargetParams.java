package com.revature.project2.pojo;

import com.revature.project2.util.TGT;

public class TargetParams {

	private int party;
	private int self;
	private int dead;
	
	public int getParty() {
		return party;
	}
	
	public void setParty(int party) {
		if (party > 2) {party = 2;}
		if (party < 0) {party = 0;}
		this.party = party;
	}
	
	public void setParty(TGT party) {
		int temp = party.getValue();
		if (temp > 2) {temp = 2;}
		if (temp < 0) {temp = 0;}
		this.party = temp;
	}
	
	public int getSelf() {
		return self;
	}
	
	public void setSelf(int self) {
		if (self > 1) {self = 1;}
		if (self < 0) {self = 0;}
		this.self = self;
	}
	
	public void setSelf(TGT self) {
		int temp = self.getValue();
		if (temp > 1) {temp = 1;}
		if (temp < 0) {temp = 0;}
		this.self = temp;
	}
	
	public int getDead() {
		return dead;
	}
	
	public void setDead(int dead) {
		if (dead > 2) {dead = 2;}
		if (dead < 0) {dead = 0;}
		this.dead = dead;
	}
	
	public void setDead(TGT dead) {
		int temp = dead.getValue();
		if (temp > 2) {temp = 2;}
		if (temp < 0) {temp = 0;}
		this.dead = temp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dead;
		result = prime * result + party;
		result = prime * result + self;
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
		TargetParams other = (TargetParams) obj;
		if (dead != other.dead)
			return false;
		if (party != other.party)
			return false;
		if (self != other.self)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TargetParams [party=" + party + ", self=" + self + ", dead=" + dead + "]";
	}

	public TargetParams() {
		super();
		this.setParty(TGT.ENEMY.getValue());
		this.setSelf(TGT.NOTSELF.getValue());
		this.setDead(TGT.ALIVE.getValue());
	}

	public TargetParams(int party, int self, int dead) {
		super();
		this.setParty(party);
		this.setSelf(self);
		this.setDead(dead);
	}
	
	public TargetParams(TGT party, TGT self, TGT dead) {
		super();
		this.setParty(party.getValue());
		this.setSelf(self.getValue());
		this.setDead(dead.getValue());
	}
	
}