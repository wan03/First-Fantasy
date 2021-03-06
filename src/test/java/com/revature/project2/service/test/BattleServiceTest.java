package com.revature.project2.service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.project2.pojo.Action;
import com.revature.project2.pojo.Actor;
import com.revature.project2.pojo.Monster;
import com.revature.project2.pojo.Player;
import com.revature.project2.pojo.Stats;
import com.revature.project2.pojo.TargetParams;
import com.revature.project2.service.BattleService;
import com.revature.project2.service.FieldService;
import com.revature.project2.util.ELM;
import com.revature.project2.util.STS;
import com.revature.project2.util.TGT;

public class BattleServiceTest {

	BattleService bs;
	FieldService fs;
	
	Actor player1 = new Player();
	Actor player2 = new Player();
	Actor player3 = new Player();
	Actor player4 = new Player();
	
	Actor monster1 = new Monster();
	Actor monster2 = new Monster();
	Actor monster3 = new Monster();
	Actor monster4 = new Monster();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		fs = FieldService.getField();
		bs = BattleService.getBattleService();
		
//		ArrayList<Integer> targ1 = new ArrayList<Integer>();
//		targ1.add(1);
//		
//		ArrayList<Integer> targ2 = new ArrayList<Integer>();
//		targ2.add(0);
//		
//		player1.setId(50);
//		player1.setFid(5);
//		player1.setName("warrior");
//		player1.setStats(new Stats(5,5,5,5,5,5,5,5,5,5,5));
//		player1.setAction(new Action("attack",0, "warrior", new TargetParams(1,1,0),0,1,2,0,0,0));
//		player1.setParty("Heroes");
//		player1.setReady(false);
//		player1.setTargets(targ1);
//		
//		player2.setId(99);
//		player2.setFid(9);
//		player2.setName("warrior");
//		player2.setStats(new Stats(5,5,5,5,5,5,5,5,5,5,5));
//		player2.setAction(new Action("attack",0, "warrior", new TargetParams(1,1,0),0,1,2,0,0,0));
//		player2.setParty("Monsters");
//		player2.setReady(false);
//		player2.setTargets(targ2);
		
		Stats gob1Stats = new Stats(25,15,10,5,5,3);
		Stats gob2Stats = new Stats(25,15,10,5,5,3);
		Stats gob3Stats = new Stats(25,15,10,5,5,3);
		Stats gob4Stats = new Stats(25,15,10,5,5,3);
		Stats warStats = new Stats(30,15,10,5,5,5);
		Stats magStats = new Stats(25,5,5,10,8,5);
		Stats grdStats = new Stats(35,15,12,5,8,3);
		Stats hlrStats = new Stats(25,5,8,8,5,7);
		
		Action gobpunch = new Action();
		gobpunch.setName("Goblin Punch");
		gobpunch.setTargets(TGT.ENEMY, TGT.NOTSELF, TGT.ALIVE);
		
		Action warpunch = new Action();
		warpunch.setName("Punch");
		warpunch.setTargets(TGT.ENEMY, TGT.NOTSELF, TGT.ALIVE);
		
		Action magspell = new Action();
		magspell.setName("Spell");
		magspell.setAstat(STS.MATK.getValue());
		magspell.setDstat(STS.MDEF.getValue());
		magspell.setTstat(STS.DEF);
		magspell.setTargets(TGT.ENEMY, TGT.NOTSELF, TGT.ALIVE);
		
		Action hlrspell = new Action();
		hlrspell.setName("Heal");
		hlrspell.setAstat(STS.MDEF.getValue());
		hlrspell.setDstat(STS.NA.getValue());
		hlrspell.setFocus(TGT.SPREAD);
		hlrspell.setElement(ELM.HEAL);
		hlrspell.setTargets(TGT.ALLY, TGT.SELF, TGT.ALIVE);
		
		List<Integer> wartarg = new ArrayList<Integer>(Arrays.asList(4,5));
		List<Integer> magtarg = new ArrayList<Integer>(Arrays.asList(6,7));
		List<Integer> grdtarg = new ArrayList<Integer>(Arrays.asList(4,5,6,7));
		List<Integer> hlrtarg = new ArrayList<Integer>(Arrays.asList(0,1,2,3));
		

		
		monster1.setName("Goblin1");
		monster1.setStats(gob1Stats);
		monster1.setAction(gobpunch);
		monster1.setParty("Monsters");
		
		monster2.setName("Goblin2");
		monster2.setStats(gob2Stats);
		monster2.setAction(gobpunch);
		monster2.setParty("Monsters");
		
		monster3.setName("Goblin3");
		monster3.setStats(gob3Stats);
		monster3.setAction(gobpunch);
		monster3.setParty("Monsters");
		
		monster4.setName("Goblin4");
		monster4.setStats(gob4Stats);
		monster4.setAction(gobpunch);
		monster4.setParty("Monsters");
		
		player1.setName("Warrior");
		player1.setStats(warStats);
		player1.setAction(warpunch);
		player1.setTargets(wartarg);
		player1.setParty("Heroes");
		
		player2.setName("Mage");
		player2.setStats(magStats);
		player2.setAction(magspell);
		player2.setTargets(magtarg);
		player2.setParty("Heroes");
		
		player3.setName("Guard");
		player3.setStats(grdStats);
		player3.setAction(warpunch);
		player3.setTargets(grdtarg);
		player3.setParty("Heroes");
		
		player4.setName("Healer");
		player4.setStats(hlrStats);
		player4.setAction(hlrspell);
		player4.setTargets(hlrtarg);
		player4.setParty("Heroes");
		
		fs.addCombatant(player1);
		fs.addCombatant(player2);
		fs.addCombatant(player3);
		fs.addCombatant(player4);
		fs.addCombatant(monster1);
		fs.addCombatant(monster2);
		fs.addCombatant(monster3);
		fs.addCombatant(monster4);
		
		for (int index = 0; index < fs.numberOfCombatants(); index++) {
			fs.getCombatant(index).setReady(true);
		}
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void VictoryCheckNone() {
		bs.initialize();
		bs.victoryCheck();
		assertEquals("There should be no victory yet.", 0 , bs.getStatus());
	}
	
	@Test
	public void VictoryCheckSucess() {
		bs.initialize();
		monster1.setStat(STS.HP, 0);
		monster2.setStat(STS.HP, 0);
		monster3.setStat(STS.HP, 0);
		monster4.setStat(STS.HP, 0);
		bs.victoryCheck();
		assertEquals("Monsters Defeated, Victory!", 1 , bs.getStatus());
	}
	
	@Test
	public void VictoryCheckFail() {
		bs.initialize();
		player1.setStat(STS.HP, 0);
		player2.setStat(STS.HP, 0);
		player3.setStat(STS.HP, 0);
		player4.setStat(STS.HP, 0);
		bs.victoryCheck();
		assertEquals("Monsters Defeated, Victory!", -1 , bs.getStatus());
	}
	
	@Test
	public void testNext() {
		assertEquals("Should return a valid player with highest speed: healer.", "Healer", fs.getCombatant(fs.next()).getName());
	}
	
	@Test
	public void BattleRoundCheck() {
		for (int rounds = 0; rounds < 3; rounds++) {
			System.out.println(bs.round());
			for (int index = 0; index < fs.numberOfCombatants(); index++) {
				fs.getCombatant(index).setReady(true);
			}
		}
		System.out.println("Victory Status: " + bs.getStatus());
		assertEquals("Victory Status", 0 , bs.getStatus());
	}

}