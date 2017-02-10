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
	private java.lang.String brandCode;
	
	/**
	 * 类型名称(CN)
	 * */
	private java.lang.String chinaName;
	
	/**
	 * 类型名称(EN)
	 * */
	private java.lang.String englishName;
	
	/**
	 * 是否启用 1启用 2停用
	 * */
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
	private java.lang.Integer version;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Long companyId) {
		this.companyId = companyId;
	}

	public java.lang.String getBizName() {
		return bizName;
	}

	public void setBizName(java.lang.String bizName) {
		this.bizName = bizName;
	}

	public java.lang.String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(java.lang.String brandCode) {
		this.brandCode = brandCode;
	}

	public java.lang.String getChinaName() {
		return chinaName;
	}

	public void setChinaName(java.lang.String chinaName) {
		this.chinaName = chinaName;
	}

	public java.lang.String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(java.lang.String englishName) {
		this.englishName = englishName;
	}

	public java.lang.Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(java.lang.Integer isInactive) {
		this.isInactive = isInactive;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	public java.lang.String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.lang.String createDate) {
		this.createDate = createDate;
	}

	public java.lang.String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}

	public java.lang.String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.lang.String updateDate) {
		this.updateDate = updateDate;
	}

	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ShopBiz [id=" + id + ", companyId=" + companyId + ", bizName=" + bizName + ", brandCode=" + brandCode
						+ ", chinaName=" + chinaName + ", englishName=" + englishName + ", isInactive=" + isInactive
						+ ", remark=" + remark + ", createBy=" + createBy + ", createDate=" + createDate + ", updateBy="
						+ updateBy + ", updateDate=" + updateDate + ", version=" + version + "]";
	}
}

