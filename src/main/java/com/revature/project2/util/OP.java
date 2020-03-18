package com.revature.project2.util;

import java.util.HashMap;
import java.util.Map;

// The purpose of this enumeration is to enable developers to grab a desired 
// Operation for working with Stat Modifiers. They are listed in the order
// in which they are applied.
public enum OP {
	 MULT(0),
	 DIV(1),
	 ADD(2), 
	 SUB(3),
	 PINC(4),	// Percent Increment: Increases the stat by a percent that stacks with other PINC and PDEC.
	 PDEC(5),	// Percent Decrement: decreases the stat by a percent that stacks with other PINC and PDEC.
	 PAMP(6),	// Percent Amplify: Increases a value by fraction of itself.
	 PRED(7),	// Percent Reduce: Decreases a value by a fraction of itself.
	 PSET(8);	// Percent Set: Sets the stat to a percentage of its current value.
	 			// Note: runs last, all other modifiers are performed first, therefore
				// this one carries the most weight.
	
	private int value;
    private static Map map = new HashMap<>();

    private OP(int value) {
        this.value = value;
    }

    static {
        for (OP op : OP.values()) {
            map.put(op.value, op);
        }
    }

    public static OP valueOf(int op) {
        return (OP) map.get(op);
    }

    public int getValue() {
        return value;
    }
}