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
	@Results(id="studentMap", value={
			@Result(property = "id",  column = "ID"),
			@Result(property = "orderCode", column = "ORDER_CODE")
		})
	List<OrderMo> getAll();
	
	
	@Select("SELECT * FROM ORD_ORDER where  ID = #{id} ")
	OrderMo getById(Long id);
	
	
	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})
	UserMo getOne(Long id);

	@Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(UserMo user);

	@Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(UserMo user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);

}