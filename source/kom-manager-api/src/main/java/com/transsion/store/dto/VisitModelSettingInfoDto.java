package com.transsion.store.dto;

import java.io.Serializable;

public class VisitModelSettingInfoDto implements Serializable {
	private static final long serialVersionUID = -4726062650137965322L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.String actionDate;

	/**
	  *	
	  */
	private java.lang.Long brandId;

	/**
	  *	
	  */
	private java.lang.Long modelId;
	
	private java.lang.String brandCode;
	
	private java.lang.String modelCode;


	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	
	  */
	private java.lang.String createBy;

	/**
	  *	
	  */
	private java.lang.String createTime;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getActionDate() {
		return actionDate;
	}

	public void setActionDate(java.lang.String actionDate) {
		this.actionDate = actionDate;
	}

	public java.lang.Long getBrandId() {
		return brandId;
	}

	public void setBrandId(java.lang.Long brandId) {
		this.brandId = brandId;
	}

	public java.lang.Long getModelId() {
		return modelId;
	}

	public void setModelId(java.lang.Long modelId) {
		this.modelId = modelId;
	}

	public java.lang.String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(java.lang.String brandCode) {
		this.brandCode = brandCode;
	}

	public java.lang.String getModelCode() {
		return modelCode;
	}

	public void setModelCode(java.lang.String modelCode) {
		this.modelCode = modelCode;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	public java.lang.String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.lang.String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "VisitModelSettingInfoDto [id=" + id + ", actionDate=" + actionDate + ", brandId=" + brandId
				+ ", modelId=" + modelId + ", brandCode=" + brandCode + ", modelCode=" + modelCode + ", remark="
				+ remark + ", createBy=" + createBy + ", createTime=" + createTime + "]";
	}

}
