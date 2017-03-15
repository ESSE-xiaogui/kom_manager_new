package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class ShopAreaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long areaId;
	
	private List<Long> shopIdList;

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public List<Long> getShopIdList() {
		return shopIdList;
	}

	public void setShopIdList(List<Long> shopIdList) {
		this.shopIdList = shopIdList;
	}

	@Override
	public String toString() {
		return "ShopAreaDto [areaId=" + areaId + ", shopIdList=" + shopIdList + "]";
	}
	
	

}
