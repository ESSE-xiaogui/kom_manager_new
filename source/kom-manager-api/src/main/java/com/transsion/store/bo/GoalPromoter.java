/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-1 16:31:42
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class GoalPromoter extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	促销员目标销量表,ID自动增长
	  */
	private java.lang.Long id;

	/**
	  *	事业部ID
	  */
	private java.lang.Long companyId;

	/**
	  *	目标设定年月 格式:201702
	  */
	private java.lang.String goalMonth;

	/**
	  *	用户ID
	  */
	private java.lang.Long userId;

	/**
	  *	用户编码
	  */
	private java.lang.String userCode;

	/**
	  *	店铺id
	  */
	private java.lang.Long shopId;

	/**
	  *	店铺编码
	  */
	private java.lang.String shopCode;

	/**
	  *	
	  */
	private java.lang.Long saleTarget;

	/**
	  *	
	  */
	private java.lang.Long saleCurrent;

	/**
	  *	
	  */
	private java.math.BigDecimal achieved;

	/**
	  *	备注
	  */
	private java.lang.String remark;

	/**
	  *	创建人
	  */
	private java.lang.String createBy;

	/**
	  *	创建时间
	  */
	private java.lang.String createTime;

	/**
	  *	更新人
	  */
	private java.lang.String updateBy;

	/**
	  *	更新时间
	  */
	private java.lang.String updateTime;

	/**
	  *	
	  */
	private java.lang.Integer version;

	/**
	  *	促销员目标销量表,ID自动增长
	  */
	public java.lang.Long getId() 
	{
		return id;
	}
	
	/**
	  *	促销员目标销量表,ID自动增长
	  */
	public void setId(java.lang.Long id) 
	{
		this.id = id;
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
	  *	目标设定年月 格式:201702
	  */
	public java.lang.String getGoalMonth() 
	{
		return goalMonth;
	}
	
	/**
	  *	目标设定年月 格式:201702
	  */
	public void setGoalMonth(java.lang.String goalMonth) 
	{
		this.goalMonth = goalMonth;
	}
	
	/**
	  *	用户ID
	  */
	public java.lang.Long getUserId() 
	{
		return userId;
	}
	
	/**
	  *	用户ID
	  */
	public void setUserId(java.lang.Long userId) 
	{
		this.userId = userId;
	}
	
	/**
	  *	用户编码
	  */
	public java.lang.String getUserCode() 
	{
		return userCode;
	}
	
	/**
	  *	用户编码
	  */
	public void setUserCode(java.lang.String userCode) 
	{
		this.userCode = userCode;
	}
	
	/**
	  *	店铺id
	  */
	public java.lang.Long getShopId() 
	{
		return shopId;
	}
	
	/**
	  *	店铺id
	  */
	public void setShopId(java.lang.Long shopId) 
	{
		this.shopId = shopId;
	}
	
	/**
	  *	店铺编码
	  */
	public java.lang.String getShopCode() 
	{
		return shopCode;
	}
	
	/**
	  *	店铺编码
	  */
	public void setShopCode(java.lang.String shopCode) 
	{
		this.shopCode = shopCode;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getSaleTarget() 
	{
		return saleTarget;
	}
	
	/**
	  *	
	  */
	public void setSaleTarget(java.lang.Long saleTarget) 
	{
		this.saleTarget = saleTarget;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getSaleCurrent() 
	{
		return saleCurrent;
	}
	
	/**
	  *	
	  */
	public void setSaleCurrent(java.lang.Long saleCurrent) 
	{
		this.saleCurrent = saleCurrent;
	}
	
	/**
	  *	
	  */
	public java.math.BigDecimal getAchieved() 
	{
		return achieved;
	}
	
	/**
	  *	
	  */
	public void setAchieved(java.math.BigDecimal achieved) 
	{
		this.achieved = achieved;
	}
	
	/**
	  *	备注
	  */
	public java.lang.String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	备注
	  */
	public void setRemark(java.lang.String remark) 
	{
		this.remark = remark;
	}
	
	/**
	  *	创建人
	  */
	public java.lang.String getCreateBy() 
	{
		return createBy;
	}
	
	/**
	  *	创建人
	  */
	public void setCreateBy(java.lang.String createBy) 
	{
		this.createBy = createBy;
	}
	
	/**
	  *	创建时间
	  */
	public java.lang.String getCreateTime() 
	{
		return createTime;
	}
	
	/**
	  *	创建时间
	  */
	public void setCreateTime(java.lang.String createTime) 
	{
		this.createTime = createTime;
	}
	
	/**
	  *	更新人
	  */
	public java.lang.String getUpdateBy() 
	{
		return updateBy;
	}
	
	/**
	  *	更新人
	  */
	public void setUpdateBy(java.lang.String updateBy) 
	{
		this.updateBy = updateBy;
	}
	
	/**
	  *	更新时间
	  */
	public java.lang.String getUpdateTime() 
	{
		return updateTime;
	}
	
	/**
	  *	更新时间
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
		return "GoalPromoter [" + 
					"id=" + id + 
					", companyId=" + companyId + 
					", goalMonth=" + goalMonth + 
					", userId=" + userId + 
					", userCode=" + userCode + 
					", shopId=" + shopId + 
					", shopCode=" + shopCode + 
					", saleTarget=" + saleTarget + 
					", saleCurrent=" + saleCurrent + 
					", achieved=" + achieved + 
					", remark=" + remark + 
					", createBy=" + createBy + 
					", createTime=" + createTime + 
					", updateBy=" + updateBy + 
					", updateTime=" + updateTime + 
					", version=" + version + 
				"]";
	}
}

