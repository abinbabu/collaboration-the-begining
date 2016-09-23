package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.ForumPostCommentDAO;
import com.niit.model.ForumPostComment;
@Repository("forumpostcommentDAO")
public class ForumPostCommentDAOImpl implements ForumPostCommentDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public ForumPostCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateForumPostComment(ForumPostComment forumPostComment) {
		sessionFactory.getCurrentSession().saveOrUpdate(forumPostComment);

	}

	@Transactional
	public void deleteForumPostComment(String forumPostCommentId) {
		ForumPostComment forumPostCommentTodelete = new ForumPostComment();
		forumPostCommentTodelete.setForumPostCommentId(forumPostCommentId);
		sessionFactory.getCurrentSession().delete(forumPostCommentTodelete);
	}

	@Transactional
	public ForumPostComment getForumPostComment(String forumPostCommentId) {
		String hql = "from ForumPostComment where forumPostCommentId=:forumPostCommentId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("forumPostCommentId",
				forumPostCommentId);
		List<ForumPostComment> gotForumPostComment = query.getResultList();
		if (gotForumPostComment != null && !gotForumPostComment.isEmpty())
			return gotForumPostComment.get(0);
		return null;
	}

	@Transactional
	public List<ForumPostComment> listForumPostComments() {
		String hql = "from ForumPostComment";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumPostComment> listOfForumPostComments = query.getResultList();
		return listOfForumPostComments;
	}


}
