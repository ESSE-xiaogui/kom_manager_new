package com.transsion.store.dto;

import java.io.Serializable;

public class SystemRoleResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	  *	角色ID
	  */
	private Long roleId;

	/**
	  *	角色名称
	  */
	private String roleName;
	
	private String roleCode;
	
	/**
	 * 1表示激活状态，被激活有效的数据可以用于新增业务，2表示停用，被停用无效的数据只能用于历史数据查询中
	 */
	private Integer isInactive;
	
	private Integer status;

	public java.lang.Long getRoleId() {
		return roleId;
	}

	public void setRoleId(java.lang.Long roleId) {
		this.roleId = roleId;
	}

	public java.lang.String getRoleName() {
		return roleName;
	}

	public void setRoleName(java.lang.String roleName) {
		this.roleName = roleName;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(Integer isInactive) {
		this.isInactive = isInactive;
	}

	@Override
	public String toString() {
		return "SystemRoleResponseDto [roleId=" + roleId + ", roleName=" + roleName + ", roleCode=" + roleCode
				+ ", isInactive=" + isInactive + ", status=" + status + "]";
	}

}
