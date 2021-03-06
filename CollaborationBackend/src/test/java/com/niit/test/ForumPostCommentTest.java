package com.niit.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ForumPostCommentDAO;
import com.niit.model.ForumPostComment;



public class ForumPostCommentTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		ForumPostCommentDAO forumpostCommentDAO = (ForumPostCommentDAO) context.getBean("forumpostcommentDAO");
		ForumPostComment forumpostComment = (ForumPostComment) context.getBean("forumPostComment");
		
		forumpostComment.setForumPostCommentId("fpc1");
		forumpostComment.setForumPostId("fp1");
		forumpostComment.setForumId("fr1");
		forumpostComment.setUserId("US");
		forumpostComment.setForumPostCommentContent("oops no content oops no content oops no content");
		forumpostComment.setDateTime(new Date(System.currentTimeMillis()));
		
		forumpostCommentDAO.saveOrUpdateForumPostComment(forumpostComment);
		
		if(forumpostCommentDAO.getForumPostComment("fpc1")== null)
		{
			System.out.println("forum post comment does not exist");
		}
		else
		{
			System.out.println("forum post comment exists..");
			System.out.println();
		} 
	}

}
