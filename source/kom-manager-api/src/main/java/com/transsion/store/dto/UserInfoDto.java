package com.transsion.store.dto;

import java.io.Serializable;

public class UserInfoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	
	private java.lang.String userCode;
	
	private java.lang.String userName;
	
	private java.lang.String password;
	
	private java.lang.Integer companyId; 
	
	private java.lang.String roleName;
	
	private java.lang.String dutyName;
	
	private java.lang.String orgName;
	
	private java.lang.String empCode;
	
	private java.lang.String empName;
	
	private java.lang.Integer gender;
	
	private java.lang.String nation;
	
	private java.lang.Integer married;
	
	private java.lang.String birthday;
	
	private java.lang.String email;
	
	private java.lang.String idNo;
	
	private java.lang.String mobileNo;
	
	private java.lang.Long upperId;
	
	private java.lang.String upperName;
	/**
	 * 是否在职 1:是 2:否
	 */
	private java.lang.Integer inService;
	
	/**
	 * 用户是否停用 1启用 2 禁用
	 */	
	private java.lang.Integer isInactive;
	
	private java.lang.String lastLogin;
	
	private java.lang.String updatedBy;
	
	private java.lang.String updatedTime;
	
	private java.lang.String remark;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getUserCode() {
		return userCode;
	}

	public void setUserCode(java.lang.String userCode) {
		this.userCode = userCode;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}

	public java.lang.String getRoleName() {
		return roleName;
	}

	public void setRoleName(java.lang.String roleName) {
		this.roleName = roleName;
	}

	public java.lang.String getDutyName() {
		return dutyName;
	}

	public void setDutyName(java.lang.String dutyName) {
		this.dutyName = dutyName;
	}

	public java.lang.String getOrgName() {
		return orgName;
	}

	public void setOrgName(java.lang.String orgName) {
		this.orgName = orgName;
	}

	public java.lang.String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(java.lang.String empCode) {
		this.empCode = empCode;
	}

	public java.lang.String getEmpName() {
		return empName;
	}

	public void setEmpName(java.lang.String empName) {
		this.empName = empName;
	}

	public java.lang.Integer getGender() {
		return gender;
	}

	public void setGender(java.lang.Integer gender) {
		this.gender = gender;
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

	public java.lang.String getBirthday() {
		return birthday;
	}

	public void setBirthday(java.lang.String birthday) {
		this.birthday = birthday;
	}

	public java.lang.String getIdNo() {
		return idNo;
	}

	public void setIdNo(java.lang.String idNo) {
		this.idNo = idNo;
	}

	public java.lang.String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(java.lang.String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public java.lang.Long getUpperId() {
		return upperId;
	}

	public void setUpperCode(java.lang.Long upperId) {
		this.upperId = upperId;
	}

	public java.lang.String getUpperName() {
		return upperName;
	}

	public void setUpperName(java.lang.String upperName) {
		this.upperName = upperName;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.Integer getInService() {
		return inService;
	}

	public void setInService(java.lang.Integer inService) {
		this.inService = inService;
	}

	public java.lang.Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(java.lang.Integer isInactive) {
		this.isInactive = isInactive;
	}

	public java.lang.String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(java.lang.String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public java.lang.String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(java.lang.String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public java.lang.String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(java.lang.String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "UserInfoDto [id=" + id + ", userCode=" + userCode + ", userName=" + userName + ", password=" + password
						+ ", companyId=" + companyId + ", roleName=" + roleName + ", dutyName=" + dutyName
						+ ", orgName=" + orgName + ", empCode=" + empCode + ", empName=" + empName + ", gender="
						+ gender + ", nation=" + nation + ", married=" + married + ", birthday=" + birthday + ", email="
						+ email + ", idNo=" + idNo + ", mobileNo=" + mobileNo + ", upperId=" + upperId
						+ ", upperName=" + upperName + ", inService=" + inService + ", isInactive=" + isInactive
						+ ", lastLogin=" + lastLogin + ", updatedBy=" + updatedBy + ", updatedTime=" + updatedTime
						+ ", remark=" + remark + "]";
	}
	
	
}
