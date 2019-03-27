package com.gandhi.nursery.dao;

import org.springframework.data.repository.CrudRepository;

import com.gandhi.nursery.entity.User;

public interface  UserDao   extends CrudRepository<User, Long>  {
	User findByUsernameAndPassword(String username, String password);
}
