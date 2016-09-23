package com.niit.DAO;

import java.util.List;

import com.niit.model.Forum;

public interface ForumDAO {
	
	void saveOrUpdateForum(Forum forum);

	void deleteForum(String forumId);

	Forum getForum(String forumId);

	List<Forum> listForums();

}
