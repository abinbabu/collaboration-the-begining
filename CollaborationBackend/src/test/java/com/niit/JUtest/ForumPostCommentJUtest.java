package com.niit.JUtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ForumPostCommentDAO;

public class ForumPostCommentJUtest {

	@Autowired
	ForumPostCommentDAO forumpostcommentDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumpostcommentDAO = (ForumPostCommentDAO) context.getBean("forumpostcommentDAO");
	}
	
	@Test
	public void ForumPostCommentTestCase()
	{
		int size = forumpostcommentDAO.listForumPostComments().size();
		assertEquals("ForumPostComment Test Case ", 1, size);
	}
	
}
