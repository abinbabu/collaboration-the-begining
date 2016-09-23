package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdateUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}
	
	@Transactional
	public void deleteUser(String userId) {
		User userToDelete = new User();
		userToDelete.setUserId(userId);
		sessionFactory.getCurrentSession().delete(userToDelete);

	}
	
	@Transactional
	public User getUser(String userId) {
		String hql = "from User where userId=:userId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("userId", userId);
		List<User> gotUser = query.getResultList();
		if (gotUser != null && !gotUser.isEmpty())
			return gotUser.get(0);
		return null;
	}
	
	@Transactional
	public List<User> listUser() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> listOfUser = query.getResultList();
		return listOfUser;
	}

}
