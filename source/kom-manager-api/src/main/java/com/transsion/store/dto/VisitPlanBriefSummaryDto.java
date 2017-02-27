package com.transsion.store.dto;

import java.io.Serializable;

public class VisitPlanBriefSummaryDto  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int weekPlanQty;
	
	private int todayPlanQty;

	public int getWeekPlanQty() {
		return weekPlanQty;
	}

	public void setWeekPlanQty(int weekPlanQty) {
		this.weekPlanQty = weekPlanQty;
	}

	public int getTodayPlanQty() {
		return todayPlanQty;
	}

	public void setTodayPlanQty(int todayPlanQty) {
		this.todayPlanQty = todayPlanQty;
	}

	@Override
	public String toString() {
		return "VisitPlanBriefSummaryDto [weekPlanQty=" + weekPlanQty + ", todayPlanQty=" + todayPlanQty + "]";
	}

}
