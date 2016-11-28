package com.transsion.store.dto;

import java.io.Serializable;

public class ShopUserDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;

	private Long shopId;

	private String shopName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Override
	public String toString() {
		return "ShopUserDto [id=" + id + ", shopId=" + shopId + ", shopName=" + shopName + "]";
	} 

}
