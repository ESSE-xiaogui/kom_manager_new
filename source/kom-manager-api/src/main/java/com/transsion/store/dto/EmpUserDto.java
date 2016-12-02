package com.transsion.store.dto;

import java.io.Serializable;

public class EmpUserDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String userCode;

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

	@Override
	public String toString() {
		return "EmpUserDto [id=" + id + ", userCode=" + userCode + "]";
	}
	
	
}
