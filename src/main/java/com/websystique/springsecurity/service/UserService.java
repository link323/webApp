package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.Pacients;
import com.websystique.springsecurity.model.PressureResults;
import com.websystique.springsecurity.model.User;

public interface UserService {
	
	List<User> findAllUsers();

	void save(User user);
	
	User findById(int id);
	
	User findBySso(String sso);
	
	List<DiabeticResults> findAllDiabeticResults();
	
	List<PressureResults> findAllPressureResults();
	
	List<Pacients> findAllPacients();
}