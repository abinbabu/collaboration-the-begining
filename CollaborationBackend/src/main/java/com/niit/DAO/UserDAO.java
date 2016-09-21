package com.niit.DAO;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {
	
void saveOrUpdateUser(User user);
	
	void deleteUser(String id);
	
	User getUser(String id);
	
	List<User> listUser();

}
