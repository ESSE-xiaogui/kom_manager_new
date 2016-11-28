package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class RegionShopDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id; 
	private String regionName;
	private Integer city; 
	private String shopName;
	private List<ShopDto> children;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public List<ShopDto> getChildren() {
		return children;
	}
	public void setChildren(List<ShopDto> children) {
		this.children = children;
	}
	
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	@Override
	public String toString() {
		return "RegionShopDto [id=" + id + ", regionName=" + regionName + ", city=" + city + ", shopName=" + shopName
				+ ", children=" + children + "]";
	}

}
