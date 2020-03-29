package com.revature.project2.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.revature.project2.util.STS;

@Embeddable
public class Stats {

	@Column(name = "hp")
	private int hp;

	@Column(name = "atk")
	private int atk;

	@Column(name = "def")
	private int def;

	@Column(name = "matk")
	private int matk;

	@Column(name = "mdef")
	private int mdef;

	@Column(name = "spd")
	private int spd;

	@Column(name = "acc")
	private int acc;

	@Column(name = "evd")
	private int evd;

	@Column(name = "crit")
	private int crit;

	@Column(name = "chr")
	private int chr;

	@Column(name = "dex")
	private int dex;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getMatk() {
		return matk;
	}

	public void setMatk(int matk) {
		this.matk = matk;
	}

	public int getMdef() {
		return mdef;
	}

	public void setMdef(int mdef) {
		this.mdef = mdef;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public int getAcc() {
		return acc;
	}

	public void setAcc(int acc) {
		this.acc = acc;
	}

	public int getEvd() {
		return evd;
	}

	public void setEvd(int evd) {
		this.evd = evd;
	}

	public int getCrit() {
		return crit;
	}

	public void setCrit(int crit) {
		this.crit = crit;
	}

	public int getChr() {
		return chr;
	}

	public void setChr(int chr) {
		this.chr = chr;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getStat(int stat) {

		switch (stat) {
		case 0:
			return this.hp;
		case 1:
			return this.atk;
		case 2:
			return this.def;
		case 3:
			return this.matk;
		case 4:
			return this.mdef;
		case 5:
			return this.spd;
		case 6:
			return this.acc;
		case 7:
			return this.evd;
		case 8:
			return this.crit;
		case 9:
			return this.chr;
		case 10:
			return this.dex;
		default:
			return 0;
		}

	}

	public int getStat(STS stat) {

		return getStat(stat.getValue());

	}

	public void setStat(int stat, int value) {
		if(value <= 0) {value = 0;}
		switch (stat) {
		case 0:
			{this.hp = value; break;}
		case 1:
			{this.atk = value; break;}
		case 2:
			{this.def = value; break;}
		case 3:
			{this.matk = value; break;}
		case 4:
			{this.mdef = value; break;}
		case 5:
			{this.spd = value; break;}
		case 6:
			{this.acc = value; break;}
		case 7:
			{this.evd = value; break;}
		case 8:
			{this.crit = value; break;}
		case 9:
			{this.chr = value; break;}
		case 10:
			{this.dex = value; break;}
		}
	}

	public void setStat(STS stat, int value) {

		setStat(stat.getValue(), value);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acc;
		result = prime * result + atk;
		result = prime * result + chr;
		result = prime * result + crit;
		result = prime * result + def;
		result = prime * result + dex;
		result = prime * result + evd;
		result = prime * result + hp;
		result = prime * result + matk;
		result = prime * result + mdef;
		result = prime * result + spd;
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
		if (acc != other.acc)
			return false;
		if (atk != other.atk)
			return false;
		if (chr != other.chr)
			return false;
		if (crit != other.crit)
			return false;
		if (def != other.def)
			return false;
		if (dex != other.dex)
			return false;
		if (evd != other.evd)
			return false;
		if (hp != other.hp)
			return false;
		if (matk != other.matk)
			return false;
		if (mdef != other.mdef)
			return false;
		if (spd != other.spd)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stats [hp=" + hp + ", atk=" + atk + ", def=" + def + ", matk=" + matk + ", mdef=" + mdef + ", spd="
				+ spd + ", acc=" + acc + ", evd=" + evd + ", crit=" + crit + ", chr=" + chr + ", dex=" + dex + "]";
	}

	public Stats(int hp, int atk, int def, int matk, int mdef, int spd) {
		super();
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.matk = matk;
		this.mdef = mdef;
		this.spd = spd;
		this.acc = 1;
		this.evd = 1;
		this.crit = 1;
		this.chr = 1;
		this.dex = 1;
	}

	public Stats(int hp, int atk, int def, int matk, int mdef, int spd, int acc, int evd, int crit, int chr, int dex) {
		super();
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.matk = matk;
		this.mdef = mdef;
		this.spd = spd;
		this.acc = acc;
		this.evd = evd;
		this.crit = crit;
		this.chr = chr;
		this.dex = dex;
	}

	public Stats() {
		super();
	}
}