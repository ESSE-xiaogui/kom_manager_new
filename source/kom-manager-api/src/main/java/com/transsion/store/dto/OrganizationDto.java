package com.transsion.store.dto;

import java.io.Serializable;

/**
 * @author guihua.zhang
 * */
public class OrganizationDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 组织ID
	 * */
	private Long id;
	
	/**
	 * 公司Id
	 * */
	private Integer companyId;
	/**
	 * 父级组织ID
	 * */
	private Long parentId;
	
	/**
	 * 
	 * */
	private Integer orgId;
	
	/**
	 * 父级组织名称
	 * */
	private String pOrgName;
	/**
	 * 组织名称
	 * */
	private String orgName;
	
	/**
	 * 业务属性
	 * */
	private Long bizId;
	
	/**
	 * 1：启用 2：禁用
	 * */
	private Integer isInactive;
	
	/**
	 * 备注
	 * */
	private String remark;

	/**
	 * 公司Id
	 * */
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * 公司Id
	 * */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * 父级组织ID
	 * */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 父级组织ID
	 * */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 
	 * */
	public Integer getOrgId() {
		return orgId;
	}

	/**
	 * 
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
	 * 1：启用 2：禁用
	 * */
	public Integer getIsInactive() {
		return isInactive;
	}

	/**
	 * 1：启用 2：禁用
	 * */
	public void setIsInactive(Integer isInactive) {
		this.isInactive = isInactive;
	}

	/**
	 * 备注
	 * */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注
	 * */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 组织ID
	 * */
	public Long getId() {
		return id;
	}

	/**
	 * 组织ID
	 * */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 父级组织名称
	 * */
	public String getpOrgName() {
		return pOrgName;
	}

	/**
	 * 父级组织名称
	 * */
	public void setpOrgName(String pOrgName) {
		this.pOrgName = pOrgName;
	}

	/**
	 * 业务属性
	 * */
	public Long getBizId() {
		return bizId;
	}

	/**
	 * 业务属性
	 * */
	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}

	@Override
	public String toString() {
		return "OrganizationDto [id=" + id + ", companyId=" + companyId + ", parentId=" + parentId + ", orgId=" + orgId
						+ ", pOrgName=" + pOrgName + ", orgName=" + orgName + ", bizId=" + bizId + ", isInactive="
						+ isInactive + ", remark=" + remark + "]";
	}


}
