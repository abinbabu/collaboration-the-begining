package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

@RestController
public class UserController {
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	@GetMapping("/users/")
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> listOfUsers = userDAO.listUser();
		if (listOfUsers.isEmpty()) {
			return new ResponseEntity <List<User>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity < List < User >> (listOfUsers, HttpStatus.OK);
	}

}
