package com.wboly.service;

import java.util.List;

import com.wboly.model.OrderMo;

public interface OrderService {

	OrderMo getById(Long id);

	List<OrderMo> listAll();
}
