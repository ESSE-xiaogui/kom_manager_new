/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-16 20:05:25
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class StockCurrent extends Model{

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
	private java.lang.Integer dealerId;

	/**
	  *	
	  */
	private java.lang.String fdate;

	/**
	  *	
	  */
	private java.lang.Integer userId;

	/**
	  *	
	  */
	private java.lang.String brandCode;

	/**
	  *	
	  */
	private java.lang.String modelMatCode;

	/**
	  *	
	  */
	private java.math.BigDecimal fqty;

	/**
	  *	
	  */
	private java.lang.Integer createdBy;

	/**
	  *	
	  */
	private java.lang.String createdTime;

	/**
	  *	
	  */
	private java.lang.Integer updatedBy;

	/**
	  *	
	  */
	private java.lang.String updatedTime;

	/**
	  *	
	  */
	private java.lang.Integer isDelete;

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
	public java.lang.Integer getDealerId() 
	{
		return dealerId;
	}
	
	/**
	  *	
	  */
	public void setDealerId(java.lang.Integer dealerId) 
	{
		this.dealerId = dealerId;
	}
	
	/**
	  *	
	  */
	public java.lang.String getFdate() 
	{
		return fdate;
	}
	
	/**
	  *	
	  */
	public void setFdate(java.lang.String fdate) 
	{
		this.fdate = fdate;
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
	  *	
	  */
	public java.lang.String getModelMatCode() 
	{
		return modelMatCode;
	}
	
	/**
	  *	
	  */
	public void setModelMatCode(java.lang.String modelMatCode) 
	{
		this.modelMatCode = modelMatCode;
	}
	
	/**
	  *	
	  */
	public java.math.BigDecimal getFqty() 
	{
		return fqty;
	}
	
	/**
	  *	
	  */
	public void setFqty(java.math.BigDecimal fqty) 
	{
		this.fqty = fqty;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getCreatedBy() 
	{
		return createdBy;
	}
	
	/**
	  *	
	  */
	public void setCreatedBy(java.lang.Integer createdBy) 
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
	public java.lang.Integer getUpdatedBy() 
	{
		return updatedBy;
	}
	
	/**
	  *	
	  */
	public void setUpdatedBy(java.lang.Integer updatedBy) 
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
	public java.lang.Integer getIsDelete() 
	{
		return isDelete;
	}
	
	/**
	  *	
	  */
	public void setIsDelete(java.lang.Integer isDelete) 
	{
		this.isDelete = isDelete;
	}
	
	public String toString()
	{
		return "StockCurrent [" + 
					"id=" + id + 
					", dealerId=" + dealerId + 
					", fdate=" + fdate + 
					", userId=" + userId + 
					", brandCode=" + brandCode + 
					", modelMatCode=" + modelMatCode + 
					", fqty=" + fqty + 
					", createdBy=" + createdBy + 
					", createdTime=" + createdTime + 
					", updatedBy=" + updatedBy + 
					", updatedTime=" + updatedTime + 
					", isDelete=" + isDelete + 
				"]";
	}
}

