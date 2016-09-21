package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

public class UserTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		UserDAO userDAO = (UserDAO) context.getBean("userDao");
		User user = (User) context.getBean("user");
		
		// Create Operation
		user.setId("US1");
		user.setName("user");
		user.setEmail("u@a.com");
		user.setPassword("password");
		user.setAddress("tcr");
		user.setMobile(944612345);
		
		userDAO.saveOrUpdateUser(user);
		
	    // categoryDAO.delete("CG01"); --> Delete Operation
		
	    //Retrieve Operation
	    if(userDAO.getUser("US1")== null)
		{
			System.out.println("USER does not exist");
		}
		else
		{
			System.out.println("USER exists..");
			System.out.println();
		} 
	}

}
