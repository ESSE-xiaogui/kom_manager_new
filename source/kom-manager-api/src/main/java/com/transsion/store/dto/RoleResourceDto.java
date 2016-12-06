package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class RoleResourceDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long roleId;
	
	private List<Long> resIds;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public List<Long> getResIds() {
		return resIds;
	}

	public void setResIds(List<Long> resIds) {
		this.resIds = resIds;
	}

	@Override
	public String toString() {
		return "RoleResourceDto [roleId=" + roleId + ", resIds=" + resIds + "]";
	}
	
	
}
