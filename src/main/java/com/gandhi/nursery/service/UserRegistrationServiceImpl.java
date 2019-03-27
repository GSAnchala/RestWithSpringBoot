package com.gandhi.nursery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gandhi.nursery.dao.UserDao;
import com.gandhi.nursery.entity.User;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User registerUser(User user) {
		return userDao.save(user);
	}

}
