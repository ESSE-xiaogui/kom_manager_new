/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-9 15:06:14
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class Area extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long areaId;

	/**
	  *	
	  */
	private java.lang.Long companyId;

	/**
	  *	
	  */
	private java.lang.String areaName;

	/**
	  *	
	  */
	private java.lang.Integer areaType;

	/**
	  *	
	  */
	private java.lang.Long parentId;

	/**
	  *	1:启用 2：停用
	  */
	private java.lang.Integer isInactive;

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
	  *	系统保留字段，记录数据最后更新用户，用于审计，无业务含义
	  */
	private java.lang.String updatedBy;

	/**
	  *	系统保留字段，记录数据最后时间，用于审计，无业务含义
	  */
	private java.lang.String updatedTime;

	/**
	  *	系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
	  */
	private java.lang.Integer version;

	/**
	  *	
	  */
	public java.lang.Long getAreaId() 
	{
		return areaId;
	}
	
	/**
	  *	
	  */
	public void setAreaId(java.lang.Long areaId) 
	{
		this.areaId = areaId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	
	  */
	public void setCompanyId(java.lang.Long companyId) 
	{
		this.companyId = companyId;
	}
	
	/**
	  *	
	  */
	public java.lang.String getAreaName() 
	{
		return areaName;
	}
	
	/**
	  *	
	  */
	public void setAreaName(java.lang.String areaName) 
	{
		this.areaName = areaName;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getAreaType() 
	{
		return areaType;
	}
	
	/**
	  *	
	  */
	public void setAreaType(java.lang.Integer areaType) 
	{
		this.areaType = areaType;
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
	  *	1:启用 2：停用
	  */
	public java.lang.Integer getIsInactive() 
	{
		return isInactive;
	}
	
	/**
	  *	1:启用 2：停用
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
	  *	系统保留字段，记录数据最后更新用户，用于审计，无业务含义
	  */
	public java.lang.String getUpdatedBy() 
	{
		return updatedBy;
	}
	
	/**
	  *	系统保留字段，记录数据最后更新用户，用于审计，无业务含义
	  */
	public void setUpdatedBy(java.lang.String updatedBy) 
	{
		this.updatedBy = updatedBy;
	}
	
	/**
	  *	系统保留字段，记录数据最后时间，用于审计，无业务含义
	  */
	public java.lang.String getUpdatedTime() 
	{
		return updatedTime;
	}
	
	/**
	  *	系统保留字段，记录数据最后时间，用于审计，无业务含义
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
		return "Area [" + 
					"areaId=" + areaId + 
					", companyId=" + companyId + 
					", areaName=" + areaName + 
					", areaType=" + areaType + 
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

