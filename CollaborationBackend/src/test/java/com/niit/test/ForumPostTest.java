package com.niit.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ForumPostDAO;
import com.niit.model.ForumPost;



public class ForumPostTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		ForumPostDAO forumpostDAO = (ForumPostDAO) context.getBean("forumpostDAO");
		ForumPost forumpost = (ForumPost) context.getBean("forumPost");
		
		forumpost.setForumPostId("fp1");
		forumpost.setForumId("fr1");
		forumpost.setUserId("US1");
		forumpost.setForumPostContent("there is no content there is no content there is no content");
		forumpost.setDateTime(new Date(System.currentTimeMillis()));
		forumpostDAO.saveOrUpdateForumPost(forumpost);
		
		if(forumpostDAO.getForumPost("fp1")== null)
		{
			System.out.println("forum post does not exist");
		}
		else
		{
			System.out.println("forum post exists..");
			System.out.println();
		} 
		
		

	}

}
