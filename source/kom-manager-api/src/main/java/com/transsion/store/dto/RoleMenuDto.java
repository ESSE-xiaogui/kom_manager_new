package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class RoleMenuDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long roleId;
	
	private List<Long> menus;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public List<Long> getMenus() {
		return menus;
	}

	public void setMenus(List<Long> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "RoleMenuDto [roleId=" + roleId + ", menus=" + menus + "]";
	}

}
