package com.wboly.service;


import com.wboly.model.AccountRo;
import com.wboly.model.AccountTo;

public interface AccountService {


	
	AccountRo getByUnionId(String unionId);
	
	
	AccountRo modify(AccountTo to);
}
