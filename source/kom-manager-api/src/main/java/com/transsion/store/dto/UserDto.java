package com.transsion.store.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userCode;
	private String password;
	private String empName;
	private String empCode;
	private String orgName;
	/**
	 * 1表示激活状态，被激活有效的数据可以用于新增业务，2表示停用，被停用无效的数据只能用于历史数据查询中
	 */
	private Integer isInactive;
	private Integer inService;
	
	
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userCode=" + userCode + ", password=" + password + ", empName=" + empName
						+ ", empCode=" + empCode + ", orgName=" + orgName + ", isInactive=" + isInactive
						+ ", inService=" + inService + "]";
	}
	
	 
}
