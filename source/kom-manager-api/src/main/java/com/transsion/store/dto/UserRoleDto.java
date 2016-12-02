package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class UserRoleDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	
	private List<Long> roleIds;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	@Override
	public String toString() {
		return "UserRoleDto [userId=" + userId + ", roleIds=" + roleIds + "]";
	}
}
