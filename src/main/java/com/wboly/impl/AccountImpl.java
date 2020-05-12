package com.wboly.impl;


import java.math.BigDecimal;

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
import com.wboly.model.AccountTo;
import com.wboly.model.IntegralMo;
import com.wboly.model.UserMo;
import com.wboly.service.AccountService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AccountImpl implements AccountService {

	private static Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private IntegralMapper integralMapper;



	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public AccountRo getByUnionId(String unionId) {
		AccountRo result = new AccountRo();

		UserMo userResult = userMapper.getByUnionId(unionId);
		log.info("查询用户结果为:{}", userResult);
		if (userResult == null) {
			result.setRemark("用户不存在");
			result.setResult(false);
			return result;
		}

		AccountMo accountResult = accountMapper.getById(userResult.getId());
		log.info("查询用户账户结果为:{}", accountResult);
		
		if (accountResult == null) {
			result.setRemark("用户账户不存在");
			result.setResult(false);
			return result;
		}
		
		IntegralMo integralResult = integralMapper.getById(userResult.getId());
		log.info("查询用户积分结果为:{}", accountResult);
		
		if (integralResult == null) {
			result.setRemark("用户积分账户不存在");
			result.setResult(false);
			return result;
		}
		
		result.setRemark("获取用户账户信息成功");
		result.setResult(true);
		result.setUsermoney(accountResult.getBalance());
		result.setIntegral(integralResult.getPoint());
		log.info("查询用户信息结果为result:{}", result);
		return result;
	}



	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public AccountRo modify(AccountTo to) {
		AccountRo result = new AccountRo();

		UserMo userResult = userMapper.getByUnionId(to.getUnionId());
		log.info("查询用户结果为:{}", userResult);
		if (userResult == null) {
			result.setRemark("账户不存在");
			result.setResult(false);
			return result;
		}
		
		AccountMo accountResult = accountMapper.getById(userResult.getId());
		log.info("查询用户账户结果为:{}", accountResult);
		
		if (accountResult == null) {
			result.setRemark("用户账户不存在");
			result.setResult(false);
			return result;
		}
		
		BigDecimal newNalance = accountResult.getBalance().add(to.getActionUsermoney());
		log.info("旧的余额{},传过来的金额{},修改后的金额{}",accountResult.getBalance(),to.getActionUsermoney(),newNalance);
		int i = accountMapper.update(userResult.getId(),newNalance);
		log.info("修改账户的结果为{}",i);
		if(i != 1) {
			result.setResult(false);
			result.setRemark("修改失败");
		}
		result.setResult(true);
		result.setRemark("修改成功");
		
		return result;
	}

}
