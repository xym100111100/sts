package com.wboly.controller;

import javax.annotation.Resource;

import com.wboly.model.PageRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import com.wboly.model.ResultRo;
import com.wboly.model.ModifyTo;
import com.wboly.service.AccountService;





@RestController
public class AccountCtrl  {
	
    private static Logger log= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    @Resource
    private AccountService svc;
	
	@GetMapping("/account/getByUnionId")
	public ResultRo getByUnionId(String unionId) {
		log.info("根据unionId查询用户账户信息的参数为:{}",unionId);
		return svc.getByUnionId(unionId);
	}
	
	
	@PutMapping("/account/modify")
	public ResultRo modify(@RequestBody ModifyTo to ) {
		log.info("修改用户账户的参数为:{}",to);
		return svc.modify(to);
	}

	@GetMapping("/account/listTrade")
	public Object findPage( PageRequest pageQuery) {
		if(pageQuery.getPageNum() == 0 || pageQuery.getPageSize() == 0 || pageQuery.getUnionId() == null){
			ResultRo Ro = new ResultRo();
			Ro.setMessage("参数错误，没有填pageNum或pageSize或unionId");
			Ro.setResult(false);
			return Ro;
		}
		Object result = svc.findPage(pageQuery);
		if(result==null){
			ResultRo Ro = new ResultRo();
			Ro.setMessage("用户不存在");
			Ro.setResult(false);
			return Ro;
		}
		return result;
	}
	

}
