package com.transsion.store.dto;

import java.io.Serializable;

/**
 * @author guihua.zhang
 * create time 2017-2-20
 * 登录返回门店信息DTO
 * */
public class ShopLoginDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门店ID
	 * */
	private Long shopId;
	
	/**
	 * 门店名称
	 * */
	private String shopName;
	
	/**
	 * 城市名称
	 * */
	private String cityName;
	
	/**
	 * 币别
	 * */
	private String werks;

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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getWerks() {
		return werks;
	}

	public void setWerks(String werks) {
		this.werks = werks;
	}

	@Override
	public String toString() {
		return "ShopLoginDto [shopId=" + shopId + ", shopName=" + shopName + ", cityName=" + cityName + ", werks="
						+ werks + "]";
	}

}
