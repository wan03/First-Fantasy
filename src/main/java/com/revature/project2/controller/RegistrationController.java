package com.revature.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.project2.exceptions.UserInsertionException;
import com.revature.project2.pojo.User;
import com.revature.project2.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class RegistrationController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<HttpStatus> login(@RequestBody User user) {
			
			try {
				userService.registerUser(user);
				return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);			
			} catch (UserInsertionException e) {
				e.printStackTrace();
				return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
			}
			
		
	}

}
