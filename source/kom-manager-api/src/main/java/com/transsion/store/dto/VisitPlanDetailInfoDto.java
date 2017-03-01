package com.transsion.store.dto;

import java.io.Serializable;

public class VisitPlanDetailInfoDto implements Serializable{

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
	private java.lang.String planDate;
	
	private java.lang.String planDateStart;
	
	private java.lang.String planDateEnd;
	
	private java.lang.Integer weekNo;

	/**
	  *	
	  */
	private java.lang.String visitDate;

	/**
	  *	
	  */
	private java.lang.Long companyId;
	
	private java.lang.String companyCode;

	/**
	  *	
	  */
	private java.lang.Long shopId;
	
	private java.lang.String shopName;
	
	private java.lang.String gradeName;
	
	private java.lang.Long gradeId;
	
	private java.lang.String bizName;
	
	private java.lang.Long bizId;
	
	private java.lang.Long regionId;
	
	private java.lang.String countryName;
	
	private java.lang.String cityName;
	
	private java.lang.String empName;

	/**
	  *	1,undo; 2,done
	  */
	private java.lang.Integer status;

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
	
	private java.lang.String createTimeStart;
	
	private java.lang.String createTimeEnd;

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

	public java.lang.String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(java.lang.String planDate) {
		this.planDate = planDate;
	}

	public java.lang.String getPlanDateStart() {
		return planDateStart;
	}

	public void setPlanDateStart(java.lang.String planDateStart) {
		this.planDateStart = planDateStart;
	}

	public java.lang.String getPlanDateEnd() {
		return planDateEnd;
	}

	public void setPlanDateEnd(java.lang.String planDateEnd) {
		this.planDateEnd = planDateEnd;
	}

	public java.lang.Integer getWeekNo() {
		return weekNo;
	}

	public void setWeekNo(java.lang.Integer weekNo) {
		this.weekNo = weekNo;
	}

	public java.lang.String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(java.lang.String visitDate) {
		this.visitDate = visitDate;
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

	public java.lang.String getGradeName() {
		return gradeName;
	}

	public void setGradeName(java.lang.String gradeName) {
		this.gradeName = gradeName;
	}

	public java.lang.Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(java.lang.Long gradeId) {
		this.gradeId = gradeId;
	}

	public java.lang.String getBizName() {
		return bizName;
	}

	public void setBizName(java.lang.String bizName) {
		this.bizName = bizName;
	}

	public java.lang.Long getBizId() {
		return bizId;
	}

	public void setBizId(java.lang.Long bizId) {
		this.bizId = bizId;
	}

	public java.lang.Long getRegionId() {
		return regionId;
	}

	public void setRegionId(java.lang.Long regionId) {
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

	public java.lang.String getEmpName() {
		return empName;
	}

	public void setEmpName(java.lang.String empName) {
		this.empName = empName;
	}

	public java.lang.Integer getStatus() {
		return status;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "VisitPlanDetailInfoDto [id=" + id + ", planDate=" + planDate + ", planDateStart=" + planDateStart
						+ ", planDateEnd=" + planDateEnd + ", weekNo=" + weekNo + ", visitDate=" + visitDate
						+ ", companyId=" + companyId + ", companyCode=" + companyCode + ", shopId=" + shopId
						+ ", shopName=" + shopName + ", gradeName=" + gradeName + ", gradeId=" + gradeId + ", bizName="
						+ bizName + ", bizId=" + bizId + ", regionId=" + regionId + ", countryName=" + countryName
						+ ", cityName=" + cityName + ", empName=" + empName + ", status=" + status + ", remark="
						+ remark + ", createBy=" + createBy + ", createTime=" + createTime + ", createTimeStart="
						+ createTimeStart + ", createTimeEnd=" + createTimeEnd + ", updateBy=" + updateBy
						+ ", updateTime=" + updateTime + ", version=" + version + "]";
	}

	/**
	  *	
	  */
	

}
