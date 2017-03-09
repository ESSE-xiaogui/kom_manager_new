package com.transsion.store.dto;

import java.io.Serializable;

import com.transsion.store.bo.Region;


public class ShopResponseInfoDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long Id; 
	/**
	 * 门店名称
	 * */
	private String shopName;
	
	/**
	 * 店铺时间
	 * */
	private String shopDate;
	
	/**
	 * 国家名称
	 * */
	private Integer country;
	/**
	 * 国家名称
	 */
	private String countryName;
	/**
	 * 城市名称
	 * */
	private Integer city;
	/**
	 * 城市名称
	 * */
	private String cityName;
	/**
	 * 详细地址
	 * */
	private String address;
	
	/**
	 * 区域表
	 * */
	private Region regions;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopDate() {
		return shopDate;
	}

	public void setShopDate(String shopDate) {
		this.shopDate = shopDate;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Region getRegions() {
		return regions;
	}

	public void setRegions(Region regions) {
		this.regions = regions;
	}

	@Override
	public String toString() {
		return "ShopResponseInfoDto [Id=" + Id + ", shopName=" + shopName + ", shopDate=" + shopDate + ", country="
						+ country + ", countryName=" + countryName + ", city=" + city + ", cityName=" + cityName
						+ ", address=" + address + ", regions=" + regions + "]";
	}	
}
