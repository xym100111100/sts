package com.wboly.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wboly.mapper.order.OrderMapper;
import com.wboly.model.Order;
import com.wboly.service.OrderService;



@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class OrderImpl implements  OrderService  {
	
    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	
	@Autowired
	private OrderMapper orderMapper;
	
	
	@Override
	public Order getById(Long id) {
		logger.info("查询订单为{}",id);
		Order result = orderMapper.getById(id);
		return result;
	}


	@Override
	public List<Order> listAll() {
		
		return orderMapper.getAll();
	}

}
