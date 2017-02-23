package com.transsion.store.dto;

import com.shangkang.core.bo.Model;

public class EmpInfoDto extends Model{
	
	private static final long	serialVersionUID	= 1L;
	
	private Long id;

	private String empName;
	
	private String userName;

	private Integer companyId;
	
	private Integer regionId;
	
	private String countryName;

	private String orgName;

	private String dutyName;

	private String idNo;
	
	private Long upperId;

	private String upperName;

	private Integer gender;

	private String birthday;

	private String nation;

	private Integer married;

	private String mobileNo;

	private String email;

	private String nativePlace;

	private String zipCode;

	private Integer inService;

	private String remark;

	private String createdBy;

	private String createdTime;

	private String updatedBy;

	private String updatedTime;

	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getInService() {
		return inService;
	}

	public void setInService(Integer inService) {
		this.inService = inService;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "EmpInfoDto [id=" + id + ", empName=" + empName + ", userName=" + userName + ", companyId=" + companyId
						+ ", regionId=" + regionId + ", countryName=" + countryName + ", orgName=" + orgName
						+ ", dutyName=" + dutyName + ", idNo=" + idNo + ", upperId=" + upperId + ", upperName="
						+ upperName + ", gender=" + gender + ", birthday=" + birthday + ", nation=" + nation
						+ ", married=" + married + ", mobileNo=" + mobileNo + ", email=" + email + ", nativePlace="
						+ nativePlace + ", zipCode=" + zipCode + ", inService=" + inService + ", remark=" + remark
						+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", updatedBy=" + updatedBy
						+ ", updatedTime=" + updatedTime + ", version=" + version + "]";
	}

}
