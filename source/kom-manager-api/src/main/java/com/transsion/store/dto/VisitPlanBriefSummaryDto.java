package com.transsion.store.dto;

import java.io.Serializable;

/**
 * @author guihua.zhang on 2017-02-28
 * */
public class VisitPlanBriefSummaryDto  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 周计划巡店数
	 * */
	private int weekPlanQty;
	
	/**
	 * 当天计划巡店数
	 * */
	private int todayPlanQty;

	/**
	 * 周计划巡店数
	 * */
	public int getWeekPlanQty() {
		return weekPlanQty;
	}

	/**
	 * 周计划巡店数
	 * */
	public void setWeekPlanQty(int weekPlanQty) {
		this.weekPlanQty = weekPlanQty;
	}

	/**
	 * 当天计划巡店数
	 * */
	public int getTodayPlanQty() {
		return todayPlanQty;
	}

	/**
	 * 当天计划巡店数
	 * */
	public void setTodayPlanQty(int todayPlanQty) {
		this.todayPlanQty = todayPlanQty;
	}

	@Override
	public String toString() {
		return "VisitPlanBriefSummaryDto [weekPlanQty=" + weekPlanQty + ", todayPlanQty=" + todayPlanQty + "]";
	}

}
