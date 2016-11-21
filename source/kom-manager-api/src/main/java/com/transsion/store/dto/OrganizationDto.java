package com.transsion.store.dto;

public class OrganizationDto {
	
	/**
	 * 父级组织ID
	 * */
	private Integer parentId;
	
	/**
	 * 组织名称
	 * */
	private String orgName;
	
	/**
	 * 业务属性
	 * */
	private String dutyName;
	
	/**
	 * 是否停用 注：0：激活1：停用
	 * */
	private Integer isInactive;
	
	/**
	 * 备注
	 * */
	private String remark;

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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
		return "OrganizationDto [parentId=" + parentId + ", orgName=" + orgName + ", dutyName=" + dutyName
				+ ", isInactive=" + isInactive + ", remark=" + remark + "]";
	}
}
