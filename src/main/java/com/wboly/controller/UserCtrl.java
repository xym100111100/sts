package com.wboly.controller;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wboly.model.UserMo;
import com.wboly.service.UserService;





@RestController
public class UserCtrl  {
	


    @Resource
    private UserService svc;
	
	@GetMapping("/getUser")
	public UserMo getUser(String openId) {
		
		return svc.getById(openId);
	}
	

	
	@GetMapping("/getUserAll")
	public List<UserMo> getUserAll() {
		
		return svc.getAllUser();
	}
	
	

}
