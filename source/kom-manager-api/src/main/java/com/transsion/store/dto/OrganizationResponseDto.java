package com.transsion.store.dto;

public class OrganizationResponseDto {
	/**
	 * 状态 注：1： 成功 2：失败 3:有子集不允许删除
	 * */
	private Integer status;
	
	/**
	 * 组织机构名称
	 * */
	private String orgName;

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

	/**
	 * 组织机构名称
	 * */
	public String getOrgName() {
		return orgName;
	}
	
	/**
	 * 组织机构名称
	 * */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public String toString() {
		return "OrganizationResponseDto [status=" + status + ", orgName=" + orgName + "]";
	}

}
