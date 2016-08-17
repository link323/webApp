package com.websystique.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.ResultsDao;
import com.websystique.springsecurity.dao.UserDao;
import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.Pacients;
import com.websystique.springsecurity.model.PressureResults;
import com.websystique.springsecurity.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserDao userDao;
     
    @Autowired
    private ResultsDao resultsDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
              
    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }
     
    public User findById(int id) {
        return userDao.findById(id);
    }
 
    public User findBySso(String sso) {
        return userDao.findBySSO(sso);
    }
    public void updateUser(User user) {
        User entity = userDao.findById(user.getId());
        if(entity!=null){
            entity.setSsoId(user.getSsoId());
            entity.setPassword(user.getPassword());
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
            entity.setUserProfiles(user.getUserProfiles());
        }
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
    
    public List<DiabeticResults> findAllDiabeticResults() {
        return resultsDao.findAllDiabeticResults();
    }

	@Override
	public List<PressureResults> findAllPressureResults() {
		 return resultsDao.findAllPressureResults();
	}

	@Override
	public List<Pacients> findAllPacients() {
		return resultsDao.findAllPacients();
	}
}
