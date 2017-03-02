package com.transsion.store.dto;

import java.io.Serializable;

public class VisitScoreDetailInfoDto implements Serializable{

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
	private java.lang.Long visitId;
	
	private java.lang.Long companyId;
	
	private java.lang.String companyCode;
	
	private java.lang.String countryName;
	
	private java.lang.String cityName;
	
	private java.lang.String shopCode;
	
	private java.lang.String shopName;
	
	private java.lang.String empName;
	
	private java.lang.Long regionId;
	
	private java.lang.String createTimeStart;
	
	private java.lang.String createTimeEnd;

	private java.math.BigDecimal totalScoreStart;
	
	private java.math.BigDecimal totalScoreEnd;
	/**
	  *	
	  */
	private java.math.BigDecimal shopScore;

	/**
	  *	
	  */
	private java.math.BigDecimal saleScore;

	/**
	  *	
	  */
	private java.math.BigDecimal staffScore;

	/**
	  *	
	  */
	private java.math.BigDecimal totalScore;

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

	public java.lang.Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Long companyId) {
		this.companyId = companyId;
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

	public java.math.BigDecimal getShopScore() {
		return shopScore;
	}

	public void setShopScore(java.math.BigDecimal shopScore) {
		this.shopScore = shopScore;
	}

	public java.math.BigDecimal getSaleScore() {
		return saleScore;
	}

	public void setSaleScore(java.math.BigDecimal saleScore) {
		this.saleScore = saleScore;
	}

	public java.math.BigDecimal getStaffScore() {
		return staffScore;
	}

	public void setStaffScore(java.math.BigDecimal staffScore) {
		this.staffScore = staffScore;
	}

	public java.math.BigDecimal getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(java.math.BigDecimal totalScore) {
		this.totalScore = totalScore;
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

	public java.lang.Long getRegionId() {
		return regionId;
	}

	public void setRegionId(java.lang.Long regionId) {
		this.regionId = regionId;
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

	public java.math.BigDecimal getTotalScoreStart() {
		return totalScoreStart;
	}

	public void setTotalScoreStart(java.math.BigDecimal totalScoreStart) {
		this.totalScoreStart = totalScoreStart;
	}

	public java.math.BigDecimal getTotalScoreEnd() {
		return totalScoreEnd;
	}

	public void setTotalScoreEnd(java.math.BigDecimal totalScoreEnd) {
		this.totalScoreEnd = totalScoreEnd;
	}

	@Override
	public String toString() {
		return "VisitScoreDetailInfoDto [id=" + id + ", visitId=" + visitId + ", companyId=" + companyId
						+ ", companyCode=" + companyCode + ", countryName=" + countryName + ", cityName=" + cityName
						+ ", shopCode=" + shopCode + ", shopName=" + shopName + ", empName=" + empName + ", regionId="
						+ regionId + ", createTimeStart=" + createTimeStart + ", createTimeEnd=" + createTimeEnd
						+ ", totalScoreStart=" + totalScoreStart + ", totalScoreEnd=" + totalScoreEnd + ", shopScore="
						+ shopScore + ", saleScore=" + saleScore + ", staffScore=" + staffScore + ", totalScore="
						+ totalScore + ", remark=" + remark + ", createBy=" + createBy + ", createTime=" + createTime
						+ ", updateBy=" + updateBy + ", updateTime=" + updateTime + ", version=" + version + "]";
	}

}
