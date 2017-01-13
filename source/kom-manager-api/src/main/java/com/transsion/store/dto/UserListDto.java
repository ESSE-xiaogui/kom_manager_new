package com.transsion.store.dto;

import java.io.Serializable;

public class UserListDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userCode;
	private String roleName;
	private String empCode;
	private String empName;
	private String password;
	private String dutyName;
	private Integer gender;
	private String nation;
	private Integer married;
	private String idNo;
	private String birthday;
	private String email;
	private Integer companyId;
	private String lastLogin;
	private String orgName;
	private String mobileNo;
	private Long upperId;
	private String upperName;
	private Integer inService;
	private Integer isInactive;
	private String remark;
	private String createdBy;
	private String createdTime;
	private String updatedBy;
	private String updatedTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDutyName() {
		return dutyName;
	}
	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Integer getMarried() {
		return married;
	}
	public void setMarried(Integer married) {
		this.married = married;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Long getUpperId() {
		return upperId;
	}
	public void setUpperId(Long upperId) {
		this.upperId = upperId;
	}
	public String getUpperName() {
		return upperName;
	}
	public void setUpperName(String upperName) {
		this.upperName = upperName;
	}
	public Integer getInService() {
		return inService;
	}
	public void setInService(Integer inService) {
		this.inService = inService;
	}
	public Integer getIsInactive() {
		return isInactive;
	}
	public void setIsInactive(Integer isInactive) {
		this.isInactive = isInactive;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	@Override
	public String toString() {
		return "UserListDto [id=" + id + ", userCode=" + userCode + ", roleName=" + roleName + ", empCode=" + empCode
						+ ", empName=" + empName + ", password=" + password + ", dutyName=" + dutyName + ", gender="
						+ gender + ", nation=" + nation + ", married=" + married + ", idNo=" + idNo + ", birthday="
						+ birthday + ", email=" + email + ", companyId=" + companyId + ", lastLogin=" + lastLogin
						+ ", orgName=" + orgName + ", mobileNo=" + mobileNo + ", upperId=" + upperId + ", upperName="
						+ upperName + ", inService=" + inService + ", isInactive=" + isInactive + ", remark=" + remark
						+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", updatedBy=" + updatedBy
						+ ", updatedTime=" + updatedTime + "]";
	}
	
}
