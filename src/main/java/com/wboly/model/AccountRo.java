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

	private String message;

	private Boolean result;

	private BigDecimal usermoney; 

	private BigDecimal integral;



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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AccountRo [message=" + message + ", result=" + result + ", usermoney=" + usermoney + ", integral="
				+ integral + "]";
	}


	
	
	
}
