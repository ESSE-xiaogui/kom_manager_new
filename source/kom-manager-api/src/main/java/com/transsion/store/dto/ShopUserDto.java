package com.transsion.store.dto;

import java.io.Serializable;

/**
 * update by guihua.zhang on 2017-03-15
 * */
public class ShopUserDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 店铺Id
	 * */
	private Long id;

	/**
	 * 店铺编码
	 * */
	private Long shopId;

	/**
	 * 店铺名称
	 * */
	private String shopName;
	
	/**
	 * 城市Id 注:上传时候用
	 * */
	private Long cityId;  
	
	/**
	 * 店铺所在城市名称
	 * */
	private String cityName;
	
	/**
	 * 店铺最后访问时间
	 * */
	private String lastVisitDate;
	
	/**
	 * 当前月访问次数
	 * */
	private Integer monthVisitCount;

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

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(String lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}
	
	public Integer getMonthVisitCount() {
		return monthVisitCount;
	}

	public void setMonthVisitCount(Integer monthVisitCount) {
		this.monthVisitCount = monthVisitCount;
	}

	@Override
	public String toString() {
		return "ShopUserDto [id=" + id + ", shopId=" + shopId + ", shopName=" + shopName + ", cityId=" + cityId
						+ ", cityName=" + cityName + ", lastVisitDate=" + lastVisitDate + "]";
	}
}
