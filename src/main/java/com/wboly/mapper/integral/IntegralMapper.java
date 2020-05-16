package com.wboly.mapper.integral;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wboly.enums.UserSexEnum;
import com.wboly.model.IntegralMo;
import com.wboly.model.UserMo;


public interface IntegralMapper {
	
	
	
	@Select("SELECT * FROM PNT_ACCOUNT")
	@Results(id="pntMap", value={
			@Result(property = "id",  column = "ID"),
			@Result(property = "orderCode", column = "ORDER_CODE")
		})
	List<IntegralMo> getAll();
	
	
	@Select("SELECT * FROM PNT_ACCOUNT where  ID = #{id} ")
	IntegralMo getById(Long id);
	


	@Update("UPDATE PNT_ACCOUNT SET POINT=#{point}  WHERE id =#{id}")
	int update(Long id , BigDecimal point);


}