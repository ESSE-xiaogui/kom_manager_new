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
/**
 * updateBy guihua.zhang on 2017-2-21
 * */
public class Organization extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	组织机构Id
	  */
	private Long id;

	/**
	  *	
	  */
	private Integer orgId;

	/**
	  *	组织机构名称
	  */
	private String orgName;
	

	/**
	  *	公司Id
	  */
	private Integer companyId;

	/**
	  *	父级Id
	  */
	private Long parentId;

	/**
	 * 业务类型Id
	 * */
	private Long bizId;

	/**
	 * 1：启用 2：禁用
	 * */
	private Integer isInactive;

	/**
	  *	备注
	  */
	private String remark;

	/**
	  *	创建人
	  */
	private String createdBy;

	/**
	  *	创建时间
	  */
	private String createdTime;

	/**
	  *	更新人
	  */
	private String updatedBy;

	/**
	  *	更新时间
	  */
	private String updatedTime;

	/**
	  *	版本
	  */
	private Integer version;

	/**
	  *	组织机构Id
	  */
	public Long getId() 
	{
		return id;
	}
	
	/**
	  *	组织机构Id
	  */
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	/**
	  *	
	  */
	public Integer getOrgId() 
	{
		return orgId;
	}
	
	/**
	  *	
	  */
	public void setOrgId(Integer orgId) 
	{
		this.orgId = orgId;
	}
	
	/**
	  *	组织机构名称
	  */
	public String getOrgName() 
	{
		return orgName;
	}
	
	/**
	  *	组织机构名称
	  */
	public void setOrgName(String orgName) 
	{
		this.orgName = orgName;
	}
	
	/**
	  *	公司Id
	  */
	public Integer getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	公司Id
	  */
	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}
	
	/**
	  *	父级Id
	  */
	public Long getParentId() 
	{
		return parentId;
	}
	
	/**
	  *	父级Id
	  */
	public void setParentId(Long parentId) 
	{
		this.parentId = parentId;
	}
	
	/**
	 * 1：启用 2：禁用
	 * */
	public Integer getIsInactive() 
	{
		return isInactive;
	}
	
	/**
	 * 1：启用 2：禁用
	 * */
	public void setIsInactive(Integer isInactive) 
	{
		this.isInactive = isInactive;
	}
	
	/**
	  *	备注
	  */
	public String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	备注
	  */
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}
	
	/**
	  *	创建人
	  */
	public String getCreatedBy() 
	{
		return createdBy;
	}
	
	/**
	  *	创建人
	  */
	public void setCreatedBy(String createdBy) 
	{
		this.createdBy = createdBy;
	}
	
	/**
	  *	创建时间
	  */
	public String getCreatedTime() 
	{
		return createdTime;
	}
	
	/**
	  *	创建时间
	  */
	public void setCreatedTime(String createdTime) 
	{
		this.createdTime = createdTime;
	}
	
	/**
	  *	更新人
	  */
	public String getUpdatedBy() 
	{
		return updatedBy;
	}
	
	/**
	  * 更新人	
	  */
	public void setUpdatedBy(String updatedBy) 
	{
		this.updatedBy = updatedBy;
	}
	
	/**
	  *	更新时间
	  */
	public String getUpdatedTime() 
	{
		return updatedTime;
	}
	
	/**
	  *	更新时间
	  */
	public void setUpdatedTime(String updatedTime) 
	{
		this.updatedTime = updatedTime;
	}
	
	/**
	  *	版本
	  */
	public Integer getVersion() 
	{
		return version;
	}
	
	/**
	  *	版本
	  */
	public void setVersion(Integer version) 
	{
		this.version = version;
	}

	/**
	 * 业务类型
	 * */
	public Long getBizId() {
		return bizId;
	}

	/**
	 * 业务类型
	 * */
	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", orgId=" + orgId + ", orgName=" + orgName + ", companyId=" + companyId
						+ ", parentId=" + parentId + ", bizId=" + bizId + ", isInactive=" + isInactive + ", remark="
						+ remark + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", updatedBy="
						+ updatedBy + ", updatedTime=" + updatedTime + ", version=" + version + "]";
	}


}

