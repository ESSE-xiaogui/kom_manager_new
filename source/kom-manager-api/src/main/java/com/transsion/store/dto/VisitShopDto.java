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
import java.math.BigDecimal;


public class VisitShopDto implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	visit id
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
	
	private java.lang.String shopName;

	/**
	  *	
	  */
	private java.lang.Long currentSaleQty = (long)0;
	
	/**
	  *	
	  */
	private java.lang.Long targetSaleQty = (long) 0;
	
	/**
	 * avg sale per four weeks
	 */
	private java.math.BigDecimal achieved = BigDecimal.valueOf(0);
	
	/**
	  *itel requirement	
	  */
	private java.lang.Long saleTotalQty = (long) 0;

	/**
	  *	itel requirement
	  *private brand sale qty
	  */
	private java.lang.Long salePbQty = (long) 0;

	/**
	  *	
	  */
	private java.lang.String remark;

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
	
	public java.lang.String getShopName() {
		return shopName;
	}

	public void setShopName(java.lang.String shopName) {
		this.shopName = shopName;
	}

	@Override
	public String toString() {
		return "VisitShopDto [id=" + id + ", visitDate=" + visitDate + ", shopId=" + shopId + ", shopName=" + shopName
				+ ", currentSaleQty=" + currentSaleQty + ", targetSaleQty=" + targetSaleQty + ", achieved=" + achieved
				+ ", saleTotalQty=" + saleTotalQty + ", salePbQty=" + salePbQty + ", remark=" + remark + "]";
	}

}

