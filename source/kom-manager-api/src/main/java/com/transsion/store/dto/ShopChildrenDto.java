package com.transsion.store.dto;

import java.io.Serializable;

public class ShopChildrenDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long regionId;
	private String shopName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		return "ShopChildrenDto [id=" + id + ", regionId=" + regionId + ", shopName=" + shopName + "]";
	}

}
