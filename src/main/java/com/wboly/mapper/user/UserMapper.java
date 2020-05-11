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
import com.wboly.model.User;


public interface UserMapper {
	


	
	@Select({"select ID,SALT,WX_OPENID from SUC_USER"})
	@Results(id="studentMap", value={
	    @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="SALT", property="salt", jdbcType=JdbcType.VARCHAR),
	    @Result(column="WX_OPENID", property="wxOpenid", jdbcType=JdbcType.VARCHAR),
	})
	List<User> getAll();
	
	
	@Select("SELECT ID,SALT,WX_OPENID FROM SUC_USER where  WX_OPENID = #{openId} ")
	@ResultMap(value="studentMap")
	User getById(String openId);
	
	
	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})
	User getOne(Long id);

	@Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(User user);

	@Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(User user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);

}