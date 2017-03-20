/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-7 11:42:41
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class ReportSaleWeek extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long reportSaleWeekId;

	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	private java.lang.Long companyId;

	/**
	  *	服务站或者经销商的唯一标识，不可修改，所有业务数据根据此ID号检索数据，而不是根据服务站或经销商代码，此ID号在整个主机厂端是唯一存在的，不能重复
	  */
	private java.lang.Long shopId;

	/**
	  *	
	  */
	private java.lang.Long regionId;

	/**
	  *	
	  */
	private java.lang.Long countryId;

	/**
	  *	
	  */
	private java.lang.Long cityId;

	/**
	  *	区域索引
	  */
	private java.lang.Long areaId;

	/**
	  *	
	  */
	private java.lang.Long gradeId;

	/**
	  *	
	  */
	private java.lang.String userCode;

	/**
	  *	生成方式：国家简称加六位数的序号。
	  */
	private java.lang.String shopCode;

	/**
	  *	
	  */
	private java.lang.String brandCode;

	/**
	  *	机型代码
	  */
	private java.lang.String modelCode;

	/**
	  *	
	  */
	private java.lang.Integer year;

	/**
	  *	
	  */
	private java.lang.Integer week;

	/**
	  *	
	  */
	private java.lang.String companyName;

	/**
	  *	
	  */
	private java.lang.String shopName;

	/**
	  *	店铺等级
	  */
	private java.lang.String gradeName;

	/**
	  *	
	  */
	private java.lang.String empName;

	/**
	  *	
	  */
	private java.lang.String regionName;

	/**
	  *	
	  */
	private java.lang.String countryName;

	/**
	  *	
	  */
	private java.lang.String cityName;

	/**
	  *	区域名称
	  */
	private java.lang.String areaName;

	/**
	  *	总店铺数
	  */
	private java.lang.Integer totalShop;

	/**
	  *	
	  */
	private java.lang.Integer saleQty;

	/**
	  *	
	  */
	private java.lang.Integer stockQty;

	/**
	  *	
	  */
	private java.lang.String createdBy;

	/**
	  *	
	  */
	private java.lang.String createTime;

	/**
	  *	
	  */
	private java.lang.String updatedBy;

	/**
	  *	
	  */
	private java.lang.String updateTime;
	
	private java.lang.String startDate;
	
	private java.lang.String endDate;
	
	private java.lang.Integer regionType;

	/**
	  *	
	  */
	public java.lang.Long getReportSaleWeekId() 
	{
		return reportSaleWeekId;
	}
	
	/**
	  *	
	  */
	public void setReportSaleWeekId(java.lang.Long reportSaleWeekId) 
	{
		this.reportSaleWeekId = reportSaleWeekId;
	}
	
	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	public java.lang.Long getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	public void setCompanyId(java.lang.Long companyId) 
	{
		this.companyId = companyId;
	}
	
	/**
	  *	服务站或者经销商的唯一标识，不可修改，所有业务数据根据此ID号检索数据，而不是根据服务站或经销商代码，此ID号在整个主机厂端是唯一存在的，不能重复
	  */
	public java.lang.Long getShopId() 
	{
		return shopId;
	}
	
	/**
	  *	服务站或者经销商的唯一标识，不可修改，所有业务数据根据此ID号检索数据，而不是根据服务站或经销商代码，此ID号在整个主机厂端是唯一存在的，不能重复
	  */
	public void setShopId(java.lang.Long shopId) 
	{
		this.shopId = shopId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getRegionId() 
	{
		return regionId;
	}
	
	/**
	  *	
	  */
	public void setRegionId(java.lang.Long regionId) 
	{
		this.regionId = regionId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getCountryId() 
	{
		return countryId;
	}
	
	/**
	  *	
	  */
	public void setCountryId(java.lang.Long countryId) 
	{
		this.countryId = countryId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getCityId() 
	{
		return cityId;
	}
	
	/**
	  *	
	  */
	public void setCityId(java.lang.Long cityId) 
	{
		this.cityId = cityId;
	}
	
	/**
	  *	区域索引
	  */
	public java.lang.Long getAreaId() 
	{
		return areaId;
	}
	
	/**
	  *	区域索引
	  */
	public void setAreaId(java.lang.Long areaId) 
	{
		this.areaId = areaId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getGradeId() 
	{
		return gradeId;
	}
	
	/**
	  *	
	  */
	public void setGradeId(java.lang.Long gradeId) 
	{
		this.gradeId = gradeId;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUserCode() 
	{
		return userCode;
	}
	
	/**
	  *	
	  */
	public void setUserCode(java.lang.String userCode) 
	{
		this.userCode = userCode;
	}
	
	/**
	  *	生成方式：国家简称加六位数的序号。
	  */
	public java.lang.String getShopCode() 
	{
		return shopCode;
	}
	
	/**
	  *	生成方式：国家简称加六位数的序号。
	  */
	public void setShopCode(java.lang.String shopCode) 
	{
		this.shopCode = shopCode;
	}
	
	/**
	  *	
	  */
	public java.lang.String getBrandCode() 
	{
		return brandCode;
	}
	
	/**
	  *	
	  */
	public void setBrandCode(java.lang.String brandCode) 
	{
		this.brandCode = brandCode;
	}
	
	/**
	  *	机型代码
	  */
	public java.lang.String getModelCode() 
	{
		return modelCode;
	}
	
	/**
	  *	机型代码
	  */
	public void setModelCode(java.lang.String modelCode) 
	{
		this.modelCode = modelCode;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getYear() 
	{
		return year;
	}
	
	/**
	  *	
	  */
	public void setYear(java.lang.Integer year) 
	{
		this.year = year;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getWeek() 
	{
		return week;
	}
	
	/**
	  *	
	  */
	public void setWeek(java.lang.Integer week) 
	{
		this.week = week;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCompanyName() 
	{
		return companyName;
	}
	
	/**
	  *	
	  */
	public void setCompanyName(java.lang.String companyName) 
	{
		this.companyName = companyName;
	}
	
	/**
	  *	
	  */
	public java.lang.String getShopName() 
	{
		return shopName;
	}
	
	/**
	  *	
	  */
	public void setShopName(java.lang.String shopName) 
	{
		this.shopName = shopName;
	}
	
	/**
	  *	店铺等级
	  */
	public java.lang.String getGradeName() 
	{
		return gradeName;
	}
	
	/**
	  *	店铺等级
	  */
	public void setGradeName(java.lang.String gradeName) 
	{
		this.gradeName = gradeName;
	}
	
	/**
	  *	
	  */
	public java.lang.String getEmpName() 
	{
		return empName;
	}
	
	/**
	  *	
	  */
	public void setEmpName(java.lang.String empName) 
	{
		this.empName = empName;
	}
	
	/**
	  *	
	  */
	public java.lang.String getRegionName() 
	{
		return regionName;
	}
	
	/**
	  *	
	  */
	public void setRegionName(java.lang.String regionName) 
	{
		this.regionName = regionName;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCountryName() 
	{
		return countryName;
	}
	
	/**
	  *	
	  */
	public void setCountryName(java.lang.String countryName) 
	{
		this.countryName = countryName;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCityName() 
	{
		return cityName;
	}
	
	/**
	  *	
	  */
	public void setCityName(java.lang.String cityName) 
	{
		this.cityName = cityName;
	}
	
	/**
	  *	区域名称
	  */
	public java.lang.String getAreaName() 
	{
		return areaName;
	}
	
	/**
	  *	区域名称
	  */
	public void setAreaName(java.lang.String areaName) 
	{
		this.areaName = areaName;
	}
	
	/**
	  *	总店铺数
	  */
	public java.lang.Integer getTotalShop() 
	{
		return totalShop;
	}
	
	/**
	  *	总店铺数
	  */
	public void setTotalShop(java.lang.Integer totalShop) 
	{
		this.totalShop = totalShop;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getSaleQty() 
	{
		return saleQty;
	}
	
	/**
	  *	
	  */
	public void setSaleQty(java.lang.Integer saleQty) 
	{
		this.saleQty = saleQty;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getStockQty() 
	{
		return stockQty;
	}
	
	/**
	  *	
	  */
	public void setStockQty(java.lang.Integer stockQty) 
	{
		this.stockQty = stockQty;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCreatedBy() 
	{
		return createdBy;
	}
	
	/**
	  *	
	  */
	public void setCreatedBy(java.lang.String createdBy) 
	{
		this.createdBy = createdBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCreateTime() 
	{
		return createTime;
	}
	
	/**
	  *	
	  */
	public void setCreateTime(java.lang.String createTime) 
	{
		this.createTime = createTime;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUpdatedBy() 
	{
		return updatedBy;
	}
	
	/**
	  *	
	  */
	public void setUpdatedBy(java.lang.String updatedBy) 
	{
		this.updatedBy = updatedBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUpdateTime() 
	{
		return updateTime;
	}
	
	/**
	  *	
	  */
	public void setUpdateTime(java.lang.String updateTime) 
	{
		this.updateTime = updateTime;
	}
	
	public java.lang.String getStartDate() {
		return startDate;
	}

	public void setStartDate(java.lang.String startDate) {
		this.startDate = startDate;
	}

	public java.lang.String getEndDate() {
		return endDate;
	}

	public void setEndDate(java.lang.String endDate) {
		this.endDate = endDate;
	}
	
	public java.lang.Integer getRegionType() {
		return regionType;
	}

	public void setRegionType(java.lang.Integer regionType) {
		this.regionType = regionType;
	}

	@Override
	public String toString() {
		return "ReportSaleWeek [reportSaleWeekId=" + reportSaleWeekId + ", companyId=" + companyId + ", shopId="
				+ shopId + ", regionId=" + regionId + ", countryId=" + countryId + ", cityId=" + cityId + ", areaId="
				+ areaId + ", gradeId=" + gradeId + ", userCode=" + userCode + ", shopCode=" + shopCode + ", brandCode="
				+ brandCode + ", modelCode=" + modelCode + ", year=" + year + ", week=" + week + ", companyName="
				+ companyName + ", shopName=" + shopName + ", gradeName=" + gradeName + ", empName=" + empName
				+ ", regionName=" + regionName + ", countryName=" + countryName + ", cityName=" + cityName
				+ ", areaName=" + areaName + ", totalShop=" + totalShop + ", saleQty=" + saleQty + ", stockQty="
				+ stockQty + ", createdBy=" + createdBy + ", createTime=" + createTime + ", updatedBy=" + updatedBy
				+ ", updateTime=" + updateTime + ", startDate=" + startDate + ", endDate=" + endDate + ", regionType="
				+ regionType + "]";
	}
}

