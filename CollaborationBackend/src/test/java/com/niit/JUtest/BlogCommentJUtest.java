package com.niit.JUtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogCommentDAO;

public class BlogCommentJUtest {

	@Autowired
	BlogCommentDAO blogCommentDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogCommentDAO = (BlogCommentDAO) context.getBean("blogCommentDAO");
	}
	
	@Test
	public void BlogCommentTestCase()
	{
		int size = blogCommentDAO.listBlogComments().size();
		assertEquals("blogcomment list test case ", 1, size);
	}
}
