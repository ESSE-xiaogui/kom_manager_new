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

public class RoleResource extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long roleResId;

	/**
	  *	
	  */
	private java.lang.Long roleId;

	/**
	  *	
	  */
	private java.lang.Long resId;

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
	private java.lang.String createTime;

	/**
	  *	
	  */
	private java.lang.String updatedBy;

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
	public java.lang.Long getRoleResId() 
	{
		return roleResId;
	}
	
	/**
	  *	
	  */
	public void setRoleResId(java.lang.Long roleResId) 
	{
		this.roleResId = roleResId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getRoleId() 
	{
		return roleId;
	}
	
	/**
	  *	
	  */
	public void setRoleId(java.lang.Long roleId) 
	{
		this.roleId = roleId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getResId() 
	{
		return resId;
	}
	
	/**
	  *	
	  */
	public void setResId(java.lang.Long resId) 
	{
		this.resId = resId;
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
		return "RoleResource [" + 
					"roleResId=" + roleResId + 
					", roleId=" + roleId + 
					", resId=" + resId + 
					", remark=" + remark + 
					", createdBy=" + createdBy + 
					", createTime=" + createTime + 
					", updatedBy=" + updatedBy + 
					", updateTime=" + updateTime + 
					", version=" + version + 
				"]";
	}
}

