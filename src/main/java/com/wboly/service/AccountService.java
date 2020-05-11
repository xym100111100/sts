package com.wboly.service;

import java.util.List;

import com.wboly.model.AccountMo;

public interface AccountService {

	AccountMo getById(Long id);

	List<AccountMo> listAll();
}
