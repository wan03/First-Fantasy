package com.revature.project2.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.project2.daos.MonsterDAOImpl;
import com.revature.project2.pojo.Monster;
import com.revature.project2.pojo.Stats;

@RunWith(MockitoJUnitRunner.class)
public class MonsterDaoTest {

	@Mock
	SessionFactory sf;
	
	@Mock
	Session sess;
	
	@Mock
	Transaction tx;
	
	private MonsterDAOImpl monsterDao = new MonsterDAOImpl();
	
	private Monster monster;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//monster = new Monster(1, "Name", new Stats(), "Party");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getMonsterByIdTest() {
		when(sess.get(Monster.class, 1)).thenReturn(monster);
		when(sf.openSession()).thenReturn(sess);
		monsterDao.setSf(sf);
		assertEquals("should return expected monster", monster, monsterDao.getMonsterById(1));
	}

}
