package com.transsion.store.dto;

import java.io.Serializable;

public class VisitFeedBackInfoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.Long visitId;

	/**
	  *	
	  */
	private java.lang.String issue;

	/**
	  *	
	  */
	private java.lang.String action;

	/**
	  *	
	  */
	private java.lang.String imgFirstUrl;

	/**
	  *	
	  */
	private java.lang.String imgSecondUrl;

	/**
	  *	
	  */
	private java.lang.String imgThirdUrl;
	
	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	
	  */
	private java.lang.String updateBy;

	/**
	  *	
	  */
	private java.lang.String updateTime;

	/**
	  *	
	  */
	private java.lang.Integer version;

	/**
	  *	
	  */
	private java.lang.String companyCode;
	
	private java.lang.String countryName;
	
	private java.lang.String cityName;
	
	private java.lang.String shopCode;
	
	private java.lang.String shopName;
	
	private java.lang.String empName;
	
	private java.lang.String createBy;
	
	private java.lang.String createTime;
	
	private java.lang.String createTimeStart;
	
	private java.lang.String createTimeEnd;
	
	private java.lang.Long regionId;
	
	private java.lang.String visitNo;
	
	private java.lang.Integer companyId;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getVisitId() {
		return visitId;
	}

	public void setVisitId(java.lang.Long visitId) {
		this.visitId = visitId;
	}

	public java.lang.String getIssue() {
		return issue;
	}

	public void setIssue(java.lang.String issue) {
		this.issue = issue;
	}

	public java.lang.String getAction() {
		return action;
	}

	public void setAction(java.lang.String action) {
		this.action = action;
	}

	public java.lang.String getImgFirstUrl() {
		return imgFirstUrl;
	}

	public void setImgFirstUrl(java.lang.String imgFirstUrl) {
		this.imgFirstUrl = imgFirstUrl;
	}

	public java.lang.String getImgSecondUrl() {
		return imgSecondUrl;
	}

	public void setImgSecondUrl(java.lang.String imgSecondUrl) {
		this.imgSecondUrl = imgSecondUrl;
	}

	public java.lang.String getImgThirdUrl() {
		return imgThirdUrl;
	}

	public void setImgThirdUrl(java.lang.String imgThirdUrl) {
		this.imgThirdUrl = imgThirdUrl;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}

	public java.lang.String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.lang.String updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}

	public java.lang.String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(java.lang.String companyCode) {
		this.companyCode = companyCode;
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

	public java.lang.String getShopCode() {
		return shopCode;
	}

	public void setShopCode(java.lang.String shopCode) {
		this.shopCode = shopCode;
	}

	public java.lang.String getShopName() {
		return shopName;
	}

	public void setShopName(java.lang.String shopName) {
		this.shopName = shopName;
	}

	public java.lang.String getEmpName() {
		return empName;
	}

	public void setEmpName(java.lang.String empName) {
		this.empName = empName;
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

	public java.lang.String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(java.lang.String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public java.lang.String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(java.lang.String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public java.lang.Long getRegionId() {
		return regionId;
	}

	public void setRegionId(java.lang.Long regionId) {
		this.regionId = regionId;
	}

	public java.lang.String getVisitNo() {
		return visitNo;
	}

	public void setVisitNo(java.lang.String visitNo) {
		this.visitNo = visitNo;
	}

	public java.lang.Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "VisitFeedBackInfoDto [id=" + id + ", visitId=" + visitId + ", issue=" + issue + ", action=" + action
						+ ", imgFirstUrl=" + imgFirstUrl + ", imgSecondUrl=" + imgSecondUrl + ", imgThirdUrl="
						+ imgThirdUrl + ", remark=" + remark + ", updateBy=" + updateBy + ", updateTime=" + updateTime
						+ ", version=" + version + ", companyCode=" + companyCode + ", countryName=" + countryName
						+ ", cityName=" + cityName + ", shopCode=" + shopCode + ", shopName=" + shopName + ", empName="
						+ empName + ", createBy=" + createBy + ", createTime=" + createTime + ", createTimeStart="
						+ createTimeStart + ", createTimeEnd=" + createTimeEnd + ", regionId=" + regionId + ", visitNo="
						+ visitNo + ", companyId=" + companyId + "]";
	}

}
