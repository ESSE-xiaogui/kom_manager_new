package com.transsion.store.dto;

import java.io.Serializable;

public class OrganizationResponseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 状态 注：1： 成功 2：失败 3:有子集不允许删除
	 * */
	private Integer status;
	
	/**
	 * 父组织机构名称
	 * */
	private String parentName;
	
	/**
	 * 子组织机构名称
	 * */
	private String childrenName;

	/**
	 * 状态 注：1： 成功 2：失败
	 * */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 状态 注：1： 成功 2：失败 3:组织下有子组织,不能删除 4:组织下绑定员工不能删除
	 * */
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getChildrenName() {
		return childrenName;
	}

	public void setChildrenName(String childrenName) {
		this.childrenName = childrenName;
	}

	@Override
	public String toString() {
		return "OrganizationResponseDto [status=" + status + ", parentName=" + parentName + ", childrenName="
				+ childrenName + "]";
	}
	

}
