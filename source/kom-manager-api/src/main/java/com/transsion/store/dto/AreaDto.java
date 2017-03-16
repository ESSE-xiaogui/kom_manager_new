package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class AreaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	private java.lang.String pAreaName;

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
	
	private java.lang.Long countryId;
	
	private AreaDto parent;
	
	private List<AreaDto> children;

	public java.lang.Long getAreaId() {
		return areaId;
	}

	public void setAreaId(java.lang.Long areaId) {
		this.areaId = areaId;
	}

	public java.lang.Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Long companyId) {
		this.companyId = companyId;
	}

	public java.lang.String getAreaName() {
		return areaName;
	}

	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	public java.lang.Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(java.lang.Integer areaType) {
		this.areaType = areaType;
	}
	
	public AreaDto getParent() {
		return parent;
	}

	public void setParent(AreaDto parent) {
		this.parent = parent;
	}

	public java.lang.Long getParentId() {
		return parentId;
	}

	public void setParentId(java.lang.Long parentId) {
		this.parentId = parentId;
	}

	public java.lang.Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(java.lang.Integer isInactive) {
		this.isInactive = isInactive;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(java.lang.String createdBy) {
		this.createdBy = createdBy;
	}

	public java.lang.String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(java.lang.String createdTime) {
		this.createdTime = createdTime;
	}

	public java.lang.String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(java.lang.String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public java.lang.String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(java.lang.String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}

	public List<AreaDto> getChildren() {
		return children;
	}

	public void setChildren(List<AreaDto> children) {
		this.children = children;
	}

	public java.lang.Long getCountryId() {
		return countryId;
	}

	public void setCountryId(java.lang.Long countryId) {
		this.countryId = countryId;
	}

	public java.lang.String getpAreaName() {
		return pAreaName;
	}

	public void setpAreaName(java.lang.String pAreaName) {
		this.pAreaName = pAreaName;
	}

	@Override
	public String toString() {
		return "AreaDto [areaId=" + areaId + ", companyId=" + companyId + ", areaName=" + areaName + ", pAreaName="
						+ pAreaName + ", areaType=" + areaType + ", parentId=" + parentId + ", isInactive=" + isInactive
						+ ", remark=" + remark + ", createdBy=" + createdBy + ", createdTime=" + createdTime
						+ ", updatedBy=" + updatedBy + ", updatedTime=" + updatedTime + ", version=" + version
						+ ", countryId=" + countryId + ", children=" + children + "]";
	}

	
}
