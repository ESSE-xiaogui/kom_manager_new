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
	
	private Long userId;
	
	private Long companyId;
	
	/**
	 * 用户名称
	 * */
	private String userName;
	
	/***/
	private String userCode;
	
	private String password;
	
	private Long isInactive;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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

	@Override
	public String toString() {
		return "UserResponseDto [status=" + status + ", id=" + id + ", userId=" + userId + ", companyId=" + companyId
						+ ", userName=" + userName + ", userCode=" + userCode + ", password=" + password
						+ ", isInactive=" + isInactive + "]";
	}
	
}
