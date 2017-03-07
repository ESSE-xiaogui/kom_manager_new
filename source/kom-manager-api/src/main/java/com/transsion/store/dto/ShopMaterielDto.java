package com.transsion.store.dto;

import java.io.Serializable;

public class ShopMaterielDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.Long shopId;
	
	private java.lang.String shopCode;

	/**
	  *	
	  */
	private java.lang.Long materielId;

	/**
	  *	
	  */
	private java.lang.Integer materielQty;
	
	private java.lang.Integer regionId;
	
	private java.lang.Long regionType;
	
	private java.lang.String countryName;
	
	private java.lang.String cityName;
	
	private java.lang.String createDateStart;
	
	private java.lang.String createDateEnd;
	
	private java.lang.String updateDateStart;
	
	private java.lang.String updateDateEnd;
	
	private java.lang.String shopName;
	
	private java.lang.Integer companyId;
	
	private java.lang.String companyCode;
	
	private java.lang.String nameEN;
	
	private java.lang.String nameCN;
	
	private java.lang.String type;
	

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
	private java.lang.String createDate;

	/**
	  *	
	  */
	private java.lang.String updateBy;

	/**
	  *	
	  */
	private java.lang.String updateDate;

	/**
	  *	
	  */
	private java.lang.Integer version;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getShopId() {
		return shopId;
	}

	public void setShopId(java.lang.Long shopId) {
		this.shopId = shopId;
	}

	public java.lang.Long getMaterielId() {
		return materielId;
	}

	public void setMaterielId(java.lang.Long materielId) {
		this.materielId = materielId;
	}

	public java.lang.Integer getMaterielQty() {
		return materielQty;
	}

	public void setMaterielQty(java.lang.Integer materielQty) {
		this.materielQty = materielQty;
	}

	public java.lang.Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(java.lang.Integer regionId) {
		this.regionId = regionId;
	}

	public java.lang.String getCountryName() {
		return countryName;
	}

	public void setCountryName(java.lang.String countryName) {
		this.countryName = countryName;
	}

	public java.lang.String getCityName() {
		return cityName;
	}

	public void setCityName(java.lang.String cityName) {
		this.cityName = cityName;
	}

	public java.lang.String getCreateDateStart() {
		return createDateStart;
	}

	public void setCreateDateStart(java.lang.String createDateStart) {
		this.createDateStart = createDateStart;
	}

	public java.lang.String getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(java.lang.String createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public java.lang.String getUpdateDateStart() {
		return updateDateStart;
	}

	public void setUpdateDateStart(java.lang.String updateDateStart) {
		this.updateDateStart = updateDateStart;
	}

	public java.lang.String getUpdateDateEnd() {
		return updateDateEnd;
	}

	public void setUpdateDateEnd(java.lang.String updateDateEnd) {
		this.updateDateEnd = updateDateEnd;
	}

	public java.lang.String getShopName() {
		return shopName;
	}

	public void setShopName(java.lang.String shopName) {
		this.shopName = shopName;
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

	public java.lang.String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.lang.String createDate) {
		this.createDate = createDate;
	}

	public java.lang.String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}

	public java.lang.String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.lang.String updateDate) {
		this.updateDate = updateDate;
	}

	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}
	
	public java.lang.Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}

	public java.lang.String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(java.lang.String companyCode) {
		this.companyCode = companyCode;
	}

	public java.lang.String getNameEN() {
		return nameEN;
	}

	public void setNameEN(java.lang.String nameEN) {
		this.nameEN = nameEN;
	}

	public java.lang.String getNameCN() {
		return nameCN;
	}

	public void setNameCN(java.lang.String nameCN) {
		this.nameCN = nameCN;
	}

	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}

	public java.lang.String getShopCode() {
		return shopCode;
	}

	public void setShopCode(java.lang.String shopCode) {
		this.shopCode = shopCode;
	}

	public java.lang.Long getRegionType() {
		return regionType;
	}

	public void setRegionType(java.lang.Long regionType) {
		this.regionType = regionType;
	}

	@Override
	public String toString() {
		return "ShopMaterielDto [id=" + id + ", shopId=" + shopId + ", shopCode=" + shopCode + ", materielId="
						+ materielId + ", materielQty=" + materielQty + ", regionId=" + regionId + ", regionType="
						+ regionType + ", countryName=" + countryName + ", cityName=" + cityName + ", createDateStart="
						+ createDateStart + ", createDateEnd=" + createDateEnd + ", updateDateStart=" + updateDateStart
						+ ", updateDateEnd=" + updateDateEnd + ", shopName=" + shopName + ", companyId=" + companyId
						+ ", companyCode=" + companyCode + ", nameEN=" + nameEN + ", nameCN=" + nameCN + ", type="
						+ type + ", remark=" + remark + ", createBy=" + createBy + ", createDate=" + createDate
						+ ", updateBy=" + updateBy + ", updateDate=" + updateDate + ", version=" + version + "]";
	}


}
