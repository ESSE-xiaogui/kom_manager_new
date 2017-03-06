package com.transsion.store.dto;

import java.io.Serializable;

public class VisitModelSettingInfoDto implements Serializable {
	private static final long serialVersionUID = -4726062650137965322L;
	
	/**
	  *	
	  */
	private Long id;

	/**
	  *	
	  */
	private String actionDate;
	
	private Long companyId;
	
	private String companyCode;

	/**
	  *	
	  */
	private Long brandId;
	
	private Long regionId;

	/**
	  *	
	  */
	private Long modelId;
	
	private String brandCode;
	
	private String modelName;
	
	private String countryName;


	/**
	  *	
	  */
	private String remark;

	/**
	  *	
	  */
	private String createBy;

	/**
	  *	
	  */
	private String createTime;
	
	private String updateBy;
	
	private String updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionDate() {
		return actionDate;
	}

	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	@Override
	public String toString() {
		return "VisitModelSettingInfoDto [id=" + id + ", actionDate=" + actionDate + ", companyId=" + companyId
						+ ", companyCode=" + companyCode + ", brandId=" + brandId + ", regionId=" + regionId
						+ ", modelId=" + modelId + ", brandCode=" + brandCode + ", modelName=" + modelName
						+ ", countryName=" + countryName + ", remark=" + remark + ", createBy=" + createBy
						+ ", createTime=" + createTime + ", updateBy=" + updateBy + ", updateTime=" + updateTime + "]";
	}

}
