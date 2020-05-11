package com.wboly.service;

import java.util.List;

import com.wboly.model.IntegralMo;


public interface IntegralService {
	
	IntegralMo getById(Long userId);
		
		List<IntegralMo> getAllList();
}
