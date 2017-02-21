/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 10:24:48
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.dto;

import java.io.Serializable;

public class VisitModelSettingDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.String actionDate;

	/**
	  *	
	  */
	private java.lang.Long companyId;

	/**
	  *	
	  */
	private java.lang.Long brandId;

	/**
	  *	
	  */
	private java.lang.Long modelId;

	/**
	 * itel requirement
	 */
	private java.lang.Long regionId;

	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	
	  */
	public java.lang.Long getId() {
		return id;
	}

	/**
	  *	
	  */
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	/**
	  *	
	  */
	public java.lang.String getActionDate() {
		return actionDate;
	}

	/**
	  *	
	  */
	public void setActionDate(java.lang.String actionDate) {
		this.actionDate = actionDate;
	}

	/**
	  *	
	  */
	public java.lang.Long getCompanyId() {
		return companyId;
	}

	/**
	  *	
	  */
	public void setCompanyId(java.lang.Long companyId) {
		this.companyId = companyId;
	}

	/**
	  *	
	  */
	public java.lang.Long getBrandId() {
		return brandId;
	}

	/**
	  *	
	  */
	public void setBrandId(java.lang.Long brandId) {
		this.brandId = brandId;
	}

	/**
	  *	
	  */
	public java.lang.Long getModelId() {
		return modelId;
	}

	/**
	  *	
	  */
	public void setModelId(java.lang.Long modelId) {
		this.modelId = modelId;
	}

	/**
	 * itel requirement
	 */
	public java.lang.Long getRegionId() {
		return regionId;
	}

	/**
	 * itel requirement
	 */
	public void setRegionId(java.lang.Long regionId) {
		this.regionId = regionId;
	}

	/**
	  *	
	  */
	public java.lang.String getRemark() {
		return remark;
	}

	/**
	  *	
	  */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "VisitModelSettingDto [id=" + id + ", actionDate=" + actionDate + ", companyId=" + companyId
				+ ", brandId=" + brandId + ", modelId=" + modelId + ", regionId=" + regionId + ", remark=" + remark
				+ "]";
	}

}
