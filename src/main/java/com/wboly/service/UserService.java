package com.wboly.service;

import java.util.List;

import com.wboly.model.UserMo;

public interface UserService {
	
		UserMo getById(String openId);
		
		List<UserMo> getAllUser();
}
