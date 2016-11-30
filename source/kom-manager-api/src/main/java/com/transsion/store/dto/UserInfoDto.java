package com.transsion.store.dto;

public class UserInfoDto {
	
	private java.lang.Long id;
	
	private java.lang.String userName;
	
	private java.lang.Long orgId;
	
	private java.lang.String password;
	
	private java.lang.Integer companyId; 
	
	private java.lang.String roleName;
	
	private java.lang.String dutyName;
	
	private java.lang.String orgName;
	
	private java.lang.String empCode;
	
	private java.lang.String empName;
	
	private java.lang.String idNo;
	
	private java.lang.String phoneNo;
	
	private java.lang.Integer upperId;
	
	private java.lang.String upperName;
	
	private java.lang.Integer inService;
	
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

	public java.lang.String getIdNo() {
		return idNo;
	}

	public void setIdNo(java.lang.String idNo) {
		this.idNo = idNo;
	}

	public java.lang.String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(java.lang.String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public java.lang.Integer getUpperId() {
		return upperId;
	}

	public void setUpperId(java.lang.Integer upperId) {
		this.upperId = upperId;
	}

	public java.lang.String getUpperName() {
		return upperName;
	}

	public void setUpperName(java.lang.String upperName) {
		this.upperName = upperName;
	}

	public java.lang.Integer getInService() {
		return inService;
	}

	public void setInService(java.lang.Integer inService) {
		this.inService = inService;
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
	
	

	public java.lang.Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}
	
	

	public java.lang.Long getOrgId() {
		return orgId;
	}

	public void setOrgId(java.lang.Long orgId) {
		this.orgId = orgId;
	}

	public java.lang.Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(java.lang.Integer isInactive) {
		this.isInactive = isInactive;
	}

	@Override
	public String toString() {
		return "UserInfoDto [id=" + id + ", userName=" + userName + ", orgId=" + orgId + ", password=" + password
				+ ", companyId=" + companyId + ", roleName=" + roleName + ", dutyName=" + dutyName + ", orgName="
				+ orgName + ", empCode=" + empCode + ", empName=" + empName + ", idNo=" + idNo + ", phoneNo=" + phoneNo
				+ ", upperId=" + upperId + ", upperName=" + upperName + ", inService=" + inService + ", isInactive="
				+ isInactive + ", lastLogin=" + lastLogin + ", updatedBy=" + updatedBy + ", updatedTime=" + updatedTime
				+ ", remark=" + remark + "]";
	}

}
