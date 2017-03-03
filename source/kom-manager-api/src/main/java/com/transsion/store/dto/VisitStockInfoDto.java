/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 10:24:48
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.dto;

import java.io.Serializable;

public class VisitStockInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	  *	seq number
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.Long visitId;

	/**
	  *	
	  */
	private java.lang.Long brandId;

	/**
	  *	
	  */
	private java.lang.Long modelId;
	
	/**
	  *	
	  */
	private java.lang.String modelCode;
	
	/**
	  *	
	  */
	private java.lang.String modelName;

	/**
	  *	
	  */
	private java.lang.Long stockQty;

	/**
	  *	
	  */
	private java.lang.Long currentSaleQty;
	
	/**
	  *	
	  */
	private java.lang.Long targetSaleQty;
	
	
	/**
	 * avg sale per four weeks
	 */
	private java.math.BigDecimal saleAvg;

	/**
	 * Inventory turn over, STOCK_QTY/SALE_AVG
	 */
	private java.math.BigDecimal stockIto;

	/**
	  *	
	  */
	private java.lang.String remark;
	
	private java.lang.Long shopId;

	private java.lang.String shopName;

	private java.lang.Long gradeId;

	private java.lang.String gradeName;
	
	private java.lang.String cityName;

	/**
	  *	
	  */
	public java.lang.Long getId() {
		return id;
	}

	/**
	  *	
	  */
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	/**
	  *	
	  */
	public java.lang.Long getVisitId() {
		return visitId;
	}

	/**
	  *	
	  */
	public void setVisitId(java.lang.Long visitId) {
		this.visitId = visitId;
	}

	/**
	  *	
	  */
	public java.lang.Long getBrandId() {
		return brandId;
	}

	/**
	  *	
	  */
	public void setBrandId(java.lang.Long brandId) {
		this.brandId = brandId;
	}

	/**
	  *	
	  */
	public java.lang.Long getModelId() {
		return modelId;
	}

	/**
	  *	
	  */
	public void setModelId(java.lang.Long modelId) {
		this.modelId = modelId;
	}
	
	public java.lang.String getModelCode() {
		return modelCode;
	}

	public void setModelCode(java.lang.String modelCode) {
		this.modelCode = modelCode;
	}

	public java.lang.String getModelName() {
		return modelName;
	}

	public void setModelName(java.lang.String modelName) {
		this.modelName = modelName;
	}

	/**
	  *	
	  */
	public java.lang.Long getStockQty() {
		return stockQty;
	}

	/**
	  *	
	  */
	public void setStockQty(java.lang.Long stockQty) {
		this.stockQty = stockQty;
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

	/**
	 * avg sale per four weeks
	 */
	public java.math.BigDecimal getSaleAvg() {
		return saleAvg;
	}

	/**
	 * avg sale per four weeks
	 */
	public void setSaleAvg(java.math.BigDecimal saleAvg) {
		this.saleAvg = saleAvg;
	}

	/**
	 * Inventory turn over, STOCK_QTY/SALE_AVG
	 */
	public java.math.BigDecimal getStockIto() {
		return stockIto;
	}

	/**
	 * Inventory turn over, STOCK_QTY/SALE_AVG
	 */
	public void setStockIto(java.math.BigDecimal stockIto) {
		this.stockIto = stockIto;
	}

	/**
	  *	
	  */
	public java.lang.String getRemark() {
		return remark;
	}

	/**
	  *	
	  */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

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

	public java.lang.String getCityName() {
		return cityName;
	}

	public void setCityName(java.lang.String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "VisitStockInfoDto [id=" + id + ", visitId=" + visitId + ", brandId=" + brandId + ", modelId=" + modelId
				+ ", modelCode=" + modelCode + ", modelName=" + modelName + ", stockQty=" + stockQty
				+ ", currentSaleQty=" + currentSaleQty + ", targetSaleQty=" + targetSaleQty + ", saleAvg=" + saleAvg
				+ ", stockIto=" + stockIto + ", remark=" + remark + ", shopId=" + shopId + ", shopName=" + shopName
				+ ", gradeId=" + gradeId + ", gradeName=" + gradeName + ", cityName=" + cityName + "]";
	}

}
