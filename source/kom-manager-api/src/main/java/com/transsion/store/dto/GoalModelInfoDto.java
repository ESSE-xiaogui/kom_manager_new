package com.transsion.store.dto;

import java.io.Serializable;

public class GoalModelInfoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	  *	促销员目标销量表,ID自动增长
	  */
	private java.lang.Long id;

	/**
	  *	事业部ID
	  */
	private java.lang.Long companyId;
	
	private java.lang.String companyCode;
	
	private java.lang.String countryName;
	
	private java.lang.String cityName;

	/**
	  *	目标设定年月 格式:201702
	  */
	private java.lang.String goalMonth;
	
	private java.lang.String goalMonthStart;
	
	private java.lang.String goalMonthEnd;

	/**
	  *	店铺id
	  */
	private java.lang.Long shopId;
	
	private java.lang.Long regionId;
	
	private java.lang.Long regionType;

	/**
	  *	店铺编码
	  */
	private java.lang.String shopCode;
	
	private java.lang.String shopName;

	/**
	  *	店铺id
	  */
	private java.lang.Long modelId;

	/**
	  *	店铺编码
	  */
	private java.lang.String modelCode;

	/**
	  *	
	  */
	private java.lang.Long saleTarget;

	/**
	  *	
	  */
	private java.lang.Long saleCurrent;

	/**
	  *	
	  */
	private java.math.BigDecimal achieved;

	/**
	  *	备注
	  */
	private java.lang.String remark;

	/**
	  *	创建人
	  */
	private java.lang.String createBy;
	
	private java.lang.String creatorName;

	/**
	  *	创建时间
	  */
	private java.lang.String createTime;

	/**
	  *	更新人
	  */
	private java.lang.String updateBy;

	/**
	  *	更新时间
	  */
	private java.lang.String updateTime;

	/**
	  *	
	  */
	private java.lang.Integer version;
	
	private java.lang.Long saleFourWeeks;

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

	public java.lang.String getGoalMonth() {
		return goalMonth;
	}

	public void setGoalMonth(java.lang.String goalMonth) {
		this.goalMonth = goalMonth;
	}

	public java.lang.String getGoalMonthStart() {
		return goalMonthStart;
	}

	public void setGoalMonthStart(java.lang.String goalMonthStart) {
		this.goalMonthStart = goalMonthStart;
	}

	public java.lang.String getGoalMonthEnd() {
		return goalMonthEnd;
	}

	public void setGoalMonthEnd(java.lang.String goalMonthEnd) {
		this.goalMonthEnd = goalMonthEnd;
	}

	public java.lang.Long getShopId() {
		return shopId;
	}

	public void setShopId(java.lang.Long shopId) {
		this.shopId = shopId;
	}

	public java.lang.Long getRegionId() {
		return regionId;
	}

	public void setRegionId(java.lang.Long regionId) {
		this.regionId = regionId;
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

	public java.lang.Long getModelId() {
		return modelId;
	}

	public void setModelId(java.lang.Long modelId) {
		this.modelId = modelId;
	}

	public java.lang.String getModelCode() {
		return modelCode;
	}

	public void setModelCode(java.lang.String modelCode) {
		this.modelCode = modelCode;
	}

	public java.lang.Long getSaleTarget() {
		return saleTarget;
	}

	public void setSaleTarget(java.lang.Long saleTarget) {
		this.saleTarget = saleTarget;
	}

	public java.lang.Long getSaleCurrent() {
		return saleCurrent;
	}

	public void setSaleCurrent(java.lang.Long saleCurrent) {
		this.saleCurrent = saleCurrent;
	}

	public java.math.BigDecimal getAchieved() {
		return achieved;
	}

	public void setAchieved(java.math.BigDecimal achieved) {
		this.achieved = achieved;
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

	public java.lang.String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(java.lang.String creatorName) {
		this.creatorName = creatorName;
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

	public java.lang.Long getSaleFourWeeks() {
		return saleFourWeeks;
	}

	public void setSaleFourWeeks(java.lang.Long saleFourWeeks) {
		this.saleFourWeeks = saleFourWeeks;
	}

	public java.lang.Long getRegionType() {
		return regionType;
	}

	public void setRegionType(java.lang.Long regionType) {
		this.regionType = regionType;
	}

	@Override
	public String toString() {
		return "GoalModelInfoDto [id=" + id + ", companyId=" + companyId + ", companyCode=" + companyCode
						+ ", countryName=" + countryName + ", cityName=" + cityName + ", goalMonth=" + goalMonth
						+ ", goalMonthStart=" + goalMonthStart + ", goalMonthEnd=" + goalMonthEnd + ", shopId=" + shopId
						+ ", regionId=" + regionId + ", regionType=" + regionType + ", shopCode=" + shopCode
						+ ", shopName=" + shopName + ", modelId=" + modelId + ", modelCode=" + modelCode
						+ ", saleTarget=" + saleTarget + ", saleCurrent=" + saleCurrent + ", achieved=" + achieved
						+ ", remark=" + remark + ", createBy=" + createBy + ", creatorName=" + creatorName
						+ ", createTime=" + createTime + ", updateBy=" + updateBy + ", updateTime=" + updateTime
						+ ", version=" + version + ", saleFourWeeks=" + saleFourWeeks + "]";
	}


}
