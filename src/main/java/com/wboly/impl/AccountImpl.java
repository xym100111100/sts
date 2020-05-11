package com.wboly.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wboly.mapper.account.AccountMapper;
import com.wboly.mapper.order.OrderMapper;
import com.wboly.model.AccountMo;
import com.wboly.model.OrderMo;
import com.wboly.service.AccountService;
import com.wboly.service.OrderService;



@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AccountImpl implements  AccountService  {
	
    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	
	@Autowired
	private AccountMapper accountMapper;
	
	
	@Override
	public AccountMo getById(Long id) {
		logger.info("查询订单为{}",id);
		AccountMo result = accountMapper.getById(id);
		return result;
	}


	@Override
	public List<AccountMo> listAll() {
		
		return accountMapper.getAll();
	}

}
