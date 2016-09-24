package com.niit.JUtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ForumPostDAO;

public class ForumPostJUtest {

	@Autowired
	ForumPostDAO forumpostDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumpostDAO =(ForumPostDAO) context.getBean("forumpostDAO");
	}
	
	@Test
	public void ForumPostTestCase()
	{
		int size = forumpostDAO.listForumPosts().size();
		assertEquals("forum post test case ", 1, size);
	}
}
