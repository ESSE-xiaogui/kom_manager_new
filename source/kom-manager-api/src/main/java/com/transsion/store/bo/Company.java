/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:35
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

/**
 * @author guihua.zhang
 * update time 2017-0-20
 * */
public class Company extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	事业部ID
	  */
	private Long id;

	/**
	  *	事业部品牌
	  */
	private String companyCode;

	/**
	  *	事业部名称
	  */
	private String companyName;

	/**
	  *	事业部父级ID
	  */
	private Long parentId;

	/**
	  *	1：启用 2：禁用
	  */
	private Integer isInactive;

	/**
	  *	
	  */
	private String remark;

	/**
	  *	
	  */
	private String createdBy;

	/**
	  *	
	  */
	private String createdTime;

	/**
	  *	
	  */
	private String updatedBy;

	/**
	  *	
	  */
	private String updatedTime;

	/**
	  *	
	  */
	private Integer version;

	/**
	  *	
	  */
	public Long getId() 
	{
		return id;
	}
	
	/**
	  *	
	  */
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	/**
	  *	
	  */
	public String getCompanyCode() 
	{
		return companyCode;
	}
	
	/**
	  *	
	  */
	public void setCompanyCode(String companyCode) 
	{
		this.companyCode = companyCode;
	}
	
	/**
	  *	
	  */
	public String getCompanyName() 
	{
		return companyName;
	}
	
	/**
	  *	
	  */
	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}
	
	/**
	  *	
	  */
	public Long getParentId() 
	{
		return parentId;
	}
	
	/**
	  *	
	  */
	public void setParentId(Long parentId) 
	{
		this.parentId = parentId;
	}
	
	/**
	  *	0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	public Integer getIsInactive() 
	{
		return isInactive;
	}
	
	/**
	  *	0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	public void setIsInactive(Integer isInactive) 
	{
		this.isInactive = isInactive;
	}
	
	/**
	  *	
	  */
	public String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	
	  */
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}
	
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	  *	
	  */
	public String getCreatedTime() 
	{
		return createdTime;
	}
	
	/**
	  *	
	  */
	public void setCreatedTime(String createdTime) 
	{
		this.createdTime = createdTime;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	  *	
	  */
	public String getUpdatedTime() 
	{
		return updatedTime;
	}
	
	/**
	  *	
	  */
	public void setUpdatedTime(String updatedTime) 
	{
		this.updatedTime = updatedTime;
	}
	
	/**
	  *	
	  */
	public Integer getVersion() 
	{
		return version;
	}
	
	/**
	  *	
	  */
	public void setVersion(Integer version) 
	{
		this.version = version;
	}
	
	public String toString()
	{
		return "Company [" + 
					"id=" + id + 
					", companyCode=" + companyCode + 
					", companyName=" + companyName + 
					", parentId=" + parentId + 
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

