package com.revature.project2.pojo;

import java.util.List;

public interface BattleInterface {

	public Action act(List<Integer> p1, List<Integer> p2); // returns an array. The first element is the action used, the second is the target.
	
	public int defend(Action action);
}
