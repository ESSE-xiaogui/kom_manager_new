/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-16 14:43:27
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class ReportShopOtcRate extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long reportSotcRateId;

	/**
	  *	事业部ID
	  */
	private java.lang.Long companyId;

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
	private java.lang.String userCode;

	/**
	  *	时间(YYYYMM)
	  */
	private java.lang.String visitDate;

	/**
	  *	上柜店铺数
	  */
	private java.lang.Integer visitShop;

	/**
	  *	总店铺数
	  */
	private java.lang.Integer totalShop;

	/**
	  *	上柜率
	  */
	private java.math.BigDecimal otcRate;

	/**
	  *	保留字段 对应区域表的国家字段
	  */
	private java.lang.Long countryId;

	/**
	  *	保留字段 对应区域表的城市字段
	  */
	private java.lang.Long cityId;

	/**
	  *	
	  */
	private java.lang.Long regionId;

	/**
	  *	
	  */
	private java.lang.Long areaId;

	/**
	  *	
	  */
	private java.lang.String companyName;

	/**
	  *	
	  */
	private java.lang.String areaName;

	/**
	  *	
	  */
	private java.lang.String countryName;

	/**
	  *	
	  */
	private java.lang.String cityName;

	/**
	  *	
	  */
	private java.lang.String regionName;

	/**
	  *	
	  */
	private java.lang.String empName;

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

	/**
	  *	
	  */
	public java.lang.Long getReportSotcRateId() 
	{
		return reportSotcRateId;
	}
	
	/**
	  *	
	  */
	public void setReportSotcRateId(java.lang.Long reportSotcRateId) 
	{
		this.reportSotcRateId = reportSotcRateId;
	}
	
	/**
	  *	事业部ID
	  */
	public java.lang.Long getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	事业部ID
	  */
	public void setCompanyId(java.lang.Long companyId) 
	{
		this.companyId = companyId;
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
	  *	时间(YYYYMM)
	  */
	public java.lang.String getVisitDate() 
	{
		return visitDate;
	}
	
	/**
	  *	时间(YYYYMM)
	  */
	public void setVisitDate(java.lang.String visitDate) 
	{
		this.visitDate = visitDate;
	}
	
	/**
	  *	上柜店铺数
	  */
	public java.lang.Integer getVisitShop() 
	{
		return visitShop;
	}
	
	/**
	  *	上柜店铺数
	  */
	public void setVisitShop(java.lang.Integer visitShop) 
	{
		this.visitShop = visitShop;
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
	  *	上柜率
	  */
	public java.math.BigDecimal getOtcRate() 
	{
		return otcRate;
	}
	
	/**
	  *	上柜率
	  */
	public void setOtcRate(java.math.BigDecimal otcRate) 
	{
		this.otcRate = otcRate;
	}
	
	/**
	  *	保留字段 对应区域表的国家字段
	  */
	public java.lang.Long getCountryId() 
	{
		return countryId;
	}
	
	/**
	  *	保留字段 对应区域表的国家字段
	  */
	public void setCountryId(java.lang.Long countryId) 
	{
		this.countryId = countryId;
	}
	
	/**
	  *	保留字段 对应区域表的城市字段
	  */
	public java.lang.Long getCityId() 
	{
		return cityId;
	}
	
	/**
	  *	保留字段 对应区域表的城市字段
	  */
	public void setCityId(java.lang.Long cityId) 
	{
		this.cityId = cityId;
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
	public java.lang.Long getAreaId() 
	{
		return areaId;
	}
	
	/**
	  *	
	  */
	public void setAreaId(java.lang.Long areaId) 
	{
		this.areaId = areaId;
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
	public java.lang.String getAreaName() 
	{
		return areaName;
	}
	
	/**
	  *	
	  */
	public void setAreaName(java.lang.String areaName) 
	{
		this.areaName = areaName;
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
	
	public String toString()
	{
		return "ReportShopOtcRate [" + 
					"reportSotcRateId=" + reportSotcRateId + 
					", companyId=" + companyId + 
					", brandCode=" + brandCode + 
					", modelCode=" + modelCode + 
					", userCode=" + userCode + 
					", visitDate=" + visitDate + 
					", visitShop=" + visitShop + 
					", totalShop=" + totalShop + 
					", otcRate=" + otcRate + 
					", countryId=" + countryId + 
					", cityId=" + cityId + 
					", regionId=" + regionId + 
					", areaId=" + areaId + 
					", companyName=" + companyName + 
					", areaName=" + areaName + 
					", countryName=" + countryName + 
					", cityName=" + cityName + 
					", regionName=" + regionName + 
					", empName=" + empName + 
					", createdBy=" + createdBy + 
					", createTime=" + createTime + 
					", updatedBy=" + updatedBy + 
					", updateTime=" + updateTime + 
				"]";
	}
}

