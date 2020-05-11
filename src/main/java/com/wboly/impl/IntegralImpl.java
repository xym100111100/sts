package com.wboly.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wboly.mapper.integral.IntegralMapper;
import com.wboly.model.IntegralMo;
import com.wboly.service.IntegralService;



@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class IntegralImpl implements  IntegralService  {
	
    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	
	@Autowired
	private IntegralMapper integralMapper;
	
	
	@Override
	public IntegralMo getById(Long userId) {
		logger.info("查询用户积分信息的userId为{}",userId);
		IntegralMo result =integralMapper.getById(userId);
		logger.info("查询用户积分信息的返回值为{}",result);

		return result ;
	}


	@Override
	public List<IntegralMo> getAllList() {
		
		return integralMapper.getAll();
	}

}
