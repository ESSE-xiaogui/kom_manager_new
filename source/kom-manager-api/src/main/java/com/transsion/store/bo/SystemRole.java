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

public class SystemRole extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	public enum Role {

		Promoter("promoter"),
		Supervisor("supervisor"),
		MANAGER("manager"),
		ADMIN("admin");

		private final String value;

		private Role(String value) {
			this.value = value;
		}

		public String getVal() {
			return value;
		}
	};
	
	/**
	  *	角色ID
	  */
	private java.lang.Long roleId;

	/**
	  *	角色编码
	  */
	private java.lang.String roleCode;

	/**
	  *	角色名称
	  */
	private java.lang.String roleName;

	/**
	  *	
	  */
	private java.lang.Integer isInactive;

	/**
	  *	备注
	  */
	private java.lang.String remark;

	/**
	  *	创建人
	  */
	private java.lang.String createdBy;

	/**
	  *	创建时间
	  */
	private java.lang.String createTime;

	/**
	  *	修改人
	  */
	private java.lang.String updatedBy;

	/**
	  *	修改时间
	  */
	private java.lang.String updateTime;

	/**
	  *	角色ID
	  */
	public java.lang.Long getRoleId() 
	{
		return roleId;
	}
	
	/**
	  *	角色ID
	  */
	public void setRoleId(java.lang.Long roleId) 
	{
		this.roleId = roleId;
	}
	
	/**
	  *	角色编码
	  */
	public java.lang.String getRoleCode() 
	{
		return roleCode;
	}
	
	/**
	  *	角色编码
	  */
	public void setRoleCode(java.lang.String roleCode) 
	{
		this.roleCode = roleCode;
	}
	
	/**
	  *	角色名称
	  */
	public java.lang.String getRoleName() 
	{
		return roleName;
	}
	
	/**
	  *	角色名称
	  */
	public void setRoleName(java.lang.String roleName) 
	{
		this.roleName = roleName;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getIsInactive() 
	{
		return isInactive;
	}
	
	/**
	  *	
	  */
	public void setIsInactive(java.lang.Integer isInactive) 
	{
		this.isInactive = isInactive;
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
	public java.lang.String getCreatedBy() 
	{
		return createdBy;
	}
	
	/**
	  *	创建人
	  */
	public void setCreatedBy(java.lang.String createdBy) 
	{
		this.createdBy = createdBy;
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
	  *	修改人
	  */
	public java.lang.String getUpdatedBy() 
	{
		return updatedBy;
	}
	
	/**
	  *	修改人
	  */
	public void setUpdatedBy(java.lang.String updatedBy) 
	{
		this.updatedBy = updatedBy;
	}
	
	/**
	  *	修改时间
	  */
	public java.lang.String getUpdateTime() 
	{
		return updateTime;
	}
	
	/**
	  *	修改时间
	  */
	public void setUpdateTime(java.lang.String updateTime) 
	{
		this.updateTime = updateTime;
	}
	
	public String toString()
	{
		return "SystemRole [" + 
					"roleId=" + roleId + 
					", roleCode=" + roleCode + 
					", roleName=" + roleName + 
					", isInactive=" + isInactive + 
					", remark=" + remark + 
					", createdBy=" + createdBy + 
					", createTime=" + createTime + 
					", updatedBy=" + updatedBy + 
					", updateTime=" + updateTime + 
				"]";
	}
}

