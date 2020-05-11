package com.wboly.service;

import java.util.List;

import com.wboly.model.User;

public interface UserService {
	
		User getById(String openId);
		
		List<User> getAllUser();
}
