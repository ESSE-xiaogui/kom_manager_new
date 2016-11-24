package com.transsion.store.dto;

import java.util.List;

public class RegionDto {	
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
	private java.lang.Long parentId;

	/**
	  *	字典编号：1020
	  */
	private java.lang.Integer regionType;

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
	private List<RegionDto> children;

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

	public java.lang.Long getParentId() {
		return parentId;
	}

	public void setParentId(java.lang.Long parentId) {
		this.parentId = parentId;
	}

	public java.lang.Integer getRegionType() {
		return regionType;
	}

	public void setRegionType(java.lang.Integer regionType) {
		this.regionType = regionType;
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

	public List<RegionDto> getChildren() {
		return children;
	}

	public void setChildren(List<RegionDto> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "RegionDto [id=" + id + ", companyId=" + companyId + ", regionCode=" + regionCode + ", regionName="
				+ regionName + ", parentId=" + parentId + ", regionType=" + regionType + ", isInactive=" + isInactive
				+ ", remark=" + remark + ", children=" + children + "]";
	}


	
	
}
