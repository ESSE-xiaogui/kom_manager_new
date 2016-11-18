/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:40
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class SystemMenu extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
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
	private java.lang.Long menuOrder;

	/**
	  *	
	  */
	private java.lang.Long parentMenuId;

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
	private java.lang.Long usable;

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

	/**
	  *	
	  */
	private java.lang.Integer version;

	/**
	  *	
	  */
	public java.lang.Long getMenuId() 
	{
		return menuId;
	}
	
	/**
	  *	
	  */
	public void setMenuId(java.lang.Long menuId) 
	{
		this.menuId = menuId;
	}
	
	/**
	  *	
	  */
	public java.lang.String getMenuCode() 
	{
		return menuCode;
	}
	
	/**
	  *	
	  */
	public void setMenuCode(java.lang.String menuCode) 
	{
		this.menuCode = menuCode;
	}
	
	/**
	  *	
	  */
	public java.lang.String getMenuName() 
	{
		return menuName;
	}
	
	/**
	  *	
	  */
	public void setMenuName(java.lang.String menuName) 
	{
		this.menuName = menuName;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getMenuOrder() 
	{
		return menuOrder;
	}
	
	/**
	  *	
	  */
	public void setMenuOrder(java.lang.Long menuOrder) 
	{
		this.menuOrder = menuOrder;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getParentMenuId() 
	{
		return parentMenuId;
	}
	
	/**
	  *	
	  */
	public void setParentMenuId(java.lang.Long parentMenuId) 
	{
		this.parentMenuId = parentMenuId;
	}
	
	/**
	  *	
	  */
	public java.lang.String getMenuIcon() 
	{
		return menuIcon;
	}
	
	/**
	  *	
	  */
	public void setMenuIcon(java.lang.String menuIcon) 
	{
		this.menuIcon = menuIcon;
	}
	
	/**
	  *	
	  */
	public java.lang.String getPageUrl() 
	{
		return pageUrl;
	}
	
	/**
	  *	
	  */
	public void setPageUrl(java.lang.String pageUrl) 
	{
		this.pageUrl = pageUrl;
	}
	
	/**
	  *	是否可用：0表示不可以用，1表示可用
	  */
	public java.lang.Long getUsable() 
	{
		return usable;
	}
	
	/**
	  *	是否可用：0表示不可以用，1表示可用
	  */
	public void setUsable(java.lang.Long usable) 
	{
		this.usable = usable;
	}
	
	/**
	  *	
	  */
	public java.lang.String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	
	  */
	public void setRemark(java.lang.String remark) 
	{
		this.remark = remark;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCreatedBy() 
	{
		return createdBy;
	}
	
	/**
	  *	
	  */
	public void setCreatedBy(java.lang.String createdBy) 
	{
		this.createdBy = createdBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCreateTime() 
	{
		return createTime;
	}
	
	/**
	  *	
	  */
	public void setCreateTime(java.lang.String createTime) 
	{
		this.createTime = createTime;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUpdatedBy() 
	{
		return updatedBy;
	}
	
	/**
	  *	
	  */
	public void setUpdatedBy(java.lang.String updatedBy) 
	{
		this.updatedBy = updatedBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUpdateTime() 
	{
		return updateTime;
	}
	
	/**
	  *	
	  */
	public void setUpdateTime(java.lang.String updateTime) 
	{
		this.updateTime = updateTime;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getVersion() 
	{
		return version;
	}
	
	/**
	  *	
	  */
	public void setVersion(java.lang.Integer version) 
	{
		this.version = version;
	}
	
	public String toString()
	{
		return "SystemMenu [" + 
					"menuId=" + menuId + 
					", menuCode=" + menuCode + 
					", menuName=" + menuName + 
					", menuOrder=" + menuOrder + 
					", parentMenuId=" + parentMenuId + 
					", menuIcon=" + menuIcon + 
					", pageUrl=" + pageUrl + 
					", usable=" + usable + 
					", remark=" + remark + 
					", createdBy=" + createdBy + 
					", createTime=" + createTime + 
					", updatedBy=" + updatedBy + 
					", updateTime=" + updateTime + 
					", version=" + version + 
				"]";
	}
}

