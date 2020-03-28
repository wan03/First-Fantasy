package com.revature.project2.service;

import java.util.List;

import com.revature.project2.exceptions.UserInsertionException;
import com.revature.project2.pojo.User;

public interface UserService {
	
	public void registerUser(User user) throws UserInsertionException;
	
	public List<User> retrieveAllUsers();
	
	public User retrieveUserByEmail(String email);

}
