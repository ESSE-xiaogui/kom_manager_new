package com.transsion.store.dto;

import java.io.Serializable;

public class VisitShopInfoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.Long shopId;

	private java.lang.Long shopName;

	private java.lang.Long gradeId;

	private java.lang.Long gradeName;
	
	private java.lang.String cityName;

	/**
	  *	
	  */
	private java.lang.Long currentSaleQty;
	
	/**
	  *	
	  */
	private java.lang.Long targetSaleQty;

	public java.lang.Long getShopId() {
		return shopId;
	}

	public void setShopId(java.lang.Long shopId) {
		this.shopId = shopId;
	}

	public java.lang.Long getShopName() {
		return shopName;
	}

	public void setShopName(java.lang.Long shopName) {
		this.shopName = shopName;
	}

	public java.lang.Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(java.lang.Long gradeId) {
		this.gradeId = gradeId;
	}

	public java.lang.Long getGradeName() {
		return gradeName;
	}

	public void setGradeName(java.lang.Long gradeName) {
		this.gradeName = gradeName;
	}

	public java.lang.Long getCurrentSaleQty() {
		return currentSaleQty;
	}

	public void setCurrentSaleQty(java.lang.Long currentSaleQty) {
		this.currentSaleQty = currentSaleQty;
	}

	public java.lang.Long getTargetSaleQty() {
		return targetSaleQty;
	}

	public void setTargetSaleQty(java.lang.Long targetSaleQty) {
		this.targetSaleQty = targetSaleQty;
	}

	@Override
	public String toString() {
		return "VisitShopInfo [shopId=" + shopId + ", shopName=" + shopName + ", gradeId=" + gradeId + ", gradeName="
				+ gradeName + ", currentSaleQty=" + currentSaleQty + ", targetSaleQty=" + targetSaleQty + "]";
	}
	
	
	
}
