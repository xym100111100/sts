package com.wboly.controller;

import javax.annotation.Resource;

import com.wboly.model.ModifyTo;
import com.wboly.model.ResultRo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wboly.service.IntegralService;





@RestController
public class IntegralCtrl  {



    @Resource
    private IntegralService svc;
	

	
	
	
	@PutMapping("/integral/modify")
	public ResultRo modify(@RequestBody ModifyTo to ) {
		
		return svc.modify(to);
	}
	

	

}
