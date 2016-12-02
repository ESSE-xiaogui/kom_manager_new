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

import com.shangkang.core.bo.Model;

public class Option extends Model{

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
	private java.lang.Integer optionCode;

	/**
	  *	
	  */
	private java.lang.String optionName;

	/**
	  *	
	  */
	private java.lang.Integer companyId;

	/**
	  *	
	  */
	private java.lang.Integer parentId;

	/**
	  *	字典编号：1101，标明选项的业务类型，如操作、仓库、服务大区、索赔组等
	  */
	private java.lang.Integer optionType;

	/**
	  *	实际的被授权业务对象ID，如仓库、服务大区、索赔组等ID号，有些可能是动态新增的
	  */
	private java.lang.String objectId;

	/**
	  *	1表示激活状态，被激活有效的数据可以用于新增业务，2表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	private java.lang.Integer isInactive;

	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	
	  */
	private java.lang.String createBy;

	/**
	  *	
	  */
	private java.lang.String createDate;

	/**
	  *	
	  */
	private java.lang.String updateBy;

	/**
	  *	
	  */
	private java.lang.String updateDate;

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
	public java.lang.Integer getOptionCode() 
	{
		return optionCode;
	}
	
	/**
	  *	
	  */
	public void setOptionCode(java.lang.Integer optionCode) 
	{
		this.optionCode = optionCode;
	}
	
	/**
	  *	
	  */
	public java.lang.String getOptionName() 
	{
		return optionName;
	}
	
	/**
	  *	
	  */
	public void setOptionName(java.lang.String optionName) 
	{
		this.optionName = optionName;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	
	  */
	public void setCompanyId(java.lang.Integer companyId) 
	{
		this.companyId = companyId;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getParentId() 
	{
		return parentId;
	}
	
	/**
	  *	
	  */
	public void setParentId(java.lang.Integer parentId) 
	{
		this.parentId = parentId;
	}
	
	/**
	  *	字典编号：1101，标明选项的业务类型，如操作、仓库、服务大区、索赔组等
	  */
	public java.lang.Integer getOptionType() 
	{
		return optionType;
	}
	
	/**
	  *	字典编号：1101，标明选项的业务类型，如操作、仓库、服务大区、索赔组等
	  */
	public void setOptionType(java.lang.Integer optionType) 
	{
		this.optionType = optionType;
	}
	
	/**
	  *	实际的被授权业务对象ID，如仓库、服务大区、索赔组等ID号，有些可能是动态新增的
	  */
	public java.lang.String getObjectId() 
	{
		return objectId;
	}
	
	/**
	  *	实际的被授权业务对象ID，如仓库、服务大区、索赔组等ID号，有些可能是动态新增的
	  */
	public void setObjectId(java.lang.String objectId) 
	{
		this.objectId = objectId;
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
	public java.lang.String getCreateBy() 
	{
		return createBy;
	}
	
	/**
	  *	
	  */
	public void setCreateBy(java.lang.String createBy) 
	{
		this.createBy = createBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCreateDate() 
	{
		return createDate;
	}
	
	/**
	  *	
	  */
	public void setCreateDate(java.lang.String createDate) 
	{
		this.createDate = createDate;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUpdateBy() 
	{
		return updateBy;
	}
	
	/**
	  *	
	  */
	public void setUpdateBy(java.lang.String updateBy) 
	{
		this.updateBy = updateBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUpdateDate() 
	{
		return updateDate;
	}
	
	/**
	  *	
	  */
	public void setUpdateDate(java.lang.String updateDate) 
	{
		this.updateDate = updateDate;
	}
	
	public String toString()
	{
		return "Option [" + 
					"id=" + id + 
					", optionCode=" + optionCode + 
					", optionName=" + optionName + 
					", companyId=" + companyId + 
					", parentId=" + parentId + 
					", optionType=" + optionType + 
					", objectId=" + objectId + 
					", isInactive=" + isInactive + 
					", remark=" + remark + 
					", createBy=" + createBy + 
					", createDate=" + createDate + 
					", updateBy=" + updateBy + 
					", updateDate=" + updateDate + 
				"]";
	}
}

