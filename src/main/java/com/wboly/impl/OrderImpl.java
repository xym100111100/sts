package com.wboly.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wboly.mapper.UserMapper;
import com.wboly.model.User;
import com.wboly.service.OrderService;



@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class OrderImpl implements  OrderService  {
	
    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public User getById(String openId) {
		logger.info("查询用户信息的openId为{}",openId);
	
		return userMapper.getById(openId);
	}

}
