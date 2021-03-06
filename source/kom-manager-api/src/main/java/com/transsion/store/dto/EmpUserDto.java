package com.transsion.store.dto;

import java.io.Serializable;

public class EmpUserDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String userCode;
	
	private String password;
	
	private java.lang.Integer isInactive;

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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public java.lang.Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(java.lang.Integer isInactive) {
		this.isInactive = isInactive;
	}

	@Override
	public String toString() {
		return "EmpUserDto [id=" + id + ", userCode=" + userCode + ", password=" + password + ", isInactive="
						+ isInactive + "]";
	}

	
}
