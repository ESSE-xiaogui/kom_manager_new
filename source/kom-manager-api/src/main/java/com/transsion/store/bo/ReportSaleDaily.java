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

public class ReportSaleDaily extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long reportSaleDailyId;

	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	private java.lang.Long companyId;

	/**
	  *	服务站或者经销商的唯一标识，不可修改，所有业务数据根据此ID号检索数据，而不是根据服务站或经销商代码，此ID号在整个主机厂端是唯一存在的，不能重复
	  */
	private java.lang.Long shopId;

	/**
	  *	生成方式：国家简称加六位数的序号。
	  */
	private java.lang.String shopCode;

	/**
	  *	
	  */
	private java.lang.String userCode;

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
	private java.lang.String saleDate;

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
	  *	
	  */
	private java.lang.String empName;

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

	/**
	  *	
	  */
	public java.lang.Long getReportSaleDailyId() 
	{
		return reportSaleDailyId;
	}
	
	/**
	  *	
	  */
	public void setReportSaleDailyId(java.lang.Long reportSaleDailyId) 
	{
		this.reportSaleDailyId = reportSaleDailyId;
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
	public java.lang.String getSaleDate() 
	{
		return saleDate;
	}
	
	/**
	  *	
	  */
	public void setSaleDate(java.lang.String saleDate) 
	{
		this.saleDate = saleDate;
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
	
	public String toString()
	{
		return "ReportSaleDaily [" + 
					"reportSaleDailyId=" + reportSaleDailyId + 
					", companyId=" + companyId + 
					", shopId=" + shopId + 
					", shopCode=" + shopCode + 
					", userCode=" + userCode + 
					", brandCode=" + brandCode + 
					", modelCode=" + modelCode + 
					", saleDate=" + saleDate + 
					", week=" + week + 
					", companyName=" + companyName + 
					", shopName=" + shopName + 
					", empName=" + empName + 
					", countryName=" + countryName + 
					", cityName=" + cityName + 
					", saleQty=" + saleQty + 
					", stockQty=" + stockQty + 
					", createdBy=" + createdBy + 
					", createTime=" + createTime + 
					", updatedBy=" + updatedBy + 
					", updateTime=" + updateTime + 
				"]";
	}
}

