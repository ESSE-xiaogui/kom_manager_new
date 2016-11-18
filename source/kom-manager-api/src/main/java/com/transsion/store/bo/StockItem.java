/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:40
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class StockItem extends Model{

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
	private java.lang.Long stockId;

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
	private java.lang.Integer lineId;

	/**
	  *	
	  */
	private java.lang.String brandCode;

	/**
	  *	
	  */
	private java.lang.String modelCode;

	/**
	  *	
	  */
	private java.math.BigDecimal qty;

	/**
	  *	
	  */
	private java.math.BigDecimal price;

	/**
	  *	
	  */
	private java.math.BigDecimal amount;

	/**
	  *	
	  */
	private java.lang.Integer ishistory;

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
	public java.lang.Long getStockId() 
	{
		return stockId;
	}
	
	/**
	  *	
	  */
	public void setStockId(java.lang.Long stockId) 
	{
		this.stockId = stockId;
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
	public java.lang.Integer getLineId() 
	{
		return lineId;
	}
	
	/**
	  *	
	  */
	public void setLineId(java.lang.Integer lineId) 
	{
		this.lineId = lineId;
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
	public java.lang.String getModelCode() 
	{
		return modelCode;
	}
	
	/**
	  *	
	  */
	public void setModelCode(java.lang.String modelCode) 
	{
		this.modelCode = modelCode;
	}
	
	/**
	  *	
	  */
	public java.math.BigDecimal getQty() 
	{
		return qty;
	}
	
	/**
	  *	
	  */
	public void setQty(java.math.BigDecimal qty) 
	{
		this.qty = qty;
	}
	
	/**
	  *	
	  */
	public java.math.BigDecimal getPrice() 
	{
		return price;
	}
	
	/**
	  *	
	  */
	public void setPrice(java.math.BigDecimal price) 
	{
		this.price = price;
	}
	
	/**
	  *	
	  */
	public java.math.BigDecimal getAmount() 
	{
		return amount;
	}
	
	/**
	  *	
	  */
	public void setAmount(java.math.BigDecimal amount) 
	{
		this.amount = amount;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getIshistory() 
	{
		return ishistory;
	}
	
	/**
	  *	
	  */
	public void setIshistory(java.lang.Integer ishistory) 
	{
		this.ishistory = ishistory;
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
	
	public String toString()
	{
		return "StockItem [" + 
					"id=" + id + 
					", stockId=" + stockId + 
					", companyId=" + companyId + 
					", billno=" + billno + 
					", lineId=" + lineId + 
					", brandCode=" + brandCode + 
					", modelCode=" + modelCode + 
					", qty=" + qty + 
					", price=" + price + 
					", amount=" + amount + 
					", ishistory=" + ishistory + 
					", remark=" + remark + 
					", createBy=" + createBy + 
					", createTime=" + createTime + 
					", updateBy=" + updateBy + 
					", updateTime=" + updateTime + 
				"]";
	}
}

