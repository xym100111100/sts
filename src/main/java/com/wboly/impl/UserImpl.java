package com.wboly.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wboly.mapper.user.UserMapper;
import com.wboly.model.User;
import com.wboly.service.UserService;



@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserImpl implements  UserService  {
	
    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public User getById(String openId) {
		logger.info("查询用户信息的openId为{}",openId);
		User result =userMapper.getById(openId);
		logger.info("查询用户信息的返回值为{}",result);

		return result ;
	}


	@Override
	public List<User> getAllUser() {
		
		return userMapper.getAll();
	}

}
