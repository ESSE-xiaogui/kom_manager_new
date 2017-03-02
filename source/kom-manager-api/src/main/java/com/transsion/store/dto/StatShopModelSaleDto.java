package com.transsion.store.dto;

public class StatShopModelSaleDto {

	private long shopId;

	private String modelCode;

	private java.math.BigDecimal saleQty;

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

	@Override
	public String toString() {
		return "StatShopModelSaleDto [shopId=" + shopId + ", modelCode=" + modelCode + ", saleQty=" + saleQty + "]";
	}

}
