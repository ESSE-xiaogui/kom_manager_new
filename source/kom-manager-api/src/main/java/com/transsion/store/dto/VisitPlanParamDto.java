package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class VisitPlanParamDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户Id 为空/后台自取
	 * */
	private Long userId;
	
	//判断逻辑用shopId
	private List<Long> shopIds;
	
	/**
	  *	事业部ID
	  */
	private Long companyId;
	/**
	 * 巡店者
	 * */
	private String planner;
	
	/**
	  *	巡店计划日期本周开始日期--周日
	  */
	private String beginDate;
	
	/**
	  *	巡店计划日期本周开始日期--周六
	  */
	private String endDate;

	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getShopIds() {
		return shopIds;
	}

	public void setShopIds(List<Long> shopIds) {
		this.shopIds = shopIds;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getPlanner() {
		return planner;
	}

	public void setPlanner(String planner) {
		this.planner = planner;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "VisitPlanParamDto [userId=" + userId + ", shopIds=" + shopIds + ", companyId=" + companyId
						+ ", planner=" + planner + ", beginDate=" + beginDate + ", endDate=" + endDate + "]";
	}

}
