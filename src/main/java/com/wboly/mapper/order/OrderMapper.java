package com.wboly.mapper.order;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wboly.enums.UserSexEnum;
import com.wboly.model.OrderMo;
import com.wboly.model.UserMo;


public interface OrderMapper {
	
	
	
	@Select("SELECT * FROM ORD_ORDER")
	@Results(id="orderMap", value={
			@Result(property = "id",  column = "ID"),
			@Result(property = "orderCode", column = "ORDER_CODE")
		})
	List<OrderMo> getAll();
	
	
	@Select("SELECT * FROM ORD_ORDER where  ID = #{id} ")
	OrderMo getById(Long id);
	
	


}