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
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.project2.daos.ActorDAOImpl;
import com.revature.project2.pojo.Actor;
import com.revature.project2.pojo.Stats;
import com.revature.project2.util.SessionFactoryUtil;

@RunWith(MockitoJUnitRunner.class)
public class ActorDaoTest {

	@Mock
	SessionFactory sf;
	
	@Mock
	Session sess;
	
	@Mock
	Transaction tx;
	
	private ActorDAOImpl actorDao = new ActorDAOImpl();
	
	private Actor actor;
	
	private Stats stats;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		stats = new Stats(15,10,5,1,1,1);
		actor = new Actor(1, "Warrior", stats, "Heroes");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getPlayerByIdTest() {
		when(sf.openSession()).thenReturn(sess);
		when(sess.get(Actor.class, 1)).thenReturn(actor);
		actorDao.setSf(sf);
		assertEquals("should return expected actor", actor, actorDao.getActorById(actor.getId()));
	}
	
	@Test
	public void getPlayerByIdIntegrationTest() {
		Session realSess = SessionFactoryUtil.getSessionFactoryUtil().getSessionFactory().openSession();
		realSess = Mockito.spy(realSess);
		when(sf.openSession()).thenReturn(realSess);
		actorDao.setSf(sf);
		Actor testActor = actorDao.getActorById(1);
		assertEquals("should return expected player", testActor, actor);
	}
	
}
