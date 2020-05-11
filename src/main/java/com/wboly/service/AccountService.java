package com.wboly.service;

import java.util.List;

import com.wboly.model.AccountMo;
import com.wboly.model.AccountRo;

public interface AccountService {

	AccountMo getById(Long id);

	List<AccountMo> listAll();
	
	AccountRo getByUnionId(String unionId);
}
