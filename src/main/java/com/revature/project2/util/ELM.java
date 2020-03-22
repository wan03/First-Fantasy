package com.revature.project2.util;

import java.util.HashMap;
import java.util.Map;

public enum ELM {

	 PHYS(0),
	 MAGIC(1),
	 HEAL(2);

	
	private int value;
   private static Map map = new HashMap<>();

   private ELM(int value) {
       this.value = value;
   }

   static {
       for (ELM elm : ELM.values()) {
           map.put(elm.value, elm);
       }
   }

   public static ELM valueOf(int elm) {
       return (ELM) map.get(elm);
   }

   public int getValue() {
       return value;
   }
}
