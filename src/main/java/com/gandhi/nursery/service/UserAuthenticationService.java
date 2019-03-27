package com.gandhi.nursery.service;

import com.gandhi.nursery.entity.User;

public interface UserAuthenticationService {
	User verifyUser(String username, String password);
}
