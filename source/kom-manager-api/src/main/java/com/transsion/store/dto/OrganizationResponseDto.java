package com.transsion.store.dto;

public class OrganizationResponseDto {
	/**
	 * 状态 注：1： 成功 2：失败
	 * */
	private Integer status;

	/**
	 * 状态 注：1： 成功 2：失败
	 * */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 状态 注：1： 成功 2：失败
	 * */
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrganizationResponseDto [status=" + status + "]";
	}

}
