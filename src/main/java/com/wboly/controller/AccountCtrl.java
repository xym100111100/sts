package com.wboly.controller;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wboly.model.AccountMo;
import com.wboly.model.AccountRo;
import com.wboly.service.AccountService;





@RestController
public class AccountCtrl  {
	
    private static Logger log= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    @Resource
    private AccountService svc;
	
	@GetMapping("/account/getById")
	public AccountMo getUsers(Long id) {
		
		return svc.getById(id);
	}
	
	
	
	@GetMapping("/account/lisAll")
	public List<AccountMo> lisAll(Long id) {
		
		return svc.listAll();
	}
	
	
	
	@GetMapping("/integral/getByUnionId")
	public AccountRo  getByUnionId(String unionId) {
		log.info("根据unionId查询用户账户信息的参数为:{}",unionId);
		return svc.getByUnionId(unionId);
	}

}
