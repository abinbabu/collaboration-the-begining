package com.niit.DAO;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDAO {
	
	void saveOrUpdateBlog(Blog blog);
	
	void deleteBlog(String blogId);
	
	Blog getBlog(String blogId);
	
	List<Blog> listBlogs();

}
