package com.revature.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.project2.pojo.User;
import com.revature.project2.util.Authentication;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class LoginController {

	private Authentication auth;
	
	@Autowired
	public void setAuthService(Authentication auth) {
		this.auth = auth;
	}
	
	@PostMapping("/login")
	public ResponseEntity<HttpStatus> login(@RequestBody User user) {
		User authUser = auth.validateUser(user.getEmail(), user.getPassword());
		if (authUser == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);			
		}
	}
}
