/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 10:24:47
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class Visit extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	public enum State {
		
		PLANNED(1), 
		UNPLANNED(2);
		
		private final int value;

		private State(int value) {
			this.value = value;
		}

		public int getVal() {
			return value;
		}
	};
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.String visitDate;

	/**
	  *	
	  */
	private java.lang.Long companyId;

	/**
	  *	
	  */
	private java.lang.Long shopId;

	/**
	  *	1,plan; 2, not plan
	  */
	private java.lang.Integer planType;

	/**
	  *	
	  */
	private java.lang.Long saleTotalQty;

	/**
	  *	private brand sale qty
	  */
	private java.lang.Long salePbQty;

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
	
	private java.lang.String vistor;
	
	
	
	private java.lang.String companyCode;
	
	private java.lang.String shopCode;
	
	private java.lang.String shopName;
	
	private java.lang.String countryName;
	
	private java.lang.String cityName;
	
	private java.lang.String empName;

	/**
	  *	
	  */
	public java.lang.Long getId() 
	{
		return id;
	}
	
	/**
	  *	
	  */
	public void setId(java.lang.Long id) 
	{
		this.id = id;
	}
	
	/**
	  *	
	  */
	public java.lang.String getVisitDate() 
	{
		return visitDate;
	}
	
	/**
	  *	
	  */
	public void setVisitDate(java.lang.String visitDate) 
	{
		this.visitDate = visitDate;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	
	  */
	public void setCompanyId(java.lang.Long companyId) 
	{
		this.companyId = companyId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getShopId() 
	{
		return shopId;
	}
	
	/**
	  *	
	  */
	public void setShopId(java.lang.Long shopId) 
	{
		this.shopId = shopId;
	}
	
	/**
	  *	1,plan; 2, not plan
	  */
	public java.lang.Integer getPlanType() 
	{
		return planType;
	}
	
	/**
	  *	1,plan; 2, not plan
	  */
	public void setPlanType(java.lang.Integer planType) 
	{
		this.planType = planType;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getSaleTotalQty() 
	{
		return saleTotalQty;
	}
	
	/**
	  *	
	  */
	public void setSaleTotalQty(java.lang.Long saleTotalQty) 
	{
		this.saleTotalQty = saleTotalQty;
	}
	
	/**
	  *	private brand sale qty
	  */
	public java.lang.Long getSalePbQty() 
	{
		return salePbQty;
	}
	
	/**
	  *	private brand sale qty
	  */
	public void setSalePbQty(java.lang.Long salePbQty) 
	{
		this.salePbQty = salePbQty;
	}
	
	/**
	  *	
	  */
	public java.lang.String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	
	  */
	public void setRemark(java.lang.String remark) 
	{
		this.remark = remark;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCreateBy() 
	{
		return createBy;
	}
	
	/**
	  *	
	  */
	public void setCreateBy(java.lang.String createBy) 
	{
		this.createBy = createBy;
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
	public java.lang.String getUpdateBy() 
	{
		return updateBy;
	}
	
	/**
	  *	
	  */
	public void setUpdateBy(java.lang.String updateBy) 
	{
		this.updateBy = updateBy;
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
	
	/**
	  *	
	  */
	public java.lang.Integer getVersion() 
	{
		return version;
	}
	
	/**
	  *	
	  */
	public void setVersion(java.lang.Integer version) 
	{
		this.version = version;
	}
	
	public java.lang.String getVistor() {
		return vistor;
	}

	public void setVistor(java.lang.String vistor) {
		this.vistor = vistor;
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

	public java.lang.String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(java.lang.String companyCode) {
		this.companyCode = companyCode;
	}
	
	public java.lang.String getEmpName() {
		return empName;
	}

	public void setEmpName(java.lang.String empName) {
		this.empName = empName;
	}

	public String toString()
	{
		return "Visit [" + 
					"id=" + id + 
					", visitDate=" + visitDate + 
					", companyId=" + companyId + 
					", shopId=" + shopId + 
					", planType=" + planType + 
					", saleTotalQty=" + saleTotalQty + 
					", salePbQty=" + salePbQty + 
					", remark=" + remark + 
					", createBy=" + createBy + 
					", createTime=" + createTime + 
					", updateBy=" + updateBy + 
					", updateTime=" + updateTime + 
					", version=" + version + 
				"]";
	}
}

