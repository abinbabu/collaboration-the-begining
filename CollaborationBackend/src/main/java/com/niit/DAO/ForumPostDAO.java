package com.niit.DAO;

import java.util.List;

import com.niit.model.ForumPost;

public interface ForumPostDAO {
	
	void saveOrUpdateForumPost(ForumPost forumPost);
	
	void deleteForumPost(String forumPostId);
	
	ForumPost getForumPost(String forumPostId);
	
	List<ForumPost> listForumPosts();

}
