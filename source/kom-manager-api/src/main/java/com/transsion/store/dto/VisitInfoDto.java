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
 * @author guihua.zhang 
 * update time 2017-02-27
 * */
public class VisitInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	  *	
	  */
	private Long id;

	/**
	  *	计划巡店时间
	  */
	private String planDate;

	/**
	  *	门店id
	  */
	private Long shopId;

	/**
	 * 门店名称
	 * */
	private String shopName;

	/**
	 * 门店等级id
	 * */
	private Long gradeId;

	/**
	 * 门店等级名称
	 * */
	private String gradeName;

	/**
	 * 周计划巡店数量
	 * */
	private Long weekPlanQty;

	/**
	 * 是否巡店计划之内 true 是 false 不是
	 * */
	private boolean isPlaned;
	
	/**
	 * 是否完成 1未巡店 2 已巡店
	 * */
	private boolean isFinished;
	
	private String cityName;
	
	private String planner;

	/**
	  *	备注
	  */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public Long getWeekPlanQty() {
		return weekPlanQty;
	}

	public void setWeekPlanQty(Long weekPlanQty) {
		this.weekPlanQty = weekPlanQty;
	}

	public boolean isPlaned() {
		return isPlaned;
	}

	public void setPlaned(boolean isPlaned) {
		this.isPlaned = isPlaned;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getPlanner() {
		return planner;
	}

	public void setPlanner(String planner) {
		this.planner = planner;
	}

	@Override
	public String toString() {
		return "VisitInfoDto [id=" + id + ", planDate=" + planDate + ", shopId=" + shopId + ", shopName=" + shopName
				+ ", gradeId=" + gradeId + ", gradeName=" + gradeName + ", weekPlanQty=" + weekPlanQty + ", isPlaned="
				+ isPlaned + ", isFinished=" + isFinished + ", cityName=" + cityName + ", planner=" + planner
				+ ", remark=" + remark + "]";
	}
	
}
