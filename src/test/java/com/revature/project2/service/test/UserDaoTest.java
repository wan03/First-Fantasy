package com.revature.project2.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
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

import com.revature.project2.daos.UserDAOImpl;
import com.revature.project2.exceptions.UserInsertionException;
import com.revature.project2.pojo.User;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

	@Mock
	SessionFactory sf;
	
	@Mock
	Session sess;
	
	@Mock
	Transaction tx;
	
	private UserDAOImpl userDao = new UserDAOImpl();
	
	private User user;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user = new User("randomName", "randomEmail@email.com", "password");
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void getUserByNameTest() {
//		when(sf.openSession()).thenReturn(sess);
//		when(sess.get(User.class, "randomName")).thenReturn(user);
//		userDao.setSf(sf);
//		System.out.println(user.getName());
//		assertEquals("should return expected user", user, userDao.getUserByName(user.getName()));
//	}
	
//	@Test
//	public void getUserByEmailTest() {
//		when(sf.openSession()).thenReturn(sess);
//		when(sess.get(User.class, "randomEmail@email.com")).thenReturn(user);
//		userDao.setSf(sf);
//		System.out.println(user.getEmail());
//		assertEquals("should return expected user", user, userDao.getUserByName(user.getEmail()));
//	}
	
	@Test
	public void addNewUserTest() throws UserInsertionException {
		when(sess.beginTransaction()).thenReturn(tx);
		when(sf.openSession()).thenReturn(sess);
		userDao.setSf(sf);
		userDao.addNewUser(user);
		verify(sess).save(user);
	}
	
	@Test
	public void updateUserTest() throws UserInsertionException {
		when(sess.beginTransaction()).thenReturn(tx);
		when(sf.openSession()).thenReturn(sess);
		userDao.setSf(sf);
		userDao.updateUser(user);
		verify(sess).saveOrUpdate(user);
	}

}
