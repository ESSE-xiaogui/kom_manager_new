package com.transsion.store.dto;

import java.io.Serializable;

public class VisitStockDetailDto implements Serializable {
	private static final long serialVersionUID = 720070217645292759L;
	
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

	/**
	  *	
	  */
	private java.lang.Long modelId;

	/**
	  *	
	  */
	private java.lang.Long stockQty;

	/**
	  *	avg sale per four weeks
	  */
	private java.math.BigDecimal saleAvg;

	/**
	  *	Inventory turn over, STOCK_QTY/SALE_AVG
	  */
	private java.math.BigDecimal stockIto;

	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	
	  */
	private java.lang.String createBy;

	/**
	  *	
	  */
	private java.lang.String createTime;

	/**
	  *	
	  */
	private java.lang.String updateBy;

	/**
	  *	
	  */
	private java.lang.String updateTime;

	/**
	  *	
	  */
	private java.lang.Integer version;
	
	private java.lang.Long companyId;
	
	private java.lang.String companyCode;
	
	private java.lang.Long regionId;
	
	private java.lang.Long countryId;
	
	private java.lang.String countryName;
	
	private java.lang.Long cityId;
	
	private java.lang.String cityName;
	
	private java.lang.String shopCode;
	
	private java.lang.String shopName;
	
	private java.lang.String empName;
	
	private java.lang.String modelName;
	
	private java.lang.String createTimeStart;
	
	private java.lang.String createTimeEnd;

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

	public java.lang.Long getModelId() {
		return modelId;
	}

	public void setModelId(java.lang.Long modelId) {
		this.modelId = modelId;
	}

	public java.lang.Long getStockQty() {
		return stockQty;
	}

	public void setStockQty(java.lang.Long stockQty) {
		this.stockQty = stockQty;
	}

	public java.math.BigDecimal getSaleAvg() {
		return saleAvg;
	}

	public void setSaleAvg(java.math.BigDecimal saleAvg) {
		this.saleAvg = saleAvg;
	}

	public java.math.BigDecimal getStockIto() {
		return stockIto;
	}

	public void setStockIto(java.math.BigDecimal stockIto) {
		this.stockIto = stockIto;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	public java.lang.String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.lang.String createTime) {
		this.createTime = createTime;
	}

	public java.lang.String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}

	public java.lang.String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.lang.String updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}

	public java.lang.Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Long companyId) {
		this.companyId = companyId;
	}

	public java.lang.String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(java.lang.String companyCode) {
		this.companyCode = companyCode;
	}

	public java.lang.Long getCountryId() {
		return countryId;
	}

	public java.lang.Long getRegionId() {
		return regionId;
	}

	public void setRegionId(java.lang.Long regionId) {
		this.regionId = regionId;
	}

	public void setCountryId(java.lang.Long countryId) {
		this.countryId = countryId;
	}

	public java.lang.String getCountryName() {
		return countryName;
	}

	public void setCountryName(java.lang.String countryName) {
		this.countryName = countryName;
	}

	public java.lang.Long getCityId() {
		return cityId;
	}

	public void setCityId(java.lang.Long cityId) {
		this.cityId = cityId;
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

	public java.lang.String getModelName() {
		return modelName;
	}

	public void setModelName(java.lang.String modelName) {
		this.modelName = modelName;
	}

	@Override
	public String toString() {
		return "VisitStockDetailDto [id=" + id + ", visitId=" + visitId + ", brandId=" + brandId + ", modelId="
						+ modelId + ", stockQty=" + stockQty + ", saleAvg=" + saleAvg + ", stockIto=" + stockIto
						+ ", remark=" + remark + ", createBy=" + createBy + ", createTime=" + createTime + ", updateBy="
						+ updateBy + ", updateTime=" + updateTime + ", version=" + version + ", companyId=" + companyId
						+ ", companyCode=" + companyCode + ", regionId=" + regionId + ", countryId=" + countryId
						+ ", countryName=" + countryName + ", cityId=" + cityId + ", cityName=" + cityName
						+ ", shopCode=" + shopCode + ", shopName=" + shopName + ", empName=" + empName + ", modelName="
						+ modelName + ", createTimeStart=" + createTimeStart + ", createTimeEnd=" + createTimeEnd + "]";
	}



}
