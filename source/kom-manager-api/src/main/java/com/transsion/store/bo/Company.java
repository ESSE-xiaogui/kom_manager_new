/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:35
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class Company extends Model{

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
	private java.lang.String companyCode;

	/**
	  *	
	  */
	private java.lang.String companyName;

	/**
	  *	
	  */
	private java.lang.Long parentId;

	/**
	  *	0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	private java.lang.Integer isInactive;

	/**
	  *	
	  */
	private java.lang.String remark;

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
	public java.lang.String getCompanyCode() 
	{
		return companyCode;
	}
	
	/**
	  *	
	  */
	public void setCompanyCode(java.lang.String companyCode) 
	{
		this.companyCode = companyCode;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCompanyName() 
	{
		return companyName;
	}
	
	/**
	  *	
	  */
	public void setCompanyName(java.lang.String companyName) 
	{
		this.companyName = companyName;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getParentId() 
	{
		return parentId;
	}
	
	/**
	  *	
	  */
	public void setParentId(java.lang.Long parentId) 
	{
		this.parentId = parentId;
	}
	
	/**
	  *	0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	public java.lang.Integer getIsInactive() 
	{
		return isInactive;
	}
	
	/**
	  *	0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	public void setIsInactive(java.lang.Integer isInactive) 
	{
		this.isInactive = isInactive;
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
		return "Company [" + 
					"id=" + id + 
					", companyCode=" + companyCode + 
					", companyName=" + companyName + 
					", parentId=" + parentId + 
					", isInactive=" + isInactive + 
					", remark=" + remark + 
					", createdBy=" + createdBy + 
					", createdTime=" + createdTime + 
					", updatedBy=" + updatedBy + 
					", updatedTime=" + updatedTime + 
					", version=" + version + 
				"]";
	}
}

