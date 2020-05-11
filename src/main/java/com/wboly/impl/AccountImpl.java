package com.wboly.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wboly.mapper.account.AccountMapper;
import com.wboly.mapper.integral.IntegralMapper;
import com.wboly.mapper.user.UserMapper;
import com.wboly.model.AccountMo;
import com.wboly.model.AccountRo;
import com.wboly.model.UserMo;
import com.wboly.service.AccountService;



@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AccountImpl implements  AccountService  {
	
    private static Logger log= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	
	@Autowired
	private AccountMapper accountMapper;
	
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Autowired
	private IntegralMapper integralMapper;
	
	
	@Override
	public AccountMo getById(Long id) {
		AccountMo result = accountMapper.getById(id);
		return result;
	}


	@Override
	public List<AccountMo> listAll() {
		
		return accountMapper.getAll();
	}

	
	@Override
	public AccountRo getByUnionId(String unionId) {
		UserMo userResult =  userMapper.getByUnionId(unionId);
		
		return null;
	}

}
