package com.transsion.store.dto;

import java.io.Serializable;

public class VisitShopInfoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.Long shopId;

	private java.lang.String shopName;

	private java.lang.Long gradeId;

	private java.lang.String gradeName;
	
	private java.lang.String cityName;

	/**
	  *	
	  */
	private java.lang.Long currentSaleQty;
	
	/**
	  *	
	  */
	private java.lang.Long targetSaleQty;
	
	private java.lang.String planDate;

	public java.lang.Long getShopId() {
		return shopId;
	}

	public void setShopId(java.lang.Long shopId) {
		this.shopId = shopId;
	}

	public java.lang.String getShopName() {
		return shopName;
	}

	public void setShopName(java.lang.String shopName) {
		this.shopName = shopName;
	}

	public java.lang.Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(java.lang.Long gradeId) {
		this.gradeId = gradeId;
	}

	public java.lang.String getGradeName() {
		return gradeName;
	}

	public void setGradeName(java.lang.String gradeName) {
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
	
	public java.lang.String getCityName() {
		return cityName;
	}

	public void setCityName(java.lang.String cityName) {
		this.cityName = cityName;
	}
	
	public java.lang.String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(java.lang.String planDate) {
		this.planDate = planDate;
	}

	@Override
	public String toString() {
		return "VisitShopInfoDto [shopId=" + shopId + ", shopName=" + shopName + ", gradeId=" + gradeId + ", gradeName="
				+ gradeName + ", cityName=" + cityName + ", currentSaleQty=" + currentSaleQty + ", targetSaleQty="
				+ targetSaleQty + ", planDate=" + planDate + "]";
	}

}
