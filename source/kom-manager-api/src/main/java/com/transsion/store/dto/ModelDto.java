package com.transsion.store.dto;

import java.io.Serializable;

public class ModelDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String brandCode;
	
	private String seriesCode;
	
	/**
	  *	机型代码
	  */
	private String modelCode;

	/**
	  *	
	  */
	private String modelName;
	
	/**
	 * 上市时间
	 * */
	private String saleTime;
	
	/**
	 * 价格档位 注：枚举
	 * */
	private Integer priceScale;
	
	/**
	  *	
	  */
	private Integer isSelf;
	
	/**
	  *	1表示激活状态，被激活有效的数据可以用于新增业务，2表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	private java.lang.Integer isInactive;

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getSeriesCode() {
		return seriesCode;
	}

	public void setSeriesCode(String seriesCode) {
		this.seriesCode = seriesCode;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(String saleTime) {
		this.saleTime = saleTime;
	}

	public Integer getPriceScale() {
		return priceScale;
	}

	public void setPriceScale(Integer priceScale) {
		this.priceScale = priceScale;
	}

	public Integer getIsSelf() {
		return isSelf;
	}

	public void setIsSelf(Integer isSelf) {
		this.isSelf = isSelf;
	}

	public java.lang.Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(java.lang.Integer isInactive) {
		this.isInactive = isInactive;
	}

	@Override
	public String toString() {
		return "ModelDto [brandCode=" + brandCode + ", seriesCode=" + seriesCode + ", modelCode=" + modelCode
				+ ", modelName=" + modelName + ", saleTime=" + saleTime + ", priceScale=" + priceScale + ", isSelf="
				+ isSelf + ", isInactive=" + isInactive + "]";
	}

}
