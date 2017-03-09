package com.transsion.store.dto;

public class StatShopModelSaleDto {

	private long shopId;

	private String modelCode;

	private java.math.BigDecimal saleQty;
	
	private java.lang.Long targetSaleQty;
	
	private java.lang.Long currentSaleQty;
	
	private java.lang.Long fourSaleQty;
	
	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public java.math.BigDecimal getSaleQty() {
		if (saleQty == null) {
			return new java.math.BigDecimal(0);
		}
		return saleQty;
	}

	public void setSaleQty(java.math.BigDecimal saleQty) {
		this.saleQty = saleQty;
	}
	
	public java.lang.Long getTargetSaleQty() {
		return targetSaleQty;
	}

	public void setTargetSaleQty(java.lang.Long targetSaleQty) {
		this.targetSaleQty = targetSaleQty;
	}

	public java.lang.Long getCurrentSaleQty() {
		return currentSaleQty;
	}

	public void setCurrentSaleQty(java.lang.Long currentSaleQty) {
		this.currentSaleQty = currentSaleQty;
	}

	public java.lang.Long getFourSaleQty() {
		return fourSaleQty;
	}

	public void setFourSaleQty(java.lang.Long fourSaleQty) {
		this.fourSaleQty = fourSaleQty;
	}

	@Override
	public String toString() {
		return "StatShopModelSaleDto [shopId=" + shopId + ", modelCode=" + modelCode + ", saleQty=" + saleQty
				+ ", targetSaleQty=" + targetSaleQty + ", currentSaleQty=" + currentSaleQty + ", fourSaleQty="
				+ fourSaleQty + "]";
	}
	
}
