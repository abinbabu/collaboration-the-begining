package com.niit.JUtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;

public class UserJUtest {
	
	@Autowired
	UserDAO userDAO;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");


	}

	@Test
	public void UserTestCase()
	{
		int size = userDAO.listUser().size();
		assertEquals("user list test case ", 2, size);
		
	}
	
	
	

}
