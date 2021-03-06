package com.niit.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogDAO;
import com.niit.model.Blog;

public class BlogTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		BlogDAO blogDAO = (BlogDAO) context.getBean("blogDAO");
		Blog blog = (Blog) context.getBean("blog");
		
		
		blog.setBlogId("bg2");
		blog.setBlogTitle("starts");
		blog.setUserId("US1");
		blog.setBlogDescription("opsthis is first blog this is first blog"
				+"this is first blog this is first blog"
				+"this is first blog this is first blog"
				+"this is first blog this is first blog");
		
		blog.setStatus('A');
		blog.setDateTime(new Date(System.currentTimeMillis()));
		blogDAO.saveOrUpdateBlog(blog);
		
		if(blogDAO.getBlog("bg1")== null)
		{
			System.out.println("blog does not exist");
		}
		else
		{
			System.out.println("blog exists..");
			System.out.println();
		} 

	}

}
