package com.revature.project2.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.project2.pojo.User;
import com.revature.project2.pojo.UserAuth;
import com.revature.project2.util.Authentication;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class LoginController {
	private static final Logger log = Logger.getRootLogger();

	private Authentication auth;
	
	@Autowired
	public void setAuthService(Authentication auth) {
		this.auth = auth;
	}
	
	@PutMapping("/login")
	public ResponseEntity<HttpStatus> login(@RequestBody User user) {
		log.debug("PutMapping in login controller");
		User authUser = auth.validateUser(user.getEmail(), user.getPassword());
		if (authUser == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);			
		}
	}
}
