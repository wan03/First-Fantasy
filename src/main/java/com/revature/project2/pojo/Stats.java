package com.revature.project2.pojo;

import java.util.Arrays;

import com.revature.project2.util.STS;

public class Stats {

	private int stats[] = new int[11];
	
	public int getStat(STS stat) {
		return this.stats[stat.getValue()];
	}
	
	public int getStat(int stat) {
		return this.stats[stat];
	}
	
	public void setStat(STS stat, int value) {
		if (value < 0) { value = 0; }
		this.stats[stat.getValue()] = value;
	}
	
	public void setStat(int stat, int value) {
		if (value < 0) { value = 0; }
		this.stats[stat] = value;
	}
	
		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(stats);
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
		Stats other = (Stats) obj;
		if (!Arrays.equals(stats, other.stats))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Stats [stats=" + Arrays.toString(stats) + "]";
	}

	public Stats() {
		Arrays.fill(stats, 0);
	}
	
	public Stats(int hp, int atk, int def, int matk, int mdef, int spd) {
		this.setStat(STS.HP.getValue(), hp);
		this.setStat(STS.ATK.getValue(), atk);
		this.setStat(STS.DEF.getValue(), def);
		this.setStat(STS.MATK.getValue(), matk);
		this.setStat(STS.MDEF.getValue(), mdef);
		this.setStat(STS.SPD.getValue(), spd);
	}
}