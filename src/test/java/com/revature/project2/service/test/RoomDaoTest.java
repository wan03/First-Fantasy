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

import com.revature.project2.daos.RoomDAOImpl;
import com.revature.project2.pojo.Room;

@RunWith(MockitoJUnitRunner.class)
public class RoomDaoTest {

	@Mock
	SessionFactory sf;
	
	@Mock
	Session sess;
	
	@Mock
	Transaction tx;
	
	private RoomDAOImpl roomDao = new RoomDAOImpl();
	
	private Room room;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		room = new Room();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getRoomByNameTest() {
		when(sf.openSession()).thenReturn(sess);
		when(sess.get(Room.class, "Plain Room")).thenReturn(room);
		roomDao.setSf(sf);
		System.out.println(room.getName());
		assertEquals("should return expected room", room, roomDao.getRoomByName(room.getName()));
	}

}
