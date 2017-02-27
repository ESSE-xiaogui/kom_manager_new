package com.transsion.store.dto;

import java.io.Serializable;

public class VisitModelInfoDto  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	  *	
	  */
	private java.lang.Long modelId;

	
	private java.lang.String modelCode;
	
	
	private java.lang.String modelName;

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


	public java.lang.Long getModelId() {
		return modelId;
	}


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


	public java.math.BigDecimal getSaleAvg() {
		return saleAvg;
	}


	public void setSaleAvg(java.math.BigDecimal saleAvg) {
		this.saleAvg = saleAvg;
	}


	@Override
	public String toString() {
		return "VisitModelInfoDto [modelId=" + modelId + ", modelCode=" + modelCode + ", modelName=" + modelName
				+ ", currentSaleQty=" + currentSaleQty + ", targetSaleQty=" + targetSaleQty + ", saleAvg=" + saleAvg
				+ "]";
	}
	
}
