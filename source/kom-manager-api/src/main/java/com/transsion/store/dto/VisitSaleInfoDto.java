package com.transsion.store.dto;

import java.io.Serializable;

public class VisitSaleInfoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.Long visitId;

	/**
	  *	
	  */
	private java.lang.Long brandId;
	
	private java.lang.Long saleQty;

	/**
	  *	
	  */
	private java.lang.Long modelId;
	
	private java.lang.Long companyId;
	
	private java.lang.String companyCode;
	
	private java.lang.Long regionId;
	
	private java.lang.Long regionType;
	
	private java.lang.String countryName;
	
	private java.lang.String cityName;
	
	private java.lang.String shopCode;
	
	private java.lang.String shopName;
	
	private java.lang.String empName;
	
	private java.lang.String modelName;
	
	private java.lang.String brandName;
	
	private java.lang.String createTimeStart;
	
	private java.lang.String createTimeEnd;
	
	private java.lang.String createTime;
	
	private java.lang.String createBy;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getVisitId() {
		return visitId;
	}

	public void setVisitId(java.lang.Long visitId) {
		this.visitId = visitId;
	}

	public java.lang.Long getBrandId() {
		return brandId;
	}

	public void setBrandId(java.lang.Long brandId) {
		this.brandId = brandId;
	}

	public java.lang.Long getSaleQty() {
		return saleQty;
	}

	public void setSaleQty(java.lang.Long saleQty) {
		this.saleQty = saleQty;
	}

	public java.lang.Long getModelId() {
		return modelId;
	}

	public void setModelId(java.lang.Long modelId) {
		this.modelId = modelId;
	}

	public java.lang.String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(java.lang.String companyCode) {
		this.companyCode = companyCode;
	}

	public java.lang.Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Long companyId) {
		this.companyId = companyId;
	}

	public java.lang.Long getRegionId() {
		return regionId;
	}

	public void setRegionId(java.lang.Long regionId) {
		this.regionId = regionId;
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

	public java.lang.String getShopCode() {
		return shopCode;
	}

	public void setShopCode(java.lang.String shopCode) {
		this.shopCode = shopCode;
	}

	public java.lang.String getShopName() {
		return shopName;
	}

	public void setShopName(java.lang.String shopName) {
		this.shopName = shopName;
	}

	public java.lang.String getEmpName() {
		return empName;
	}

	public void setEmpName(java.lang.String empName) {
		this.empName = empName;
	}

	public java.lang.String getModelName() {
		return modelName;
	}

	public void setModelName(java.lang.String modelName) {
		this.modelName = modelName;
	}

	public java.lang.String getBrandName() {
		return brandName;
	}

	public void setBrandName(java.lang.String brandName) {
		this.brandName = brandName;
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

	public java.lang.String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.lang.String createTime) {
		this.createTime = createTime;
	}

	public java.lang.String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	public java.lang.Long getRegionType() {
		return regionType;
	}

	public void setRegionType(java.lang.Long regionType) {
		this.regionType = regionType;
	}

	@Override
	public String toString() {
		return "VisitSaleInfoDto [id=" + id + ", visitId=" + visitId + ", brandId=" + brandId + ", saleQty=" + saleQty
						+ ", modelId=" + modelId + ", companyId=" + companyId + ", companyCode=" + companyCode
						+ ", regionId=" + regionId + ", regionType=" + regionType + ", countryName=" + countryName
						+ ", cityName=" + cityName + ", shopCode=" + shopCode + ", shopName=" + shopName + ", empName="
						+ empName + ", modelName=" + modelName + ", brandName=" + brandName + ", createTimeStart="
						+ createTimeStart + ", createTimeEnd=" + createTimeEnd + ", createTime=" + createTime
						+ ", createBy=" + createBy + "]";
	}


}
