package com.wboly.controller;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wboly.model.AccountRo;
import com.wboly.model.IntegralMo;
import com.wboly.service.IntegralService;





@RestController
public class IntegralCtrl  {



    @Resource
    private IntegralService svc;
	
	@GetMapping("/integral/getByUserId")
	public IntegralMo getByUserId(Long userId) {
		
		return svc.getById(userId);
	}
	
	
	
	@GetMapping("/integral/getAll")
	public List<IntegralMo> getAllList() {
		
		return svc.getAllList();
	}
	

	

}
