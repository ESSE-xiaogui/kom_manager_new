package com.transsion.store.dto;

import java.io.Serializable;

public class VisitCompetitorInfoDto implements Serializable {
	private static final long serialVersionUID = -226258342069341495L;
	
	private String brandName;
	private Integer saleQty;
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getSaleQty() {
		return saleQty;
	}
	public void setSaleQty(Integer saleQty) {
		this.saleQty = saleQty;
	}
	
	@Override
	public String toString() {
		return "VisitCompetitor [brandName=" + brandName + ", saleQty=" + saleQty + "]";
	}
	
}
