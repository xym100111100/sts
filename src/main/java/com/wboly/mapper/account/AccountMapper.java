package com.wboly.mapper.account;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wboly.enums.UserSexEnum;
import com.wboly.model.AccountMo;
import com.wboly.model.UserMo;


public interface AccountMapper {
	
	
	
	@Select("SELECT * FROM AFC_ACCOUNT")
	@Results(id="accountMap", value={
			@Result(property = "id",  column = "ID"),
			@Result(property = "balance", column = "BALANCE")
		})
	List<AccountMo> getAll();
	
	
	@Select("SELECT * FROM AFC_ACCOUNT where  ID = #{id} ")
	AccountMo getById(Long id);
	

	
	
	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})
	UserMo getOne(Long id);

	@Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(UserMo user);

	@Update("UPDATE AFC_ACCOUNT SET BALANCE=#{balance} WHERE id =#{id}")
	int update(Long id , BigDecimal balance);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);

}