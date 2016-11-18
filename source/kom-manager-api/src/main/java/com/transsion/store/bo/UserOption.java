/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:41
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class UserOption extends Model{

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
	private java.lang.Integer userId;

	/**
	  *	
	  */
	private java.lang.String userCode;

	/**
	  *	
	  */
	private java.lang.Integer optionId;

	/**
	  *	
	  */
	private java.lang.Integer optionCode;

	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	private java.lang.Integer companyId;

	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	系统保留字段，记录数据创建用户，用于审计，无业务含义
	  */
	private java.lang.String createdBy;

	/**
	  *	系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义
	  */
	private java.lang.String createdTime;

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
	public java.lang.Integer getOptionId() 
	{
		return optionId;
	}
	
	/**
	  *	
	  */
	public void setOptionId(java.lang.Integer optionId) 
	{
		this.optionId = optionId;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getOptionCode() 
	{
		return optionCode;
	}
	
	/**
	  *	
	  */
	public void setOptionCode(java.lang.Integer optionCode) 
	{
		this.optionCode = optionCode;
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
	  *	系统保留字段，记录数据创建用户，用于审计，无业务含义
	  */
	public java.lang.String getCreatedBy() 
	{
		return createdBy;
	}
	
	/**
	  *	系统保留字段，记录数据创建用户，用于审计，无业务含义
	  */
	public void setCreatedBy(java.lang.String createdBy) 
	{
		this.createdBy = createdBy;
	}
	
	/**
	  *	系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义
	  */
	public java.lang.String getCreatedTime() 
	{
		return createdTime;
	}
	
	/**
	  *	系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义
	  */
	public void setCreatedTime(java.lang.String createdTime) 
	{
		this.createdTime = createdTime;
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
		return "UserOption [" + 
					"id=" + id + 
					", userId=" + userId + 
					", userCode=" + userCode + 
					", optionId=" + optionId + 
					", optionCode=" + optionCode + 
					", companyId=" + companyId + 
					", remark=" + remark + 
					", createdBy=" + createdBy + 
					", createdTime=" + createdTime + 
					", updateBy=" + updateBy + 
					", updateTime=" + updateTime + 
				"]";
	}
}

