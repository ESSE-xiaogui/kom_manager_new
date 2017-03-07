package com.transsion.store.dto;

import java.io.Serializable;

public class GoalSupervisorInfoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5573819082519566803L;
	
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
	
	private java.lang.Long regionId;
	
	private java.lang.Long regionType;
	
	private java.lang.String dutyName;

	/**
	  *	目标设定年月 格式:201702
	  */
	private java.lang.String goalMonth;

	/**
	  *	用户ID
	  */
	private java.lang.Long userId;

	/**
	  *	用户编码
	  */
	private java.lang.String userCode;

	/**
	  *	店铺id
	  */
	private java.lang.Long shopId;

	/**
	  *	店铺编码
	  */
	private java.lang.String shopCode;
	
	private java.lang.String shopName;

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
	  *	创建人
	  */
	private java.lang.String createBy;

	/**
	  *	创建时间
	  */
	private java.lang.String createTime;
	
	private java.lang.String createTimeStart;
	
	private java.lang.String createTimeEnd;
	
	private java.lang.String empName;
	
	private java.lang.String creatorName;

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

	public java.lang.Long getRegionId() {
		return regionId;
	}

	public void setRegionId(java.lang.Long regionId) {
		this.regionId = regionId;
	}

	public java.lang.String getDutyName() {
		return dutyName;
	}

	public void setDutyName(java.lang.String dutyName) {
		this.dutyName = dutyName;
	}

	public java.lang.String getGoalMonth() {
		return goalMonth;
	}

	public void setGoalMonth(java.lang.String goalMonth) {
		this.goalMonth = goalMonth;
	}

	public java.lang.Long getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}

	public java.lang.String getUserCode() {
		return userCode;
	}

	public void setUserCode(java.lang.String userCode) {
		this.userCode = userCode;
	}

	public java.lang.Long getShopId() {
		return shopId;
	}

	public void setShopId(java.lang.Long shopId) {
		this.shopId = shopId;
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

	public java.lang.String getEmpName() {
		return empName;
	}

	public void setEmpName(java.lang.String empName) {
		this.empName = empName;
	}

	public java.lang.String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(java.lang.String creatorName) {
		this.creatorName = creatorName;
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

	public java.lang.Long getRegionType() {
		return regionType;
	}

	public void setRegionType(java.lang.Long regionType) {
		this.regionType = regionType;
	}

	@Override
	public String toString() {
		return "GoalSupervisorInfoDto [id=" + id + ", companyId=" + companyId + ", companyCode=" + companyCode
						+ ", countryName=" + countryName + ", cityName=" + cityName + ", regionId=" + regionId
						+ ", regionType=" + regionType + ", dutyName=" + dutyName + ", goalMonth=" + goalMonth
						+ ", userId=" + userId + ", userCode=" + userCode + ", shopId=" + shopId + ", shopCode="
						+ shopCode + ", shopName=" + shopName + ", saleTarget=" + saleTarget + ", saleCurrent="
						+ saleCurrent + ", achieved=" + achieved + ", createBy=" + createBy + ", createTime="
						+ createTime + ", createTimeStart=" + createTimeStart + ", createTimeEnd=" + createTimeEnd
						+ ", empName=" + empName + ", creatorName=" + creatorName + "]";
	}



}
