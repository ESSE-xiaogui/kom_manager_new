/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:42
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class UserRole extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long userRoleId;

	/**
	  *	
	  */
	private java.lang.Long userId;

	/**
	  *	
	  */
	private java.lang.Long roleId;

	/**
	  *	
	  */
	private java.lang.String roleName;

	/**
	  *	1表示激活状态，被激活有效的数据可以用于新增业务，2表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	private java.lang.Integer isInactive;

	/**
	  *	
	  */
	private java.lang.String reqDate;

	/**
	  *	
	  */
	private java.lang.String checkDate;

	/**
	  *	
	  */
	private java.lang.String checkStaff;

	/**
	  *	
	  */
	private java.lang.String startDate;

	/**
	  *	
	  */
	private java.lang.String endDate;

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
	public java.lang.Long getUserRoleId() 
	{
		return userRoleId;
	}
	
	/**
	  *	
	  */
	public void setUserRoleId(java.lang.Long userRoleId) 
	{
		this.userRoleId = userRoleId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getUserId() 
	{
		return userId;
	}
	
	/**
	  *	
	  */
	public void setUserId(java.lang.Long userId) 
	{
		this.userId = userId;
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
	public java.lang.String getRoleName() 
	{
		return roleName;
	}
	
	/**
	  *	
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
	  *	
	  */
	public java.lang.String getReqDate() 
	{
		return reqDate;
	}
	
	/**
	  *	
	  */
	public void setReqDate(java.lang.String reqDate) 
	{
		this.reqDate = reqDate;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCheckDate() 
	{
		return checkDate;
	}
	
	/**
	  *	
	  */
	public void setCheckDate(java.lang.String checkDate) 
	{
		this.checkDate = checkDate;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCheckStaff() 
	{
		return checkStaff;
	}
	
	/**
	  *	
	  */
	public void setCheckStaff(java.lang.String checkStaff) 
	{
		this.checkStaff = checkStaff;
	}
	
	/**
	  *	
	  */
	public java.lang.String getStartDate() 
	{
		return startDate;
	}
	
	/**
	  *	
	  */
	public void setStartDate(java.lang.String startDate) 
	{
		this.startDate = startDate;
	}
	
	/**
	  *	
	  */
	public java.lang.String getEndDate() 
	{
		return endDate;
	}
	
	/**
	  *	
	  */
	public void setEndDate(java.lang.String endDate) 
	{
		this.endDate = endDate;
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
		return "UserRole [" + 
					"userRoleId=" + userRoleId + 
					", userId=" + userId + 
					", roleId=" + roleId + 
					", roleName=" + roleName + 
					", isInactive=" + isInactive + 
					", reqDate=" + reqDate + 
					", checkDate=" + checkDate + 
					", checkStaff=" + checkStaff + 
					", startDate=" + startDate + 
					", endDate=" + endDate + 
					", remark=" + remark + 
					", createBy=" + createBy + 
					", createTime=" + createTime + 
					", updateBy=" + updateBy + 
					", updateTime=" + updateTime + 
				"]";
	}
}

