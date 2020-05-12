package com.wboly.controller;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wboly.model.AccountRo;
import com.wboly.model.AccountTo;
import com.wboly.service.AccountService;





@RestController
public class AccountCtrl  {
	
    private static Logger log= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    @Resource
    private AccountService svc;
	
	@GetMapping("/integral/getByUnionId")
	public AccountRo  getByUnionId(String unionId) {
		log.info("根据unionId查询用户账户信息的参数为:{}",unionId);
		return svc.getByUnionId(unionId);
	}
	
	
	@PutMapping("/integral/modify")
	public AccountRo  modify(@RequestBody AccountTo to ) {
		log.info("修改用户账户的参数为:{}",to);
		return svc.modify(to);
	}
	

}
