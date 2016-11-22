package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class OrganizationTreeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 父级Id
	 * */
	private Integer parentId;
	
	/**
	 * 组织Id
	 * */
	private Integer orgId;
	
	/**
	 * 组织名称
	 * */
	private String orgName;
	
	/**
	 * 子集菜单
	 * */
	private List<OrganizationTreeDto> childen;

	/**
	 * 父级Id
	 * */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * 父级Id
	 * */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * 组织Id
	 * */
	public Integer getOrgId() {
		return orgId;
	}

	/**
	 * 组织Id
	 * */
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	/**
	 * 组织名称
	 * */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * 组织名称
	 * */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * 子集菜单
	 * */
	public List<OrganizationTreeDto> getChilden() {
		return childen;
	}

	/**
	 * 子集菜单
	 * */
	public void setChilden(List<OrganizationTreeDto> childen) {
		this.childen = childen;
	}

	@Override
	public String toString() {
		return "OrganizationTreeDto [parentId=" + parentId + ", orgId=" + orgId + ", orgName=" + orgName + ", childen="
				+ childen + "]";
	}
		
}
