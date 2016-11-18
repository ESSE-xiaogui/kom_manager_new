/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:39
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class Stock extends Model{

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
	private java.lang.Integer companyId;

	/**
	  *	
	  */
	private java.lang.String billno;

	/**
	  *	
	  */
	private java.lang.Integer trantype;

	/**
	  *	
	  */
	private java.lang.Integer shopId;

	/**
	  *	
	  */
	private java.lang.String stockDate;

	/**
	  *	
	  */
	private java.lang.Integer userId;

	/**
	  *	
	  */
	private java.lang.String userCode;

	/**
	  *	
	  */
	private java.lang.String werks;

	/**
	  *	
	  */
	private java.math.BigDecimal currencyRatio;

	/**
	  *	
	  */
	private java.lang.Integer status;

	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	
	  */
	private java.lang.String createdBy;

	/**
	  *	
	  */
	private java.lang.String createdTime;

	/**
	  *	
	  */
	private java.lang.String updatedBy;

	/**
	  *	
	  */
	private java.lang.String updatedTime;

	/**
	  *	
	  */
	private java.lang.Integer version;

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
	public java.lang.Integer getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	
	  */
	public void setCompanyId(java.lang.Integer companyId) 
	{
		this.companyId = companyId;
	}
	
	/**
	  *	
	  */
	public java.lang.String getBillno() 
	{
		return billno;
	}
	
	/**
	  *	
	  */
	public void setBillno(java.lang.String billno) 
	{
		this.billno = billno;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getTrantype() 
	{
		return trantype;
	}
	
	/**
	  *	
	  */
	public void setTrantype(java.lang.Integer trantype) 
	{
		this.trantype = trantype;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getShopId() 
	{
		return shopId;
	}
	
	/**
	  *	
	  */
	public void setShopId(java.lang.Integer shopId) 
	{
		this.shopId = shopId;
	}
	
	/**
	  *	
	  */
	public java.lang.String getStockDate() 
	{
		return stockDate;
	}
	
	/**
	  *	
	  */
	public void setStockDate(java.lang.String stockDate) 
	{
		this.stockDate = stockDate;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getUserId() 
	{
		return userId;
	}
	
	/**
	  *	
	  */
	public void setUserId(java.lang.Integer userId) 
	{
		this.userId = userId;
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
	public java.lang.String getWerks() 
	{
		return werks;
	}
	
	/**
	  *	
	  */
	public void setWerks(java.lang.String werks) 
	{
		this.werks = werks;
	}
	
	/**
	  *	
	  */
	public java.math.BigDecimal getCurrencyRatio() 
	{
		return currencyRatio;
	}
	
	/**
	  *	
	  */
	public void setCurrencyRatio(java.math.BigDecimal currencyRatio) 
	{
		this.currencyRatio = currencyRatio;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getStatus() 
	{
		return status;
	}
	
	/**
	  *	
	  */
	public void setStatus(java.lang.Integer status) 
	{
		this.status = status;
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
	public java.lang.String getCreatedTime() 
	{
		return createdTime;
	}
	
	/**
	  *	
	  */
	public void setCreatedTime(java.lang.String createdTime) 
	{
		this.createdTime = createdTime;
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
	public java.lang.String getUpdatedTime() 
	{
		return updatedTime;
	}
	
	/**
	  *	
	  */
	public void setUpdatedTime(java.lang.String updatedTime) 
	{
		this.updatedTime = updatedTime;
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
	
	public String toString()
	{
		return "Stock [" + 
					"id=" + id + 
					", companyId=" + companyId + 
					", billno=" + billno + 
					", trantype=" + trantype + 
					", shopId=" + shopId + 
					", stockDate=" + stockDate + 
					", userId=" + userId + 
					", userCode=" + userCode + 
					", werks=" + werks + 
					", currencyRatio=" + currencyRatio + 
					", status=" + status + 
					", remark=" + remark + 
					", createdBy=" + createdBy + 
					", createdTime=" + createdTime + 
					", updatedBy=" + updatedBy + 
					", updatedTime=" + updatedTime + 
					", version=" + version + 
				"]";
	}
}

