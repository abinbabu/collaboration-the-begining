package com.niit.JUtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogDAO;

public class BlogJUtest {

	@Autowired
	BlogDAO blogDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogDAO = (BlogDAO) context.getBean("blogDAO");
	}
	
	@Test
	public void BlogTestCase()
	{
		int size = blogDAO.listBlogs().size();
		assertEquals("blog list test case ", 1, size);
	}
}
