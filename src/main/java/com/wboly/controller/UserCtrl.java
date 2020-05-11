package com.wboly.controller;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wboly.model.User;
import com.wboly.service.UserService;





@RestController
public class UserCtrl  {
	


    @Resource
    private UserService svc;
	
	@GetMapping("/getUser")
	public User getUser(String openId) {
		
		return svc.getById(openId);
	}
	

	
	@GetMapping("/getUserAll")
	public List<User> getUserAll() {
		
		return svc.getAllUser();
	}
	
	

}
