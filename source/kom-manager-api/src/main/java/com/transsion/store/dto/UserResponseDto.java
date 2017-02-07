package com.transsion.store.dto;

import java.io.Serializable;

public class UserResponseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 状态 注：1： 成功 2：失败
	 * */
	private Integer status;
	
	/***/
	private Long id;
	
	private Integer userId;
	
	private Long companyId;
	
	/**
	 * 用户名称
	 * */
	private String userName;
	
	/***/
	private String userCode;
	
	private String password;
	
	private Long isInactive;
	
	private String lastLogin;
	
	private String dutyName;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(Long isInactive) {
		this.isInactive = isInactive;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	@Override
	public String toString() {
		return "UserResponseDto [status=" + status + ", id=" + id + ", userId=" + userId + ", companyId=" + companyId
						+ ", userName=" + userName + ", userCode=" + userCode + ", password=" + password
						+ ", isInactive=" + isInactive + ", lastLogin=" + lastLogin + ", dutyName=" + dutyName + "]";
	}

	
}
