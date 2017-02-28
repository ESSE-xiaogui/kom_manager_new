package com.transsion.store.dto;

import java.io.Serializable;

public class RegionListDto implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	/**
	  *	
	  */
	private java.lang.Long id;
	/**
	  *	
	  */
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
	private java.lang.String pRegionName;

	private java.lang.String regionTypeName;
	
	private java.lang.Long regionId;

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

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}

	public java.lang.Integer getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(java.lang.Integer regionCode) {
		this.regionCode = regionCode;
	}

	public java.lang.String getRegionName() {
		return regionName;
	}

	public void setRegionName(java.lang.String regionName) {
		this.regionName = regionName;
	}

	public java.lang.String getpRegionName() {
		return pRegionName;
	}

	public void setpRegionName(java.lang.String pRegionName) {
		this.pRegionName = pRegionName;
	}

	public java.lang.String getRegionTypeName() {
		return regionTypeName;
	}

	public void setRegionTypeName(java.lang.String regionTypeName) {
		this.regionTypeName = regionTypeName;
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

	public java.lang.Long getRegionId() {
		return regionId;
	}

	public void setRegionId(java.lang.Long regionId) {
		this.regionId = regionId;
	}

	@Override
	public String toString() {
		return "RegionListDto [id=" + id + ", companyId=" + companyId + ", regionCode=" + regionCode + ", regionName="
						+ regionName + ", pRegionName=" + pRegionName + ", regionTypeName=" + regionTypeName
						+ ", regionId=" + regionId + ", isInactive=" + isInactive + ", remark=" + remark
						+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", updatedBy=" + updatedBy
						+ ", updatedTime=" + updatedTime + ", version=" + version + "]";
	}

}
