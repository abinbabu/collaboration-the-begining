package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.BlogDAO;
import com.niit.model.Blog;

public class BlogDAOImpl implements BlogDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateBlog(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);

	}

	@Transactional
	public void deleteBlog(String blogId) {
		Blog blogTodelete = new Blog();
		blogTodelete.setBlogId(blogId);
		sessionFactory.getCurrentSession().delete(blogTodelete);

	}

	@Transactional
	public Blog getBlog(String blogId) {
		String hql = "from Blog where blogId=:blogId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("blogId",blogId);
		List<Blog> gotBlog = query.getResultList();
		if (gotBlog != null && !gotBlog.isEmpty())
			return gotBlog.get(0);
		return null;
	}

	@Transactional
	public List<Blog> listBlogs() {
		String hql = "from Blog";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Blog> listOfBlogs = query.getResultList();
		return listOfBlogs;
	}

	

}
