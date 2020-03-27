package com.revature.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.daos.UserDAO;
import com.revature.project2.exceptions.UserInsertionException;
import com.revature.project2.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDao;
	
	@Autowired
	public void setUserDAO(UserDAO userDao) {
		this.userDao = userDao;
	}
	
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
