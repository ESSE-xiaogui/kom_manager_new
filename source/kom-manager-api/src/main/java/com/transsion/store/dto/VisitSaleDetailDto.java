package com.transsion.store.dto;

import java.io.Serializable;

public class VisitSaleDetailDto implements Serializable{
	private static final long serialVersionUID = 133612741668340606L;
	
	private String modelCode;
	private Integer saleQty;
	
	public String getModelCode() {
		return modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	public Integer getSaleQty() {
		return saleQty;
	}
	public void setSaleQty(Integer saleQty) {
		this.saleQty = saleQty;
	}
	
	@Override
	public String toString() {
		return "VisitSaleDetailDto [modelCode=" + modelCode + ", saleQty=" + saleQty + "]";
	}
	
}
