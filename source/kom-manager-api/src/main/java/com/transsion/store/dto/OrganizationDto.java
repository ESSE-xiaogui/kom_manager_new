package com.transsion.store.dto;

import java.io.Serializable;

public class OrganizationDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 公司Id
	 * */
	private Integer companyId;
	/**
	 * 父级组织ID
	 * */
	private Integer parentId;
	
	/**
	 * 组织ID
	 * */
	private Integer orgId;
	/**
	 * 组织名称
	 * */
	private String orgName;
	
	/**
	 * 业务属性
	 * */
	private String dutyName;
	
	/**
	 * 1表示激活状态，被激活有效的数据可以用于新增业务，2表示停用，被停用无效的数据只能用于历史数据查询中
	 * */
	private Integer isInactive;
	
	/**
	 * 备注
	 * */
	private String remark;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(Integer isInactive) {
		this.isInactive = isInactive;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "OrganizationDto [companyId=" + companyId + ", parentId=" + parentId + ", orgId=" + orgId + ", orgName="
				+ orgName + ", dutyName=" + dutyName + ", isInactive=" + isInactive + ", remark=" + remark + "]";
	}
	
}
