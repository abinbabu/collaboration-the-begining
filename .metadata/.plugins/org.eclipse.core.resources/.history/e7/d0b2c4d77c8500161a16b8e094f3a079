package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.ForumDAO;
import com.niit.DAO.ForumPostCommentDAO;
import com.niit.DAO.ForumPostDAO;
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
    
    
	

}
