package com.wboly.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 修改账户用户余额
 *
 */
@JsonInclude(Include.NON_NULL)
public class AccountTo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String unionId;
  
    private BigDecimal actionUsermoney;
    

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public BigDecimal getActionUsermoney() {
		return actionUsermoney;
	}

	@Override
	public String toString() {
		return "AccountTo [unionId=" + unionId + ", actionUsermoney=" + actionUsermoney + "]";
	}

	public void setActionUsermoney(BigDecimal actionUsermoney) {
		this.actionUsermoney = actionUsermoney;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
	
    


}