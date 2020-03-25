package com.revature.project2.util;

import com.revature.project2.pojo.User;

public interface Authentication {
	
	public User validateUser(String username, String password);

}
