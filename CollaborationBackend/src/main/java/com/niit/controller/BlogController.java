package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.DAO.BlogCommentDAO;
import com.niit.DAO.BlogDAO;
import com.niit.model.Blog;
import com.niit.model.BlogComment;


@RestController
public class BlogController {
	
	@Autowired
	Blog blog;

	@Autowired
	BlogComment blogComment;

	@Autowired
	BlogDAO blogDAO;

	@Autowired
	BlogCommentDAO blogCommentDAO;
	
	@GetMapping("/blogs/")
	public ResponseEntity<List<Blog>> listAllBlogs() {
		List<Blog> listOfBlogs = blogDAO.listBlogs();
		if (listOfBlogs.isEmpty()) {
			return new ResponseEntity <List<Blog>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity < List < Blog >> (listOfBlogs, HttpStatus.OK);
	}

	@GetMapping("/blogs/{blogId}")
	public ResponseEntity<Blog> getBlog(@PathVariable("blogId") String blogId) {
		this.blog = blogDAO.getBlog(blogId);
		if (blog == null) {
			return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Blog>(blog, HttpStatus.OK);

	}
	
	@PostMapping("/blogs/")
	public ResponseEntity<Void> createBlog(@RequestBody Blog blog,
			UriComponentsBuilder ucBuilder) {
		if (blogDAO.getBlog(blog.getBlogId()) != null) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}

		/*
		 * role.setId("ROLE_USER"); role.setName("ROLE_USER");
		 */
		blogDAO.saveOrUpdateBlog(blog);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("blogs/{blogId}/").buildAndExpand(blog.getBlogId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}
	
	@PutMapping("/blogs/{blogId}")
	public ResponseEntity<Blog> updateBlog(@PathVariable("blogId")String blogId,@RequestBody Blog blog){
		
		if(blog==null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
	 blog.setBlogId(blogId);
		

		
		blogDAO.saveOrUpdateBlog(blog);

		return new ResponseEntity<Blog>(blog, HttpStatus.OK);

	}
	@DeleteMapping("/blogs/{blogId}")
	public ResponseEntity<Blog> deleteBlog(@PathVariable("blogId")String blogId){
	this.blog = blogDAO.getBlog(blogId);
	if(this.blog==null){
		System.out.println("Blog not exist to delete");
		return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		
	}
	
		blogDAO.deleteBlog(blogId);
		return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
	
	}
}
