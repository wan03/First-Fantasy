package com.revature.project2.service.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.project2.pojo.Action;
import com.revature.project2.pojo.Monster;
import com.revature.project2.pojo.Player;

import com.revature.project2.service.BattleService;

import com.revature.project2.util.STS;

public class BattleServiceTest {

	BattleService bs = new BattleService();
	
	Player player1 = new Player();
	Player player2 = new Player();
	Monster monster1 = new Monster();
	Monster monster2 = new Monster();
	Action action = new Action();
	Action action2 = new Action();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		int pHP = 30;
		int mHP = 30;
		int pATK = 15;
		int mATK = 10;
		int pDEF = 5;
		int mDEF = 10;

		action.setName("Punch");
		action.setAstat(STS.ATK.getValue());
		action.setDstat(STS.DEF.getValue());
		action.setTstat(STS.HP.getValue());
		
		action2.setName("Spell");
		action2.setAstat(STS.MATK.getValue());
		action2.setDstat(STS.MDEF.getValue());
		action2.setTstat(STS.DEF.getValue());
		
		player2.setName("Player2");
		monster2.setName("Monster2");
		player1.setStat(STS.SPD, 0);
		player1.setStat(STS.HP, pHP);
		player1.setStat(STS.ATK, pATK);
		player1.setStat(STS.DEF, pDEF);
		player1.setAction(action);
		monster2.setStat(STS.SPD, 1);
		monster2.setStat(STS.HP, mHP);
		monster2.setStat(STS.ATK, mATK);
		monster2.setStat(STS.DEF, mDEF);
		monster2.setAction(action);
		player2.setStat(STS.SPD, 2);
		player2.setStat(STS.HP, pHP);
		player2.setStat(STS.MATK, pATK);
		player2.setStat(STS.DEF, pDEF);
		player2.setAction(action2);
		monster1.setStat(STS.SPD, 3);
		monster1.setStat(STS.HP, mHP);
		monster1.setStat(STS.ATK, mATK);
		monster1.setStat(STS.DEF, mDEF);
		monster1.setAction(action);
		bs.combatants.add(player1);
		bs.combatants.add(player2);
		bs.combatants.add(monster1);
		bs.combatants.add(monster2);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void SortTest() {
		bs.combatants.sort(bs.speedCompare);
		for(int i = 0; i < bs.combatants.size(); i++) {
			System.out.println(bs.combatants.get(i));
		}
		assertEquals("Not yet implemented", 0 , bs.combatants.get(0).getStat(STS.SPD));
	}
	
	@Test
	public void VictoryCheck() {
		bs.initialize();
		bs.victoryCheck();
		assertEquals("Victory Status", -1 , bs.status );
	}
	
	@Test
	public void BattleRoundCheck() {
		bs.initialize();
		while(bs.status == 0) {
			bs.round();
		}
		System.out.println("Victory Status: " + bs.status);
		assertEquals("Victory Status", 1 , bs.status );
	}

}