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

	@Override
	public String toString() {
		return "SystemRoleResponseDto [roleId=" + roleId + ", roleName=" + roleName + ", status=" + status + "]";
	}

}
