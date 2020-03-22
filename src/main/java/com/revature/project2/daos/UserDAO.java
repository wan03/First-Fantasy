package com.revature.project2.daos;

import com.revature.project2.exceptions.UserInsertionException;
import com.revature.project2.pojo.User;

public interface UserDAO {
	
	public User getUserByEmail(String email);
	
	public User getUserByName(String name);
	
	public void addNewUser(User user) throws UserInsertionException;
	
	public void updateUser(User user) throws UserInsertionException;
	
}
