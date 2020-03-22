package com.revature.project2.util;

import java.util.HashMap;
import java.util.Map;

public enum TGT {

	 ALLY(0),
	 SELF(0),
	 ALIVE(0),
	 FOCUS(0),
	 ENEMY(1),
	 NOTSELF(1),
	 DEAD(1),
	 SPREAD(1),
	 ALL(2),
	 DEADONLY(2);
	
	private int value;
    private static Map map = new HashMap<>();

    private TGT(int value) {
        this.value = value;
    }

    static {
        for (TGT targ : TGT.values()) {
            map.put(targ.value, targ);
        }
    }

    public static TGT valueOf(int targ) {
        return (TGT) map.get(targ);
    }

    public int getValue() {
        return value;
    }
}
