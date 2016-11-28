package com.transsion.store.dto;

import java.io.Serializable;

public class ShopDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer city; 
	private Long id;
	private String shopName;
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	@Override
	public String toString() {
		return "ShopDto [city=" + city + ", id=" + id + ", shopName=" + shopName + "]";
	}
	
}
