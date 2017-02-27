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

public class VisitPlanInfoDto implements Serializable {

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
	private java.lang.String planDate;

	/**
	  *	
	  */
	private java.lang.Long shopId;
	
	/**
	  *	readonly
	  */
	private java.lang.Long shopName;
	
	
	/**
	  *	readonly
	  */
	private java.lang.Long gradeId;
	
	/**
	  *	readonly
	  */
	private java.lang.Long gradeName;

	/**
	  *	readonly
	  */
	private java.lang.Long weekPlans;
	
	
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
	public java.lang.String getPlanDate() {
		return planDate;
	}

	/**
	  *	
	  */
	public void setPlanDate(java.lang.String planDate) {
		this.planDate = planDate;
	}

	/**
	  *	
	  */
	public java.lang.Long getShopId() {
		return shopId;
	}

	/**
	  *	
	  */
	public void setShopId(java.lang.Long shopId) {
		this.shopId = shopId;
	}

	public java.lang.Long getShopName() {
		return shopName;
	}

	public void setShopName(java.lang.Long shopName) {
		this.shopName = shopName;
	}

	public java.lang.Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(java.lang.Long gradeId) {
		this.gradeId = gradeId;
	}

	public java.lang.Long getGradeName() {
		return gradeName;
	}

	public void setGradeName(java.lang.Long gradeName) {
		this.gradeName = gradeName;
	}

	public java.lang.Long getWeekPlans() {
		return weekPlans;
	}

	public void setWeekPlans(java.lang.Long weekPlans) {
		this.weekPlans = weekPlans;
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
		return "VisitPlanInfoDto [id=" + id + ", planDate=" + planDate + ", shopId=" + shopId + ", remark=" + remark + "]";
	}

}
