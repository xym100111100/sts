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
		AccountRo result = new AccountRo();

		UserMo userResult = userMapper.getByUnionId(unionId);
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

}
