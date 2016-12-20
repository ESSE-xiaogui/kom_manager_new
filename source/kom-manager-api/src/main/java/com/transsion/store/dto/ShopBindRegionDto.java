package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class ShopBindRegionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 国家ID
	 * */
	private java.lang.Long id;
	
	/**
	 * 国家名称
	 * */
	private java.lang.String regionName;
	
	/**
	 * 国家下所属城市信息
	 * */
	private List<ShopRegionChildrenDto> regionChildren;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getRegionName() {
		return regionName;
	}

	public void setRegionName(java.lang.String regionName) {
		this.regionName = regionName;
	}

	public List<ShopRegionChildrenDto> getRegionChildren() {
		return regionChildren;
	}

	public void setRegionChildren(List<ShopRegionChildrenDto> regionChildren) {
		this.regionChildren = regionChildren;
	}

	@Override
	public String toString() {
		return "ShopBindRegionDto [id=" + id + ", regionName=" + regionName + ", regionChildren=" + regionChildren
						+ "]";
	}

}
