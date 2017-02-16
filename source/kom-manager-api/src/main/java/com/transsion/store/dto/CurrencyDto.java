package com.transsion.store.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrencyDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	/**
	 * 国家ID
	 * */
	private Long country;
	
	/**
	 * 国家名称
	 * */
	private String countryName;
	
	/**
	 * 币别编码
	 * */
	private String werks;
	
	/**
	 * 币别名称
	 * */
	private String currencyName;
	
	/**
	 * 美元兑外币汇率
	 * */
	private BigDecimal exchangerate;
	
	/**
	 * 人民币兑外币汇率
	 * */
	private BigDecimal exchangerate2;
	
	/**
	 * 生效日期
	 * */
	private String beginTime;
	
	/**
	 * 失效日期
	 * */
	private String endTime;
	
	/**
	 * 是否停用 1启用 2停用
	 * */
	private Integer isInactive;
	
	/**
	 * 创建人
	 * */
	private String createdBy;
	
	/**
	 * 创建时间
	 * */
	private String createdTime;
	
	/**
	 * 更新人
	 * */
	private String updatedBy;
	
	/**
	 * 更新时间
	 * */
	private String updatedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCountry() {
		return country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getWerks() {
		return werks;
	}

	public void setWerks(String werks) {
		this.werks = werks;
	}
	
	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public BigDecimal getExchangerate() {
		return exchangerate;
	}

	public void setExchangerate(BigDecimal exchangerate) {
		this.exchangerate = exchangerate;
	}

	public BigDecimal getExchangerate2() {
		return exchangerate2;
	}

	public void setExchangerate2(BigDecimal exchangerate2) {
		this.exchangerate2 = exchangerate2;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(Integer isInactive) {
		this.isInactive = isInactive;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "CurrencyDto [id=" + id + ", country=" + country + ", countryName=" + countryName + ", werks=" + werks
						+ ", currencyName=" + currencyName + ", exchangerate=" + exchangerate + ", exchangerate2="
						+ exchangerate2 + ", beginTime=" + beginTime + ", endTime=" + endTime + ", isInactive="
						+ isInactive + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", updatedBy="
						+ updatedBy + ", updatedTime=" + updatedTime + "]";
	}

}
