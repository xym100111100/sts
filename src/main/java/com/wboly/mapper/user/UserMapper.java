package com.wboly.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.wboly.enums.UserSexEnum;
import com.wboly.model.UserMo;


public interface UserMapper {
	


	
	@Select({"select ID,SALT,WX_OPENID from SUC_USER"})
	@Results(id="userMap", value={
	    @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="SALT", property="salt", jdbcType=JdbcType.VARCHAR),
	    @Result(column="WX_OPENID", property="wxOpenid", jdbcType=JdbcType.VARCHAR),
	})
	List<UserMo> getAll();
	
	
	@Select("SELECT ID,SALT,WX_OPENID FROM SUC_USER where  WX_OPENID = #{openId} ")
	@ResultMap(value="userMap")
	UserMo getById(String openId);
	
	@Select("SELECT ID,SALT,WX_OPENID FROM SUC_USER where  WX_ID = #{unionId} ")
	@ResultMap(value="userMap")
	UserMo getByUnionId(String unionId); 
	
	




}