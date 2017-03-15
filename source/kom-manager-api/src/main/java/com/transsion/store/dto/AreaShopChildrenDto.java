package com.transsion.store.dto;

import java.io.Serializable;

public class AreaShopChildrenDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long shopId;
	
	private Long areaId;
	
	private String shopName;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Override
	public String toString() {
		return "AreaShopChildrenDto [shopId=" + shopId + ", areaId=" + areaId + ", shopName=" + shopName + "]";
	}
	
	

}
