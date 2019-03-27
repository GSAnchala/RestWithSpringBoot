package com.gandhi.nursery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gandhi.nursery.dao.UserDao;
import com.gandhi.nursery.entity.User;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	@Autowired
	private UserDao userDao;

	@Override
	public User verifyUser(String username, String password) {
		return userDao.findByUsernameAndPassword(username, password);
	}

}
