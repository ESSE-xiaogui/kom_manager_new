package com.transsion.store.dto;

import java.io.Serializable;

public class ShopChildrenDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long shopId;
	private Long regionId;
	private String shopName;
	
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	@Override
	public String toString() {
		return "ShopChildrenDto [shopId=" + shopId + ", regionId=" + regionId + ", shopName=" + shopName + "]";
	}

}
