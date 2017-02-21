/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 10:24:48
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class VisitStock extends Model{

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
	private java.lang.Long visitId;

	/**
	  *	
	  */
	private java.lang.Long brandId;

	/**
	  *	
	  */
	private java.lang.Long modelId;

	/**
	  *	
	  */
	private java.lang.Long stockQty;

	/**
	  *	avg sale per four weeks
	  */
	private java.math.BigDecimal saleAvg;

	/**
	  *	Inventory turn over, STOCK_QTY/SALE_AVG
	  */
	private java.math.BigDecimal stockIto;

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
	public java.lang.Long getVisitId() 
	{
		return visitId;
	}
	
	/**
	  *	
	  */
	public void setVisitId(java.lang.Long visitId) 
	{
		this.visitId = visitId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getBrandId() 
	{
		return brandId;
	}
	
	/**
	  *	
	  */
	public void setBrandId(java.lang.Long brandId) 
	{
		this.brandId = brandId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getModelId() 
	{
		return modelId;
	}
	
	/**
	  *	
	  */
	public void setModelId(java.lang.Long modelId) 
	{
		this.modelId = modelId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getStockQty() 
	{
		return stockQty;
	}
	
	/**
	  *	
	  */
	public void setStockQty(java.lang.Long stockQty) 
	{
		this.stockQty = stockQty;
	}
	
	/**
	  *	avg sale per four weeks
	  */
	public java.math.BigDecimal getSaleAvg() 
	{
		return saleAvg;
	}
	
	/**
	  *	avg sale per four weeks
	  */
	public void setSaleAvg(java.math.BigDecimal saleAvg) 
	{
		this.saleAvg = saleAvg;
	}
	
	/**
	  *	Inventory turn over, STOCK_QTY/SALE_AVG
	  */
	public java.math.BigDecimal getStockIto() 
	{
		return stockIto;
	}
	
	/**
	  *	Inventory turn over, STOCK_QTY/SALE_AVG
	  */
	public void setStockIto(java.math.BigDecimal stockIto) 
	{
		this.stockIto = stockIto;
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
	
	public String toString()
	{
		return "VisitStock [" + 
					"id=" + id + 
					", visitId=" + visitId + 
					", brandId=" + brandId + 
					", modelId=" + modelId + 
					", stockQty=" + stockQty + 
					", saleAvg=" + saleAvg + 
					", stockIto=" + stockIto + 
					", remark=" + remark + 
					", createBy=" + createBy + 
					", createTime=" + createTime + 
					", updateBy=" + updateBy + 
					", updateTime=" + updateTime + 
					", version=" + version + 
				"]";
	}
}

