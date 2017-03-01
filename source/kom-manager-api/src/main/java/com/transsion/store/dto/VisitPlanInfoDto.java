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
/**
 * @author guihua.zhang on 2017-03-01
 * 巡店计划详情
 * */
public class VisitPlanInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	  *	巡店计划Id
	  */
	private Long id;

	/**
	  *	巡店计划日期
	  */
	private String planDate;

	/**
	  *	店铺Id
	  */
	private Long shopId;
	
	/**
	  *	readonly 店铺名称
	  */
	private String shopName;
	
	
	/**
	  *	readonly 等级Id
	  */
	private Long gradeId;
	
	/**
	  *	readonly 等级名称
	  */
	private String gradeName;

	/**
	  *	readonly 周计划巡店数
	  */
	private int weekPlansQty;
	
	
	/**
	  *	备注
	  */
	private String remark;


	/**
	  *	巡店计划Id
	  */
	public Long getId() {
		return id;
	}

	/**
	  *	巡店计划Id
	  */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	  *	巡店计划日期
	  */
	public String getPlanDate() {
		return planDate;
	}

	/**
	  *	巡店计划日期
	  */
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	/**
	  *	店铺Id
	  */
	public Long getShopId() {
		return shopId;
	}

	/**
	  *	店铺Id
	  */
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	/**
	  *	readonly 店铺名称
	  */
	public String getShopName() {
		return shopName;
	}

	/**
	  *	readonly 店铺名称
	  */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	  *	readonly 等级Id
	  */
	public Long getGradeId() {
		return gradeId;
	}

	/**
	  *	readonly 等级Id
	  */
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}

	/**
	  *	readonly 等级名称
	  */
	public String getGradeName() {
		return gradeName;
	}

	/**
	  *	readonly 等级名称
	  */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	/**
	  *	readonly 周计划巡店数
	  */
	public int getWeekPlansQty() {
		return weekPlansQty;
	}

	/**
	  *	readonly 周计划巡店数
	  */
	public void setWeekPlansQty(int weekPlansQty) {
		this.weekPlansQty = weekPlansQty;
	}

	/**
	  *	备注
	  */
	public String getRemark() {
		return remark;
	}

	/**
	  *	备注
	  */
	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "VisitPlanInfoDto [id=" + id + ", planDate=" + planDate + ", shopId=" + shopId + ", shopName=" + shopName
						+ ", gradeId=" + gradeId + ", gradeName=" + gradeName + ", weekPlansQty=" + weekPlansQty
						+ ", remark=" + remark + "]";
	}


}
