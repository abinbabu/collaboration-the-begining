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

import com.niit.DAO.ForumDAO;
import com.niit.DAO.ForumPostCommentDAO;
import com.niit.DAO.ForumPostDAO;
import com.niit.model.Blog;
import com.niit.model.Forum;
import com.niit.model.ForumPost;
import com.niit.model.ForumPostComment;

@RestController
public class ForumController {
	
	@Autowired
	Forum forum;
	
	@Autowired
	ForumDAO forumDAO;
	
	@Autowired
	ForumPost forumPost;
	
	@Autowired
	ForumPostDAO forumpostDAO;
	
    @Autowired
    ForumPostComment forumPostComment;
    
    @Autowired
    ForumPostCommentDAO forumpostcommentDAO;
    
    @GetMapping("/forums/")
	public ResponseEntity<List<Forum>> listAllForums() {
		List<Forum> listOfForums = forumDAO.listForums();
		if (listOfForums.isEmpty()) {
			return new ResponseEntity <List<Forum>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity < List < Forum >> (listOfForums, HttpStatus.OK);
	}
    
    
    @GetMapping("/forums/{forumId}")
	public ResponseEntity<Forum> getForum(@PathVariable("forumId") String forumId) {
		this.forum = forumDAO.getForum(forumId);
		if (forum == null) {
			return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Forum>(forum, HttpStatus.OK);

	}
    
    @PostMapping("/forums/")
	public ResponseEntity<Void> createForum(@RequestBody Forum forum,
			UriComponentsBuilder ucBuilder) {
		if (forumDAO.getForum(forum.getForumId()) != null) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}

		/*
		 * role.setId("ROLE_USER"); role.setName("ROLE_USER");
		 */
		forumDAO.saveOrUpdateForum(forum);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/forums/{forumId}/").buildAndExpand(forum.getForumId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}
    
    @PutMapping("/forums/{forumId}")
	public ResponseEntity<Forum> updateForum(@PathVariable("forumId")String forumId,@RequestBody Forum forum){
		
		if(forum==null){
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		forum.setForumId(forumId);
		

		
		forumDAO.saveOrUpdateForum(forum);

		return new ResponseEntity<Forum>(forum, HttpStatus.OK);

	}
	
    @DeleteMapping("/forums/{forumId}")
	public ResponseEntity<Forum> deleteForum(@PathVariable("forumId")String forumId){
	this.forum = forumDAO.getForum(forumId);
	if(this.forum==null){
		System.out.println("forum not exist to delete");
		return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		
	}
	
	forumDAO.deleteForum(forumId);
		return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
	
	}
}
