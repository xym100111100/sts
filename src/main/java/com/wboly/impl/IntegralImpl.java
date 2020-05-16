package com.wboly.impl;

import java.math.BigDecimal;
import java.util.List;

import com.wboly.mapper.account.AccountMapper;
import com.wboly.mapper.user.UserMapper;
import com.wboly.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wboly.mapper.integral.IntegralMapper;
import com.wboly.service.IntegralService;



@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class IntegralImpl implements  IntegralService  {
	
    private static Logger log= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private IntegralMapper integralMapper;
	
	



	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public ResultRo modify(ModifyTo to) {
		ResultRo result = new ResultRo();
		if(to.getUnionId() == null || to.getActionIntegral() == null){
			result.setMessage("参数错误，UnionId或getActionIntegral为空");
			result.setResult(false);
			return result;
		}


		UserMo userResult = userMapper.getByUnionId(to.getUnionId());
		log.info("查询用户结果为:{}", userResult);
		if (userResult == null) {
			result.setMessage("账户不存在");
			result.setResult(false);
			return result;
		}

		IntegralMo IntegralResult = integralMapper.getById(userResult.getId());
		log.info("查询用户积分结果为:{}", IntegralResult);

		if (IntegralResult == null) {
			result.setMessage("用户积分不存在");
			result.setResult(false);
			return result;
		}

		BigDecimal newPoint = IntegralResult.getPoint().add(to.getActionIntegral());
		log.info("旧的积分{},传过来的积分{},修改后的积分{}",IntegralResult.getPoint(),to.getActionIntegral(),newPoint);
		int i = integralMapper.update(userResult.getId(),newPoint);
		log.info("修改积分的结果为{}",i);
		if(i != 1) {
			result.setResult(false);
			result.setMessage("修改失败");
		}
		result.setResult(true);
		result.setMessage("修改成功");

		return result;
	}
}
