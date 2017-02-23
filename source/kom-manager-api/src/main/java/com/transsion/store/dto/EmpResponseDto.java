package com.transsion.store.dto;

import java.io.Serializable;

public class EmpResponseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 状态 注：1： 成功 2：失败 
	 * */
	private Integer status;
	
	/**
	 * 员工姓名
	 * */
	/**
	  *	
	  */
	private java.lang.Long id;
	
	private Integer regionId;
	
	/**
	  *	
	  */
	private java.lang.Long uId;

	/**
	  *	keep for align with kom pc 
	  */
	private java.lang.Integer empId;

	/**
	  *	
	  */
	private java.lang.String empCode;

	/**
	  *	
	  */
	private java.lang.String empName;

	/**
	  *	
	  */
	private java.lang.String idNo;

	/**
	  *	
	  */
	private java.lang.Integer companyId;

	/**
	  *	
	  */
	private java.lang.Integer orgId;
	
	private String orgName;

	/**
	  *	
	  */
	private java.lang.Integer dutyId;
	
	private java.lang.String dutyName;

	/**
	  *	
	  */
	private java.lang.Long upperId;

	/**
	  *	
	  */
	private java.lang.String upperName;

	/**
	  *	
	  */
	private java.lang.Integer gender;

	/**
	  *	
	  */
	private java.lang.String birthday;

	/**
	  *	
	  */
	private java.lang.String nation;

	/**
	  *	
	  */
	private java.lang.Integer married;

	/**
	  *	
	  */
	private java.lang.String phoneNo;

	/**
	  *	
	  */
	private java.lang.String mobileNo;

	/**
	  *	
	  */
	private java.lang.String email;

	/**
	  *	
	  */
	private java.lang.String nativePlace;

	/**
	  *	
	  */
	private java.lang.String zipCode;

	/**
	  *	
	  */
	private java.lang.Integer inService;

	/**
	  *	
	  */
	private java.lang.String remark;
	
	private java.lang.Integer version;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getuId() {
		return uId;
	}

	public void setuId(java.lang.Long uId) {
		this.uId = uId;
	}

	public java.lang.Integer getEmpId() {
		return empId;
	}

	public void setEmpId(java.lang.Integer empId) {
		this.empId = empId;
	}

	public java.lang.String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(java.lang.String empCode) {
		this.empCode = empCode;
	}

	public java.lang.String getIdNo() {
		return idNo;
	}

	public void setIdNo(java.lang.String idNo) {
		this.idNo = idNo;
	}

	public java.lang.Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}

	public java.lang.Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(java.lang.Integer orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public java.lang.Integer getDutyId() {
		return dutyId;
	}

	public void setDutyId(java.lang.Integer dutyId) {
		this.dutyId = dutyId;
	}

	public java.lang.String getDutyName() {
		return dutyName;
	}

	public void setDutyName(java.lang.String dutyName) {
		this.dutyName = dutyName;
	}

	public java.lang.Long getUpperId() {
		return upperId;
	}

	public void setUpperId(java.lang.Long upperId) {
		this.upperId = upperId;
	}

	public java.lang.String getUpperName() {
		return upperName;
	}

	public void setUpperName(java.lang.String upperName) {
		this.upperName = upperName;
	}

	public java.lang.Integer getGender() {
		return gender;
	}

	public void setGender(java.lang.Integer gender) {
		this.gender = gender;
	}

	public java.lang.String getBirthday() {
		return birthday;
	}

	public void setBirthday(java.lang.String birthday) {
		this.birthday = birthday;
	}

	public java.lang.String getNation() {
		return nation;
	}

	public void setNation(java.lang.String nation) {
		this.nation = nation;
	}

	public java.lang.Integer getMarried() {
		return married;
	}

	public void setMarried(java.lang.Integer married) {
		this.married = married;
	}

	public java.lang.String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(java.lang.String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public java.lang.String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(java.lang.String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(java.lang.String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public java.lang.String getZipCode() {
		return zipCode;
	}

	public void setZipCode(java.lang.String zipCode) {
		this.zipCode = zipCode;
	}

	public java.lang.Integer getInService() {
		return inService;
	}

	public void setInService(java.lang.Integer inService) {
		this.inService = inService;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "EmpResponseDto [status=" + status + ", id=" + id + ", regionId=" + regionId + ", uId=" + uId
						+ ", empId=" + empId + ", empCode=" + empCode + ", empName=" + empName + ", idNo=" + idNo
						+ ", companyId=" + companyId + ", orgId=" + orgId + ", orgName=" + orgName + ", dutyId="
						+ dutyId + ", dutyName=" + dutyName + ", upperId=" + upperId + ", upperName=" + upperName
						+ ", gender=" + gender + ", birthday=" + birthday + ", nation=" + nation + ", married="
						+ married + ", phoneNo=" + phoneNo + ", mobileNo=" + mobileNo + ", email=" + email
						+ ", nativePlace=" + nativePlace + ", zipCode=" + zipCode + ", inService=" + inService
						+ ", remark=" + remark + ", version=" + version + "]";
	}
	
}
