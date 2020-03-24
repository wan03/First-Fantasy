package com.revature.project2.service;

import java.util.List;

import com.revature.project2.daos.UserDAO;
import com.revature.project2.daos.UserDAOImpl;
import com.revature.project2.exceptions.UserInsertionException;
import com.revature.project2.pojo.User;

public class UserServiceImpl implements UserService {
	
	private static UserDAO userDao = new UserDAOImpl();
	
	public void registerUser(User user) throws UserInsertionException {
		userDao.addNewUser(user);
	}
	

	public List<User> retrieveAllUsers() {
		return null;
	}

	public User retrieveUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}


}
