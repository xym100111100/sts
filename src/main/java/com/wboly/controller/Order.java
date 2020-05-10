package com.wboly.controller;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wboly.model.User;
import com.wboly.service.OrderService;





@RestController
public class Order  {
	


    @Resource
    private OrderService svc;
	
	@GetMapping("/getUsers")
	public User getUsers(String openId) {
		
		return svc.getById(openId);
	}
	

}
