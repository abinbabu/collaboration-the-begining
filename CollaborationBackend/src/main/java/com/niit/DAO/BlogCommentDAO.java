package com.niit.DAO;

import java.util.List;

import com.niit.model.BlogComment;

public interface BlogCommentDAO {
	
	void saveOrUpdateBlogComment(BlogComment blogComment);

	void deleteBlogComment(String blogCommentId);

	BlogComment getBlogComment(String blogCommentId);

	List<BlogComment> listBlogComments();

}
