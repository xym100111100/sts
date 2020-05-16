package com.wboly.service;

import java.util.List;

import com.wboly.model.ModifyTo;
import com.wboly.model.IntegralMo;
import com.wboly.model.ResultRo;
import org.springframework.web.bind.annotation.RequestBody;


public interface IntegralService {
	

		



	ResultRo modify( ModifyTo to );
}
