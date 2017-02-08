/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:39
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class ShopBiz extends Model{

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
	private java.lang.Long companyId;

	/**
	  *	业务类型
	  */
	private java.lang.String bizName;

	/**
	 * 品牌
	 * */
	private String brandCode;
	
	/**
	 * 类型名称(CN)
	 * */
	private String CNName;
	
	/**
	 * 类型名称(EN)
	 * */
	private String ENName;
	
	/**
	 * 是否启用 1启用 2停用
	 * */
	private Integer isInActive;

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
	  *	业务类型
	  */
	public java.lang.String getBizName() 
	{
		return bizName;
	}
	
	/**
	  *	业务类型
	  */
	public void setBizName(java.lang.String bizName) 
	{
		this.bizName = bizName;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	
	  */
	public void setCompanyId(java.lang.Long companyId) 
	{
		this.companyId = companyId;
	}
	
	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getCNName() {
		return CNName;
	}

	public void setCNName(String cNName) {
		CNName = cNName;
	}

	public String getENName() {
		return ENName;
	}

	public void setENName(String eNName) {
		ENName = eNName;
	}

	public Integer getIsInActive() {
		return isInActive;
	}

	public void setIsInActive(Integer isInActive) {
		this.isInActive = isInActive;
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

	@Override
	public String toString() {
		return "ShopBiz [id=" + id + ", companyId=" + companyId + ", bizName=" + bizName + ", brandCode=" + brandCode
						+ ", CNName=" + CNName + ", ENName=" + ENName + ", isInActive=" + isInActive + ", remark="
						+ remark + ", createBy=" + createBy + ", createDate=" + createDate + ", updateBy=" + updateBy
						+ ", updateDate=" + updateDate + ", version=" + version + "]";
	}

}

