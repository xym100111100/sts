package com.wboly.service;

import java.util.List;

import com.wboly.model.Order;


public interface OrderService {
	
		Order getById(Long id);
		
		List<Order> listAll();
}
