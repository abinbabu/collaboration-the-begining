package com.niit.JUtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ForumDAO;

public class ForumJUtest {

	@Autowired
	ForumDAO forumDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumDAO = (ForumDAO) context.getBean("forumDAO");
	}
	
	@Test
	public void ForumTestCase()
	{
		int size = forumDAO.listForums().size();
		assertEquals("forum test case ", 1, size);
	}
		
}
