/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:36
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class Region extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;
	
	private java.lang.Integer companyId;

	/**
	  *	地域定义表中包括了国家、省份、城市、区县等
	  */
	private java.lang.Integer regionCode;

	/**
	  *	
	  */
	private java.lang.String regionName;

	/**
	  *	
	  */
	private java.lang.Long parentId;

	/**
	  *	字典编号：1020
	  */
	private String regionType;

	/**
	  *	1表示激活状态，被激活有效的数据可以用于新增业务，2表示停用，被停用无效的数据只能用于历史数据查询中
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
	
	
	
	public java.lang.Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}

	/**
	  *	地域定义表中包括了国家、省份、城市、区县等
	  */
	public java.lang.Integer getRegionCode() 
	{
		return regionCode;
	}
	
	/**
	  *	地域定义表中包括了国家、省份、城市、区县等
	  */
	public void setRegionCode(java.lang.Integer regionCode) 
	{
		this.regionCode = regionCode;
	}
	
	/**
	  *	
	  */
	public java.lang.String getRegionName() 
	{
		return regionName;
	}
	
	/**
	  *	
	  */
	public void setRegionName(java.lang.String regionName) 
	{
		this.regionName = regionName;
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
	
	public String getRegionType() {
		return regionType;
	}

	public void setRegionType(String regionType) {
		this.regionType = regionType;
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

	@Override
	public String toString() {
		return "Region [id=" + id + ", companyId=" + companyId + ", regionCode=" + regionCode + ", regionName="
				+ regionName + ", parentId=" + parentId + ", regionType=" + regionType + ", isInactive=" + isInactive
				+ ", remark=" + remark + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", updatedBy="
				+ updatedBy + ", updatedTime=" + updatedTime + ", version=" + version + "]";
	}
}

