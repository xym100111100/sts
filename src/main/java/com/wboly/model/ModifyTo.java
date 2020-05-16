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
public class ModifyTo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String unionId;
  
    private BigDecimal actionUsermoney;



		private BigDecimal actionIntegral ;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public BigDecimal getActionUsermoney() {
		return actionUsermoney;
	}

	public void setActionUsermoney(BigDecimal actionUsermoney) {
		this.actionUsermoney = actionUsermoney;
	}

	public BigDecimal getActionIntegral() {
		return actionIntegral;
	}

	public void setActionIntegral(BigDecimal actionIntegral) {
		this.actionIntegral = actionIntegral;
	}

	@Override
	public String toString() {
		return "AccountTo{" +
				"unionId='" + unionId + '\'' +
				", actionUsermoney=" + actionUsermoney +
				", actionIntegral=" + actionIntegral +
				'}';
	}
}