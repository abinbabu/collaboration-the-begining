package com.niit.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ForumDAO;
import com.niit.model.Forum;



public class ForumTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		ForumDAO forumDAO = (ForumDAO) context.getBean("forumDAO");
		Forum forum = (Forum) context.getBean("forum");
		
		forum.setForumId("fr1");
		forum.setUserId("US1");
		forum.setForumTitle("first forum");
		forum.setForumDescription("ithil velya description onnum illa ithil velya description onnum illa");
		forum.setNoOfPosts('1');
		forum.setStatus('A');
		forum.setDateTime(new Date(System.currentTimeMillis()));
		forumDAO.saveOrUpdateForum(forum);
		
		if(forumDAO.getForum("fr11")== null)
		{
			System.out.println("forum does not exist");
		}
		else
		{
			System.out.println("forum exists..");
			System.out.println();
		} 
		
		
		
		

	}

}
