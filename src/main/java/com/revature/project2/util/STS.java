package com.revature.project2.util;

import java.util.HashMap;
import java.util.Map;

// The purpose of this enumeration is to enable developers to grab a desired Stat from a Stat Object using a single command.
// It simplifies retrieving stats as well as provides alternate names for them.
public enum STS {
	 HP(0), 
	 STAM(0),
	 STAMINA(0),
	 ATK(1),
	 STR(1),
	 STRENGTH(1),
	 DEF(2),
	 CON(2),
	 CONSTITUTION(2),
	 MATK(3),
	 INTEL(3),
	 INTELLIGENCE(3),
	 MDEF(4),
	 WIS(4),
	 WISDOM(4),
	 SPD(5),
	 RFLX(5),
	 SPEED(5),
	 ACC(6),
	 ACCURACY(6),
	 EVD(7),
	 EVADE(7),
	 CRIT(8),
	 CRITICAL(8),
	 CHR(9),
	 CHARISMA(9),
	 DEX(10),
	 DEXTERITY(10);
	
	private int value;
    private static Map map = new HashMap<>();

    private STS(int value) {
        this.value = value;
    }

    static {
        for (STS stat : STS.values()) {
            map.put(stat.value, stat);
        }
    }

    public static STS valueOf(int stat) {
        return (STS) map.get(stat);
    }

    public int getValue() {
        return value;
    }

}