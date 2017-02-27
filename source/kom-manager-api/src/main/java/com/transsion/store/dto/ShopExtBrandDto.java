package com.transsion.store.dto;

import java.io.Serializable;

public class ShopExtBrandDto implements Serializable {
	private static final long serialVersionUID = -4587039978591569207L;
	
	private String brandName;
	private Integer brandQty;
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getBrandQty() {
		return brandQty;
	}
	public void setBrandQty(Integer brandQty) {
		this.brandQty = brandQty;
	}
	
	@Override
	public String toString() {
		return "ShopBrandDto [brandName=" + brandName + ", brandQty=" + brandQty + "]";
	}
	
}
