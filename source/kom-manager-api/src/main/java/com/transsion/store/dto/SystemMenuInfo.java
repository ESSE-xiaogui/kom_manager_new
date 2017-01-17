package com.transsion.store.dto;

import com.shangkang.core.bo.Model;

public class SystemMenuInfo extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	

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
	private java.lang.Long menuOrder;

	
	private java.lang.String parentMenuName;

	/**
	  *	
	  */
	private java.lang.String menuIcon;

	/**
	  *	
	  */
	private java.lang.String pageUrl;

	/**
	  *	是否可用：0表示不可以用，1表示可用
	  */
	private java.lang.Integer usable;

	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	
	  */
	private java.lang.String createdBy;

	/**
	  *	
	  */
	private java.lang.String createTime;

	/**
	  *	
	  */
	private java.lang.String updatedBy;

	/**
	  *	
	  */
	private java.lang.String updateTime;


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

	public java.lang.Long getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(java.lang.Long menuOrder) {
		this.menuOrder = menuOrder;
	}


	public java.lang.String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(java.lang.String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public java.lang.String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(java.lang.String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(java.lang.String createdBy) {
		this.createdBy = createdBy;
	}

	public java.lang.String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.lang.String createTime) {
		this.createTime = createTime;
	}

	public java.lang.String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(java.lang.String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public java.lang.String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.lang.String updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.String getParentMenuName() {
		return parentMenuName;
	}

	public void setParentMenuName(java.lang.String parentMenuName) {
		this.parentMenuName = parentMenuName;
	}

	@Override
	public String toString() {
		return "SystemMenuInfo [menuCode=" + menuCode + ", menuName=" + menuName + ", menuOrder=" + menuOrder
						+ ", parentMenuName=" + parentMenuName + ", menuIcon=" + menuIcon + ", pageUrl=" + pageUrl
						+ ", usable=" + usable + ", remark=" + remark + ", createdBy=" + createdBy + ", createTime="
						+ createTime + ", updatedBy=" + updatedBy + ", updateTime=" + updateTime + "]";
	}

}

