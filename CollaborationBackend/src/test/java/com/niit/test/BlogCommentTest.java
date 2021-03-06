package com.niit.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogCommentDAO;
import com.niit.model.BlogComment;

public class BlogCommentTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		BlogCommentDAO blogCommentDAO = (BlogCommentDAO) context.getBean("blogCommentDAO");
		BlogComment blogComment = (BlogComment) context.getBean("blogComment");
		
		
		blogComment.setBlogCommentId("blg1");
		blogComment.setUserId("US1");
		blogComment.setBlogCommentContent("comment comment comment comment comment comment ");
		blogComment.setDateTime(new Date(System.currentTimeMillis()));
		
		
		blogCommentDAO.saveOrUpdateBlogComment(blogComment);
		
		if(blogCommentDAO.getBlogComment("blg1")== null)
		{
			System.out.println("blog comment does not exist");
		}
		else
		{
			System.out.println("blog comment exists..");
			System.out.println();
		} 

	}

}
