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
package com.transsion.store.dto;

import java.io.Serializable;

import com.transsion.store.bo.Visit;


public class VisitDto implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
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
	private java.lang.Long shopId;

	/**
	  *	
	  */
	private java.lang.Long currentSaleQty;
	
	/**
	  *	
	  */
	private java.lang.Long targetSaleQty;
	
	/**
	 * avg sale per four weeks
	 */
	private java.math.BigDecimal achieved;
	
	/**
	  *itel requirement	
	  */
	private java.lang.Long saleTotalQty;

	/**
	  *	itel requirement
	  *private brand sale qty
	  */
	private java.lang.Long salePbQty;

	/**
	  *	
	  */
	private java.lang.String remark;
	
	private java.lang.String createBy;
	
	private java.lang.String createTime;
	
	private java.lang.String updateBy;
	
	private java.lang.String updateTime;

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
	
	public java.lang.Long getCurrentSaleQty() {
		return currentSaleQty;
	}

	public void setCurrentSaleQty(java.lang.Long currentSaleQty) {
		this.currentSaleQty = currentSaleQty;
	}

	public java.lang.Long getTargetSaleQty() {
		return targetSaleQty;
	}

	public void setTargetSaleQty(java.lang.Long targetSaleQty) {
		this.targetSaleQty = targetSaleQty;
	}

	public java.math.BigDecimal getAchieved() {
		return achieved;
	}

	public void setAchieved(java.math.BigDecimal achieved) {
		this.achieved = achieved;
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
	
	public Visit toModel() {
		Visit visit = new Visit();
		visit.setId(this.getId());
		visit.setVisitDate(this.getVisitDate());
//		visit.setCompanyId();
		visit.setShopId(this.getShopId());
//		visit.setPlanType();
		visit.setSaleTotalQty(this.getSaleTotalQty());
		visit.setSalePbQty(this.getSalePbQty());
		visit.setRemark(this.getRemark());
		visit.setCreateBy(this.getCreateBy());
		visit.setCreateTime(this.getCreateTime());
		visit.setUpdateBy(this.getUpdateBy());
		visit.setUpdateTime(this.getUpdateTime());
//		visit.setVersion();
		return null;
	}

	@Override
	public String toString() {
		return "VisitDto [id=" + id + ", visitDate=" + visitDate + ", shopId=" + shopId + ", currentSaleQty="
				+ currentSaleQty + ", targetSaleQty=" + targetSaleQty + ", achieved=" + achieved + ", saleTotalQty="
				+ saleTotalQty + ", salePbQty=" + salePbQty + ", remark=" + remark + ", createBy=" + createBy
				+ ", createTime=" + createTime + ", updateBy=" + updateBy + ", updateTime=" + updateTime + "]";
	}

}

