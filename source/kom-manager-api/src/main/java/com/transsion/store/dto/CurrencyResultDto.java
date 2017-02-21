package com.transsion.store.dto;

import java.io.Serializable;

public class CurrencyResultDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 币别名称
	 * */
	private String currencyName;

	/**
	 * 币别名称
	 * */
	public String getCurrencyName() {
		return currencyName;
	}

	/**
	 * 币别名称
	 * */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	@Override
	public String toString() {
		return "CurrencyResultDto [currencyName=" + currencyName + "]";
	}

}
