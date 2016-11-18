/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:36
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;


public class Model extends com.shangkang.core.bo.Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.String brandCode;

	/**
	  *	
	  */
	private java.lang.String seriesCode;

	/**
	  *	机型代码
	  */
	private java.lang.String modelCode;

	/**
	  *	
	  */
	private java.lang.String modelName;

	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	private java.lang.Integer companyId;

	/**
	  *	字典编号：1403 (颜色、软件版本、T卡容量等)
	  */
	private java.lang.Integer elementType;

	/**
	  *	
	  */
	private java.lang.String elementCode;

	/**
	  *	0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	private java.lang.Integer isInactive;

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
	private java.lang.String createdTime;

	/**
	  *	
	  */
	private java.lang.String updatedBy;

	/**
	  *	
	  */
	private java.lang.String updatedTime;

	/**
	  *	系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
	  */
	private java.lang.Integer version;

	/**
	  *	
	  */
	public java.lang.Long getId() 
	{
		return id;
	}
	
	/**
	  *	
	  */
	public void setId(java.lang.Long id) 
	{
		this.id = id;
	}
	
	/**
	  *	
	  */
	public java.lang.String getBrandCode() 
	{
		return brandCode;
	}
	
	/**
	  *	
	  */
	public void setBrandCode(java.lang.String brandCode) 
	{
		this.brandCode = brandCode;
	}
	
	/**
	  *	
	  */
	public java.lang.String getSeriesCode() 
	{
		return seriesCode;
	}
	
	/**
	  *	
	  */
	public void setSeriesCode(java.lang.String seriesCode) 
	{
		this.seriesCode = seriesCode;
	}
	
	/**
	  *	机型代码
	  */
	public java.lang.String getModelCode() 
	{
		return modelCode;
	}
	
	/**
	  *	机型代码
	  */
	public void setModelCode(java.lang.String modelCode) 
	{
		this.modelCode = modelCode;
	}
	
	/**
	  *	
	  */
	public java.lang.String getModelName() 
	{
		return modelName;
	}
	
	/**
	  *	
	  */
	public void setModelName(java.lang.String modelName) 
	{
		this.modelName = modelName;
	}
	
	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	public java.lang.Integer getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	public void setCompanyId(java.lang.Integer companyId) 
	{
		this.companyId = companyId;
	}
	
	/**
	  *	字典编号：1403 (颜色、软件版本、T卡容量等)
	  */
	public java.lang.Integer getElementType() 
	{
		return elementType;
	}
	
	/**
	  *	字典编号：1403 (颜色、软件版本、T卡容量等)
	  */
	public void setElementType(java.lang.Integer elementType) 
	{
		this.elementType = elementType;
	}
	
	/**
	  *	
	  */
	public java.lang.String getElementCode() 
	{
		return elementCode;
	}
	
	/**
	  *	
	  */
	public void setElementCode(java.lang.String elementCode) 
	{
		this.elementCode = elementCode;
	}
	
	/**
	  *	0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	public java.lang.Integer getIsInactive() 
	{
		return isInactive;
	}
	
	/**
	  *	0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	public void setIsInactive(java.lang.Integer isInactive) 
	{
		this.isInactive = isInactive;
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
	public java.lang.String getCreatedTime() 
	{
		return createdTime;
	}
	
	/**
	  *	
	  */
	public void setCreatedTime(java.lang.String createdTime) 
	{
		this.createdTime = createdTime;
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
	public java.lang.String getUpdatedTime() 
	{
		return updatedTime;
	}
	
	/**
	  *	
	  */
	public void setUpdatedTime(java.lang.String updatedTime) 
	{
		this.updatedTime = updatedTime;
	}
	
	/**
	  *	系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
	  */
	public java.lang.Integer getVersion() 
	{
		return version;
	}
	
	/**
	  *	系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
	  */
	public void setVersion(java.lang.Integer version) 
	{
		this.version = version;
	}
	
	public String toString()
	{
		return "Model [" + 
					"id=" + id + 
					", brandCode=" + brandCode + 
					", seriesCode=" + seriesCode + 
					", modelCode=" + modelCode + 
					", modelName=" + modelName + 
					", companyId=" + companyId + 
					", elementType=" + elementType + 
					", elementCode=" + elementCode + 
					", isInactive=" + isInactive + 
					", remark=" + remark + 
					", createdBy=" + createdBy + 
					", createdTime=" + createdTime + 
					", updatedBy=" + updatedBy + 
					", updatedTime=" + updatedTime + 
					", version=" + version + 
				"]";
	}
}

