package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.User;
import com.websystique.springsecurity.model.UserProfile;

public interface UserDao {

	void save(User user);
	
	User findById(int id);
	
	User findBySSO(String sso);
	
	List<User> findAllUsers();

}

