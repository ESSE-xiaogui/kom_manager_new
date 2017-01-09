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

public class User extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	keep for align with kom pc
	  */
	private java.lang.Integer userId;

	/**
	  *	
	  */
	private java.lang.String userCode;

	/**
	  *	
	  */
	private java.lang.String userName;

	/**
	  *	
	  */
	private java.lang.Integer empId;

	/**
	  *	keep for align with kom pc
	  */
	private java.lang.Integer companyId;

	/**
	  *	加密保存
	  */
	private java.lang.String password;

	/**
	  *	字典编号：1007
	  */
	private java.lang.Integer userCategory;

	/**
	  *	
	  */
	private java.lang.String forbiddenTime;

	/**
	  *	
	  */
	private java.lang.String pwdUpdated;

	/**
	  *	
	  */
	private java.lang.Integer loginTimes;

	/**
	  *	
	  */
	private java.lang.String lastLogin;

	/**
	  *	
	  */
	private java.lang.Integer isOnline;

	/**
	  *	1表示激活状态，被激活有效的数据可以用于新增业务，2表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	private java.lang.Integer isInactive;

	/**
	  *	备注-512
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
	  *	keep for align with kom pc
	  */
	public java.lang.Integer getUserId() 
	{
		return userId;
	}
	
	/**
	  *	keep for align with kom pc
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
	public java.lang.String getUserName() 
	{
		return userName;
	}
	
	/**
	  *	
	  */
	public void setUserName(java.lang.String userName) 
	{
		this.userName = userName;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getEmpId() 
	{
		return empId;
	}
	
	/**
	  *	
	  */
	public void setEmpId(java.lang.Integer empId) 
	{
		this.empId = empId;
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
	  *	加密保存
	  */
	public java.lang.String getPassword() 
	{
		return password;
	}
	
	/**
	  *	加密保存
	  */
	public void setPassword(java.lang.String password) 
	{
		this.password = password;
	}
	
	/**
	  *	字典编号：1007
	  */
	public java.lang.Integer getUserCategory() 
	{
		return userCategory;
	}
	
	/**
	  *	字典编号：1007
	  */
	public void setUserCategory(java.lang.Integer userCategory) 
	{
		this.userCategory = userCategory;
	}
	
	/**
	  *	
	  */
	public java.lang.String getForbiddenTime() 
	{
		return forbiddenTime;
	}
	
	/**
	  *	
	  */
	public void setForbiddenTime(java.lang.String forbiddenTime) 
	{
		this.forbiddenTime = forbiddenTime;
	}
	
	/**
	  *	
	  */
	public java.lang.String getPwdUpdated() 
	{
		return pwdUpdated;
	}
	
	/**
	  *	
	  */
	public void setPwdUpdated(java.lang.String pwdUpdated) 
	{
		this.pwdUpdated = pwdUpdated;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getLoginTimes() 
	{
		return loginTimes;
	}
	
	/**
	  *	
	  */
	public void setLoginTimes(java.lang.Integer loginTimes) 
	{
		this.loginTimes = loginTimes;
	}
	
	/**
	  *	
	  */
	public java.lang.String getLastLogin() 
	{
		return lastLogin;
	}
	
	/**
	  *	
	  */
	public void setLastLogin(java.lang.String lastLogin) 
	{
		this.lastLogin = lastLogin;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getIsOnline() 
	{
		return isOnline;
	}
	
	/**
	  *	
	  */
	public void setIsOnline(java.lang.Integer isOnline) 
	{
		this.isOnline = isOnline;
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
	

	
	public java.lang.String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(java.lang.String createdBy) {
		this.createdBy = createdBy;
	}

	public java.lang.String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(java.lang.String updatedBy) {
		this.updatedBy = updatedBy;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", userCode=" + userCode + ", userName=" + userName
				+ ", empId=" + empId + ", companyId=" + companyId + ", password=" + password + ", userCategory="
				+ userCategory + ", forbiddenTime=" + forbiddenTime + ", pwdUpdated=" + pwdUpdated + ", loginTimes="
				+ loginTimes + ", lastLogin=" + lastLogin + ", isOnline=" + isOnline + ", isInactive=" + isInactive
				+ ", remark=" + remark + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", updatedBy="
				+ updatedBy + ", updatedTime=" + updatedTime + ", version=" + version + "]";
	}
	

}

