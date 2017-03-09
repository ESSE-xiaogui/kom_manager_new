package com.transsion.store.dto;

import java.io.Serializable;

public class ShopResponseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	/**
	 * 店铺名称
	 * */
	private String shopName;
	/**
	 * 当天日期
	 * */
	private String day;
	/**
	 * 状态：1、保存成功。2、门店重复（后台数据库）。3、门店重复（缓存中）
	 * */
	private Integer status=0;
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
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ShopResponseDto [id=" + id + ", shopName=" + shopName + ", day=" + day + ", status=" + status + "]";
	}
	
}
