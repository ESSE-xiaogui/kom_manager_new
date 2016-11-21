package com.transsion.store.dto;

public class OrganizationDto {
	
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
	 * 是否停用 注：0：激活1：停用
	 * */
	private Integer isInactive;
	
	/**
	 * 备注
	 * */
	private String remark;

	
}
