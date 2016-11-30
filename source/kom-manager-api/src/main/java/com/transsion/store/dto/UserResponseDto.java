package com.transsion.store.dto;

public class UserResponseDto {
	/**
	 * 状态 注：1： 成功 2：失败
	 * */
	private Integer status;
	
	/**
	 * 用户名称
	 * */
	private String userName;

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

	@Override
	public String toString() {
		return "UserResponseDto [status=" + status + ", userName=" + userName + "]";
	}
	
	
}
