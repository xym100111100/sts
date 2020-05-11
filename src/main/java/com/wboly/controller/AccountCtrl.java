package com.wboly.controller;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wboly.model.AccountMo;
import com.wboly.service.AccountService;





@RestController
public class AccountCtrl  {
	


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

}
