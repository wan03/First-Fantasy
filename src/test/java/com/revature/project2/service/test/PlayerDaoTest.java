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

import com.revature.project2.daos.PlayerDAOImpl;
import com.revature.project2.pojo.Player;
import com.revature.project2.pojo.Stats;

@RunWith(MockitoJUnitRunner.class)
public class PlayerDaoTest {

	@Mock
	SessionFactory sf;
	
	@Mock
	Session sess;
	
	@Mock
	Transaction tx;
	
	private PlayerDAOImpl playerDao = new PlayerDAOImpl();
	
	private Player player;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		player = new Player(1, "Name", new Stats(), "Party");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getPlayerByIdTest() {
		when(sf.openSession()).thenReturn(sess);
		when(sess.get(Player.class, 1)).thenReturn(player);
		playerDao.setSf(sf);
		assertEquals("should return expected player", player, playerDao.getPlayerById(player.getId()));
	}

}
