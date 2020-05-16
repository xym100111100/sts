package com.wboly.mapper.account;

import java.math.BigDecimal;
import java.util.List;

import com.wboly.model.AccountTradeMo;
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
	

	@Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(UserMo user);

	@Update("UPDATE AFC_ACCOUNT SET BALANCE=#{balance} WHERE id =#{id}")
	int update(Long id , BigDecimal balance);



	@Select("SELECT * FROM AFC_TRADE  WHERE ACCOUNT_ID =#{id}  order by TRADE_TIME desc")
	@Results(id="TradeMap", value={
			@Result(property = "id",  column = "ID"),
			@Result(property = "balance", column = "BALANCE"),
			@Result( column="ACCOUNT_ID" , property="accountId" ),
			@Result( column="TRADE_TYPE" , property="tradeType" ),
			@Result( column="TRADE_AMOUNT" ,property="tradeAmount" ),
			@Result( column="CHANGE_AMOUNT1",  property="changeAmount1" ),
			@Result( column="CHANGE_AMOUNT2" ,property="changeAmount2" ),
			@Result( column="TRADE_TITLE",  property="tradeTitle" ),
			@Result( column="TRADE_DETAIL",property="tradeDetail" ),
			@Result( column="TRADE_TIME",  property="tradeTime" ),
			@Result( column="ORDER_ID", property="orderId" ),
			@Result( column="ORDER_DETAIL_ID",  property="orderDetailId" ),
			@Result( column="TRADE_VOUCHER_NO",property="tradeVoucherNo" ),
			@Result( column="OP_ID" ,property="opId" ),
			@Result( column="MAC" ,property="mac" ),
			@Result( column="IP" , property="ip" )
	})
	List<AccountTradeMo> selectPage(Long id);

}