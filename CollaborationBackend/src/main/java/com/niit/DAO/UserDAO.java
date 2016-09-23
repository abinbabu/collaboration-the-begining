package com.niit.DAO;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {
	
void saveOrUpdateUser(User user);
	
	void deleteUser(String userId);
	
	User getUser(String userId);
	
	List<User> listUser();

}
