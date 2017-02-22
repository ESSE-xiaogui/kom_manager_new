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

public class SystemResource extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	/**
	 * 资源类型-web前端
	 */
	public static final String RESOURCE_TYPE_FRONT = "F";

	/**
	 * 资源类型-web前端
	 */
	public static final String RESOURCE_TYPE_DESCRIPTION_FRONT = "WEB前端资源";

	/**
	 * 资源类型-后台
	 */
	public static final String RESOURCE_TYPE_BACKEND = "B";

	/**
	 * 资源类型-后台
	 */
	public static final String RESOURCE_TYPE_DESCRIPTION_BACKEND = "后端资源";
	/**
	  *	资源ID
	  */
	private java.lang.Long resId;

	/**
	  *	资源类型(F:前端web资源，B:后台资源）
	  */
	private java.lang.String resType;

	/**
	  *	资源CODE
	  */
	private java.lang.String resCode;

	/**
	  *	资源名称
	  */
	private java.lang.String resName;

	/**
	  *	资源的url
	  */
	private java.lang.String resUrl;

	/**
	  *	显示顺序
	  */
	private java.lang.Long showIndex;

	/**
	  *	N：不可匿名访问 Y：可匿名访问
	  */
	private java.lang.String isAnonAccess;

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
	  *	资源ID
	  */
	public java.lang.Long getResId() 
	{
		return resId;
	}
	
	/**
	  *	资源ID
	  */
	public void setResId(java.lang.Long resId) 
	{
		this.resId = resId;
	}
	
	/**
	  *	资源类型(F:前端web资源，B:后台资源）
	  */
	public java.lang.String getResType() 
	{
		return resType;
	}
	
	/**
	  *	资源类型(F:前端web资源，B:后台资源）
	  */
	public void setResType(java.lang.String resType) 
	{
		this.resType = resType;
	}
	
	/**
	  *	资源CODE
	  */
	public java.lang.String getResCode() 
	{
		return resCode;
	}
	
	/**
	  *	资源CODE
	  */
	public void setResCode(java.lang.String resCode) 
	{
		this.resCode = resCode;
	}
	
	/**
	  *	资源名称
	  */
	public java.lang.String getResName() 
	{
		return resName;
	}
	
	/**
	  *	资源名称
	  */
	public void setResName(java.lang.String resName) 
	{
		this.resName = resName;
	}
	
	/**
	  *	资源的url
	  */
	public java.lang.String getResUrl() 
	{
		return resUrl;
	}
	
	/**
	  *	资源的url
	  */
	public void setResUrl(java.lang.String resUrl) 
	{
		this.resUrl = resUrl;
	}
	
	/**
	  *	显示顺序
	  */
	public java.lang.Long getShowIndex() 
	{
		return showIndex;
	}
	
	/**
	  *	显示顺序
	  */
	public void setShowIndex(java.lang.Long showIndex) 
	{
		this.showIndex = showIndex;
	}
	
	/**
	  *	N：不可匿名访问 Y：可匿名访问
	  */
	public java.lang.String getIsAnonAccess() 
	{
		return isAnonAccess;
	}
	
	/**
	  *	N：不可匿名访问 Y：可匿名访问
	  */
	public void setIsAnonAccess(java.lang.String isAnonAccess) 
	{
		this.isAnonAccess = isAnonAccess;
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
		return "SystemResource [" + 
					"resId=" + resId + 
					", resType=" + resType + 
					", resCode=" + resCode + 
					", resName=" + resName + 
					", resUrl=" + resUrl + 
					", showIndex=" + showIndex + 
					", isAnonAccess=" + isAnonAccess + 
					", remark=" + remark + 
					", createdBy=" + createdBy + 
					", createTime=" + createTime + 
					", updatedBy=" + updatedBy + 
					", updateTime=" + updateTime + 
					", version=" + version + 
				"]";
	}

}

