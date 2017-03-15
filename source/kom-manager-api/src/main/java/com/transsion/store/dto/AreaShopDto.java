package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class AreaShopDto implements Serializable{

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
	
	private List<AreaShopChildrenDto> shopChildren;
	
	private List<AreaShopDto> children;
	

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


	public List<AreaShopChildrenDto> getShopChildren() {
		return shopChildren;
	}



	public void setShopChildren(List<AreaShopChildrenDto> shopChildren) {
		this.shopChildren = shopChildren;
	}



	public List<AreaShopDto> getChildren() {
		return children;
	}



	public void setChildren(List<AreaShopDto> children) {
		this.children = children;
	}



	@Override
	public String toString() {
		return "AreaShopDto [areaId=" + areaId + ", companyId=" + companyId + ", areaName=" + areaName + ", areaType="
						+ areaType + ", parentId=" + parentId + ", isInactive=" + isInactive + ", shopChildren="
						+ shopChildren + ", children=" + children + "]";
	}



}
