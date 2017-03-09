package com.transsion.store.dto;

import java.io.Serializable;

public class ShopQueryDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String shopName;
	
	private Long userId;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ShopQueryDto [shopName=" + shopName + ", userId=" + userId + "]";
	}

}
