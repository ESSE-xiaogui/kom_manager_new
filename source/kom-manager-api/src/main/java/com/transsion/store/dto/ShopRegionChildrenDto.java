package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class ShopRegionChildrenDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 城市ID
	 * */
	private java.lang.Long id;
	
	/**
	 * 城市父ID
	 * */
	private java.lang.Long parentId;
	
	/**
	 * 城市名称
	 * */
	private java.lang.String regionName;
	
	/**
	 * 城市下所属店铺信息
	 * */
	private List<ShopChildrenDto> childrenShop;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getParentId() {
		return parentId;
	}

	public void setParentId(java.lang.Long parentId) {
		this.parentId = parentId;
	}

	public java.lang.String getRegionName() {
		return regionName;
	}

	public void setRegionName(java.lang.String regionName) {
		this.regionName = regionName;
	}

	public List<ShopChildrenDto> getChildrenShop() {
		return childrenShop;
	}

	public void setChildrenShop(List<ShopChildrenDto> childrenShop) {
		this.childrenShop = childrenShop;
	}

	@Override
	public String toString() {
		return "ShopRegionChildrenDto [id=" + id + ", parentId=" + parentId + ", regionName=" + regionName
						+ ", childrenShop=" + childrenShop + "]";
	}

}
