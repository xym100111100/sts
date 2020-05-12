package com.wboly.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

public class AccountRo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String remark;

	private Boolean result;

	private BigDecimal usermoney; 

	private BigDecimal integral;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public BigDecimal getUsermoney() {
		return usermoney;
	}

	public BigDecimal getIntegral() {
		return integral;
	}

	public void setIntegral(BigDecimal integral) {
		this.integral = integral;
	}

	public void setUsermoney(BigDecimal usermoney) {
		this.usermoney = usermoney;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AccountRo [remark=" + remark + ", result=" + result + ", usermoney=" + usermoney + ", integral="
				+ integral + "]";
	}
	
	
}
