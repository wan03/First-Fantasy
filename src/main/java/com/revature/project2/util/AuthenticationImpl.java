package com.revature.project2.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.daos.UserDAO;
import com.revature.project2.pojo.User;

@Service
public class AuthenticationImpl implements Authentication{

	private static UserDAO userDao;
	
	@Autowired
	public void setUserDAO(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public User validateUser(String username, String password) {
		User user = userDao.getUserByName(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	
	
}
