package com.revature.project2.service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.project2.pojo.Action;
import com.revature.project2.pojo.Monster;
import com.revature.project2.pojo.Player;
import com.revature.project2.pojo.Stats;
import com.revature.project2.pojo.TargetParams;
import com.revature.project2.service.FieldService;
import com.revature.project2.util.STS;
import com.revature.project2.util.TGT;

public class FieldServiceTest {

	FieldService fs;
	Player player1 = new Player();
	Player player2 = new Player();
	Player player3 = new Player();
	Player player4 = new Player();
	
	Monster monster1 = new Monster();
	Monster monster2 = new Monster();
	Monster monster3 = new Monster();
	Monster monster4 = new Monster();
	
	List<Integer> expected = new ArrayList<Integer>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		Stats gob1Stats = new Stats(25,15,10,5,5,3);
		Stats gob2Stats = new Stats(25,15,10,5,5,3);
		Stats gob3Stats = new Stats(25,15,10,5,5,3);
		Stats gob4Stats = new Stats(25,15,10,5,5,3);
		Stats warStats = new Stats(30,15,10,5,5,5);
		Stats magStats = new Stats(25,10,5,15,10,5);
		Stats grdStats = new Stats(35,15,12,5,8,3);
		Stats hlrStats = new Stats(25,5,8,10,15,7);
		
		Action gobpunch = new Action();
		gobpunch.setName("Goblin Punch");
		
		Action warpunch = new Action();
		warpunch.setName("Punch");
		
		Action magspell = new Action();
		magspell.setName("Spell");
		magspell.setAstat(STS.MATK.getValue());
		magspell.setDstat(STS.MDEF.getValue());
		
		Action hlrspell = new Action();
		hlrspell.setName("Heal");
		hlrspell.setAstat(STS.MDEF.getValue());
		hlrspell.setDstat(STS.NA.getValue());
		
		monster1.setName("Goblin1");
		monster1.setStats(gob1Stats);
		monster1.setAction(gobpunch);
		
		monster2.setName("Goblin2");
		monster2.setStats(gob2Stats);
		monster2.setAction(gobpunch);
		
		monster3.setName("Goblin3");
		monster3.setStats(gob3Stats);
		monster3.setAction(gobpunch);
		
		monster4.setName("Goblin4");
		monster4.setStats(gob4Stats);
		monster4.setAction(gobpunch);
		
		player1.setName("Warrior");
		player1.setStats(warStats);
		player1.setAction(warpunch);
		
		player2.setName("Mage");
		player2.setStats(magStats);
		player2.setAction(magspell);
		
		player3.setName("Guard");
		player3.setStats(grdStats);
		player3.setAction(warpunch);
		
		player4.setName("Healer");
		player4.setStats(hlrStats);
		player4.setAction(hlrspell);
		
		fs = FieldService.getField();
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
	public void testNext() {
		assertEquals("Should return a valid player with highest speed: healer.", "Healer", fs.getCombatant(fs.next()).getName());
	}

	@Test
	public void testNextAgain() {
		player4.setReady(false);
		assertEquals("Healer has taken a turn. Who's next?", "Warrior", fs.getCombatant(fs.next()).getName());
	}
	
	@Test
	public void testNextAgainAgain() {
		player4.setReady(false);
		player1.setStat(STS.HP, 0);
		assertEquals("Ack! Warrior is dead. Who's next?", "Mage", fs.getCombatant(fs.next()).getName());
	}
	
	@Test
	public void testGetTargetDeadOnly() {
		expected.add(0);
		player1.setStat(STS.HP, 0);
		TargetParams params = new TargetParams(TGT.ALLY.getValue(),TGT.NOTSELF.getValue(), TGT.DEADONLY.getValue());
		List<Integer> result = fs.getTargets(player4.getFid(), params);
		System.out.println(result);
		assertEquals("Healer wants to revive Warrior, check targets.", expected, result);
	}
	
	@Test
	public void testGetTargetEnemyParty() {
		expected.add(4);
		expected.add(5);
		expected.add(6);
		expected.add(7);
		TargetParams params = new TargetParams(TGT.ENEMY.getValue(),TGT.NOTSELF.getValue(), TGT.ALIVE.getValue());
		List<Integer> result = fs.getTargets(player2.getFid(), params);
		System.out.println(result);
		assertEquals("Mage wants to use a spell on the whole enemy party, check targets.", expected, result);
	}
	
	@Test
	public void testGetTargetEnemyPartyWithDead() {
		expected.add(4);
		expected.add(6);
		expected.add(7);
		monster2.setStat(STS.HP, 0);
		TargetParams params = new TargetParams(TGT.ENEMY.getValue(),TGT.NOTSELF.getValue(), TGT.ALIVE.getValue());
		List<Integer> result = fs.getTargets(player2.getFid(), params);
		System.out.println(result);
		assertEquals("Mage wants to use a spell on the whole enemy party, check targets.", expected, result);
	}
	
	@Test
	public void testGetTargetAll() {
		expected.add(0);
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(6);
		expected.add(7);
		monster2.setStat(STS.HP, 0);
		TargetParams params = new TargetParams(TGT.ALL.getValue(),TGT.NOTSELF.getValue(), TGT.ALIVE.getValue());
		List<Integer> result = fs.getTargets(monster1.getFid(), params);
		System.out.println(result);
		assertEquals("Goblin1 wants revenge and uses spell targeting everyone.", expected, result);
	}
	
	@Test
	public void testGetTargetAlly() {
		expected.add(0);
		expected.add(1);
		expected.add(2);
		expected.add(3);
		TargetParams params = new TargetParams(TGT.ALLY.getValue(),TGT.SELF.getValue(), TGT.ALIVE.getValue());
		List<Integer> result = fs.getTargets(player4.getFid(), params);
		System.out.println(result);
		assertEquals("Healer wants to restore party HP.", expected, result);
	}
	
}
