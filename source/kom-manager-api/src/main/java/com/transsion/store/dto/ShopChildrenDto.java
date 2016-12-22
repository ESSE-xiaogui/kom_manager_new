package com.transsion.store.dto;

import java.io.Serializable;

public class ShopChildrenDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long shopId;
	private Long regionId;
	private Long optionId;
	private Long userOptionId;
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
	
	public Long getOptionId() {
		return optionId;
	}
	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public Long getUserOptionId() {
		return userOptionId;
	}
	public void setUserOptionId(Long userOptionId) {
		this.userOptionId = userOptionId;
	}
	@Override
	public String toString() {
		return "ShopChildrenDto [shopId=" + shopId + ", regionId=" + regionId + ", optionId=" + optionId + ", userOptionId="
						+ userOptionId + ", shopName=" + shopName + "]";
	}

}
