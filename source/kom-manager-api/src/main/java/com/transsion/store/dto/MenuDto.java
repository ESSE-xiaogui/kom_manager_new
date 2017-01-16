package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class MenuDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	  *	
	  */
	private java.lang.Long menuId;
	/**
	  *	
	  */
	private java.lang.String menuCode;
	/**
	  *	
	  */
	private java.lang.String menuName;
	/**
	  *	
	  */
	private java.lang.Long parentMenuId;
	/**
	  *	
	  */
	private java.lang.Integer menuOrder;
	/**
	  *	
	  */
	private java.lang.String menuIcon;
	/**
	  *	
	  */
	private java.lang.String pageUrl;
	/**
	  *	
	  */
	private List<MenuDto> children;
	/**
	  *	
	  */
	private java.lang.String parentMenuName;
	
	private java.lang.String remark;
	
	
	public java.lang.String getParentMenuName() {
		return parentMenuName;
	}
	public void setParentMenuName(java.lang.String parentMenuName) {
		this.parentMenuName = parentMenuName;
	}
	public java.lang.String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(java.lang.String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public List<MenuDto> getChildren() {
		return children;
	}
	public void setChildren(List<MenuDto> children) {
		this.children = children;
	}
	public java.lang.Long getMenuId() {
		return menuId;
	}
	public void setMenuId(java.lang.Long menuId) {
		this.menuId = menuId;
	}
	public java.lang.String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(java.lang.String menuCode) {
		this.menuCode = menuCode;
	}
	public java.lang.String getMenuName() {
		return menuName;
	}
	public void setMenuName(java.lang.String menuName) {
		this.menuName = menuName;
	}
	public java.lang.Long getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(java.lang.Long parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public java.lang.Integer getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(java.lang.Integer menuOrder) {
		this.menuOrder = menuOrder;
	}
	public java.lang.String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(java.lang.String menuIcon) {
		this.menuIcon = menuIcon;
	}
	
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "MenuDto [menuId=" + menuId + ", menuCode=" + menuCode + ", menuName=" + menuName + ", parentMenuId="
						+ parentMenuId + ", menuOrder=" + menuOrder + ", menuIcon=" + menuIcon + ", pageUrl=" + pageUrl
						+ ", children=" + children + ", parentMenuName=" + parentMenuName + ", remark=" + remark + "]";
	}

	

}
