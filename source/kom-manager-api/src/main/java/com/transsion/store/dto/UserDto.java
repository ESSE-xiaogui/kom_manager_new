package com.transsion.store.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer userCode;
	private String userName;
	private String empName;
	private String orgName;
	private Integer isInactive;
	private Integer inService;
	public Integer getUserCode() {
		return userCode;
	}
	public void setUserCode(Integer userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Integer getIsInactive() {
		return isInactive;
	}
	public void setIsInactive(Integer isInactive) {
		this.isInactive = isInactive;
	}
	public Integer getInService() {
		return inService;
	}
	public void setInService(Integer inService) {
		this.inService = inService;
	}
	@Override
	public String toString() {
		return "UserDto [userCode=" + userCode + ", userName=" + userName + ", empName=" + empName + ", orgName="
				+ orgName + ", isInactive=" + isInactive + ", inService=" + inService + "]";
	}

}