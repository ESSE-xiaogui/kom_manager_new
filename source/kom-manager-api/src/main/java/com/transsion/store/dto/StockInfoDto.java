package com.transsion.store.dto;

import java.io.Serializable;

public class StockInfoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.Long companyId;
	private java.lang.String billno;
	private java.lang.String stockDate;
	private java.lang.Long stockId;
	private java.lang.String brandCode;
	private java.lang.Long brandId;
	private java.lang.String modelCode;
	private java.lang.Long modelId;
	private java.lang.Integer shopId;
	private java.lang.Long regionId;
	private java.lang.Long regionType;
	
	private java.math.BigDecimal qty;
	
	private java.lang.String companyCode;
	
	private java.lang.String countryName;
	
	private java.lang.String cityName;
	
	private java.lang.String shopName;
	
	private java.lang.String bizName;
	
	private java.lang.String gradeName;
	
	private java.lang.String empName;
	
	private java.lang.String dutyName;
	
	private java.lang.String shopCode;
	
	private java.lang.String userCode;
	
	private java.lang.String stockDateStart;
	
	private java.lang.String stockDateEnd;
	
	private java.lang.String createTime;
	
	private java.lang.String createTimeStart;
	
	private java.lang.String createTimeEnd;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Long companyId) {
		this.companyId = companyId;
	}

	public java.lang.String getBillno() {
		return billno;
	}

	public void setBillno(java.lang.String billno) {
		this.billno = billno;
	}

	public java.lang.String getStockDate() {
		return stockDate;
	}

	public void setStockDate(java.lang.String stockDate) {
		this.stockDate = stockDate;
	}

	public java.lang.Long getStockId() {
		return stockId;
	}

	public void setStockId(java.lang.Long stockId) {
		this.stockId = stockId;
	}

	public java.lang.String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(java.lang.String brandCode) {
		this.brandCode = brandCode;
	}

	public java.lang.String getModelCode() {
		return modelCode;
	}

	public void setModelCode(java.lang.String modelCode) {
		this.modelCode = modelCode;
	}

	public java.lang.Integer getShopId() {
		return shopId;
	}

	public void setShopId(java.lang.Integer shopId) {
		this.shopId = shopId;
	}

	public java.lang.Long getRegionId() {
		return regionId;
	}

	public void setRegionId(java.lang.Long regionId) {
		this.regionId = regionId;
	}

	public java.math.BigDecimal getQty() {
		return qty;
	}

	public void setQty(java.math.BigDecimal qty) {
		this.qty = qty;
	}

	public java.lang.String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(java.lang.String companyCode) {
		this.companyCode = companyCode;
	}

	public java.lang.String getCountryName() {
		return countryName;
	}

	public void setCountryName(java.lang.String countryName) {
		this.countryName = countryName;
	}

	public java.lang.String getCityName() {
		return cityName;
	}

	public void setCityName(java.lang.String cityName) {
		this.cityName = cityName;
	}

	public java.lang.String getShopName() {
		return shopName;
	}

	public void setShopName(java.lang.String shopName) {
		this.shopName = shopName;
	}

	public java.lang.String getBizName() {
		return bizName;
	}

	public void setBizName(java.lang.String bizName) {
		this.bizName = bizName;
	}

	public java.lang.String getGradeName() {
		return gradeName;
	}

	public void setGradeName(java.lang.String gradeName) {
		this.gradeName = gradeName;
	}

	public java.lang.String getEmpName() {
		return empName;
	}

	public void setEmpName(java.lang.String empName) {
		this.empName = empName;
	}

	public java.lang.String getDutyName() {
		return dutyName;
	}

	public void setDutyName(java.lang.String dutyName) {
		this.dutyName = dutyName;
	}

	public java.lang.String getShopCode() {
		return shopCode;
	}

	public void setShopCode(java.lang.String shopCode) {
		this.shopCode = shopCode;
	}

	public java.lang.String getUserCode() {
		return userCode;
	}

	public void setUserCode(java.lang.String userCode) {
		this.userCode = userCode;
	}

	public java.lang.String getStockDateStart() {
		return stockDateStart;
	}

	public void setStockDateStart(java.lang.String stockDateStart) {
		this.stockDateStart = stockDateStart;
	}

	public java.lang.String getStockDateEnd() {
		return stockDateEnd;
	}

	public void setStockDateEnd(java.lang.String stockDateEnd) {
		this.stockDateEnd = stockDateEnd;
	}

	public java.lang.String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.lang.String createTime) {
		this.createTime = createTime;
	}

	public java.lang.String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(java.lang.String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public java.lang.String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(java.lang.String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public java.lang.Long getBrandId() {
		return brandId;
	}

	public void setBrandId(java.lang.Long brandId) {
		this.brandId = brandId;
	}

	public java.lang.Long getModelId() {
		return modelId;
	}

	public void setModelId(java.lang.Long modelId) {
		this.modelId = modelId;
	}

	public java.lang.Long getRegionType() {
		return regionType;
	}

	public void setRegionType(java.lang.Long regionType) {
		this.regionType = regionType;
	}

	@Override
	public String toString() {
		return "StockInfoDto [id=" + id + ", companyId=" + companyId + ", billno=" + billno + ", stockDate=" + stockDate
						+ ", stockId=" + stockId + ", brandCode=" + brandCode + ", brandId=" + brandId + ", modelCode="
						+ modelCode + ", modelId=" + modelId + ", shopId=" + shopId + ", regionId=" + regionId
						+ ", regionType=" + regionType + ", qty=" + qty + ", companyCode=" + companyCode
						+ ", countryName=" + countryName + ", cityName=" + cityName + ", shopName=" + shopName
						+ ", bizName=" + bizName + ", gradeName=" + gradeName + ", empName=" + empName + ", dutyName="
						+ dutyName + ", shopCode=" + shopCode + ", userCode=" + userCode + ", stockDateStart="
						+ stockDateStart + ", stockDateEnd=" + stockDateEnd + ", createTime=" + createTime
						+ ", createTimeStart=" + createTimeStart + ", createTimeEnd=" + createTimeEnd + "]";
	}

	
	
}