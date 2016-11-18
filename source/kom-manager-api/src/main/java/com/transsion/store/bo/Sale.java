/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:37
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class Sale extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	上下端单据编码相同
	  */
	private java.lang.String billno;

	/**
	  *	
	  */
	private java.lang.String userCode;

	/**
	  *	
	  */
	private java.lang.Integer userId;

	/**
	  *	服务站或者经销商的唯一标识，不可修改，所有业务数据根据此ID号检索数据，而不是根据服务站或经销商代码，此ID号在整个主机厂端是唯一存在的，不能重复
	  */
	private java.lang.Integer shopId;

	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	private java.lang.Integer companyId;

	/**
	  *	数据字典：2402  传音销售单、竞品销售单
	  */
	private java.lang.Integer trantype;

	/**
	  *	参数的实际值，可能有多种数据类型，但同一按照字符串的方式保存
	  */
	private java.lang.String werks;

	/**
	  *	
	  */
	private java.math.BigDecimal currencyRatio;

	/**
	  *	
	  */
	private java.math.BigDecimal saleQty;

	/**
	  *	输入金额可自动计算单价
	  */
	private java.math.BigDecimal saleAmount;

	/**
	  *	
	  */
	private java.lang.String saleDate;

	/**
	  *	字典编号：2411  未发送、发送中、发送成功、发送失败
	  */
	private java.lang.Integer status;

	/**
	  *	备注-512
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
	  *	系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
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
	  *	上下端单据编码相同
	  */
	public java.lang.String getBillno() 
	{
		return billno;
	}
	
	/**
	  *	上下端单据编码相同
	  */
	public void setBillno(java.lang.String billno) 
	{
		this.billno = billno;
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
	  *	服务站或者经销商的唯一标识，不可修改，所有业务数据根据此ID号检索数据，而不是根据服务站或经销商代码，此ID号在整个主机厂端是唯一存在的，不能重复
	  */
	public java.lang.Integer getShopId() 
	{
		return shopId;
	}
	
	/**
	  *	服务站或者经销商的唯一标识，不可修改，所有业务数据根据此ID号检索数据，而不是根据服务站或经销商代码，此ID号在整个主机厂端是唯一存在的，不能重复
	  */
	public void setShopId(java.lang.Integer shopId) 
	{
		this.shopId = shopId;
	}
	
	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	public java.lang.Integer getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	public void setCompanyId(java.lang.Integer companyId) 
	{
		this.companyId = companyId;
	}
	
	/**
	  *	数据字典：2402  传音销售单、竞品销售单
	  */
	public java.lang.Integer getTrantype() 
	{
		return trantype;
	}
	
	/**
	  *	数据字典：2402  传音销售单、竞品销售单
	  */
	public void setTrantype(java.lang.Integer trantype) 
	{
		this.trantype = trantype;
	}
	
	/**
	  *	参数的实际值，可能有多种数据类型，但同一按照字符串的方式保存
	  */
	public java.lang.String getWerks() 
	{
		return werks;
	}
	
	/**
	  *	参数的实际值，可能有多种数据类型，但同一按照字符串的方式保存
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
	public java.math.BigDecimal getSaleQty() 
	{
		return saleQty;
	}
	
	/**
	  *	
	  */
	public void setSaleQty(java.math.BigDecimal saleQty) 
	{
		this.saleQty = saleQty;
	}
	
	/**
	  *	输入金额可自动计算单价
	  */
	public java.math.BigDecimal getSaleAmount() 
	{
		return saleAmount;
	}
	
	/**
	  *	输入金额可自动计算单价
	  */
	public void setSaleAmount(java.math.BigDecimal saleAmount) 
	{
		this.saleAmount = saleAmount;
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
	  *	字典编号：2411  未发送、发送中、发送成功、发送失败
	  */
	public java.lang.Integer getStatus() 
	{
		return status;
	}
	
	/**
	  *	字典编号：2411  未发送、发送中、发送成功、发送失败
	  */
	public void setStatus(java.lang.Integer status) 
	{
		this.status = status;
	}
	
	/**
	  *	备注-512
	  */
	public java.lang.String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	备注-512
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
	  *	系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
	  */
	public java.lang.Integer getVersion() 
	{
		return version;
	}
	
	/**
	  *	系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
	  */
	public void setVersion(java.lang.Integer version) 
	{
		this.version = version;
	}
	
	public String toString()
	{
		return "Sale [" + 
					"id=" + id + 
					", billno=" + billno + 
					", userCode=" + userCode + 
					", userId=" + userId + 
					", shopId=" + shopId + 
					", companyId=" + companyId + 
					", trantype=" + trantype + 
					", werks=" + werks + 
					", currencyRatio=" + currencyRatio + 
					", saleQty=" + saleQty + 
					", saleAmount=" + saleAmount + 
					", saleDate=" + saleDate + 
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

