package com.wboly.controller;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wboly.model.OrderMo;
import com.wboly.service.OrderService;





@RestController
public class OrderCtrl  {
	


    @Resource
    private OrderService svc;
	
	@GetMapping("/order/getById")
	public OrderMo getUsers(Long id) {
		
		return svc.getById(id);
	}
	
	
	
	@GetMapping("/order/lisAll")
	public List<OrderMo> lisAll(Long id) {
		
		return svc.listAll();
	}

}
