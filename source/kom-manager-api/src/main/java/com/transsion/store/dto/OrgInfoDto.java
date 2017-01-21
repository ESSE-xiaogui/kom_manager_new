package com.transsion.store.dto;

import com.shangkang.core.bo.Model;

public class OrgInfoDto extends Model{

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
	private java.lang.Integer orgId;

	/**
	  *	
	  */
	private java.lang.String orgName;
	
	private java.lang.String pOrgName;

	/**
	  *	
	  */
	private java.lang.Integer companyId;

	/**
	  *	
	  */
	private java.lang.Long parentId;

	private java.lang.String bizName;

	/**
	  *	1表示激活状态，被激活有效的数据可以用于新增业务，2表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	private java.lang.Integer isInactive;

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
	public java.lang.Integer getOrgId() 
	{
		return orgId;
	}
	
	/**
	  *	
	  */
	public void setOrgId(java.lang.Integer orgId) 
	{
		this.orgId = orgId;
	}
	
	/**
	  *	
	  */
	public java.lang.String getOrgName() 
	{
		return orgName;
	}
	
	/**
	  *	
	  */
	public void setOrgName(java.lang.String orgName) 
	{
		this.orgName = orgName;
	}
	
	public java.lang.String getpOrgName() {
		return pOrgName;
	}

	public void setpOrgName(java.lang.String pOrgName) {
		this.pOrgName = pOrgName;
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
	
	
	public java.lang.String getBizName() {
		return bizName;
	}

	public void setBizName(java.lang.String bizName) {
		this.bizName = bizName;
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

	@Override
	public String toString() {
		return "OrgInfoDto [id=" + id + ", orgId=" + orgId + ", orgName=" + orgName + ", pOrgName=" + pOrgName
						+ ", companyId=" + companyId + ", parentId=" + parentId + ", bizName=" + bizName
						+ ", isInactive=" + isInactive + ", remark=" + remark + ", createdBy=" + createdBy
						+ ", createdTime=" + createdTime + ", updatedBy=" + updatedBy + ", updatedTime=" + updatedTime
						+ ", version=" + version + "]";
	}


}

