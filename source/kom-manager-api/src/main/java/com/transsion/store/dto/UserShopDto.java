package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class UserShopDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	
	private List<Long> shopId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getShopId() {
		return shopId;
	}

	public void setShopId(List<Long> shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "UserShopDto [userId=" + userId + ", shopId=" + shopId + "]";
	}

}
