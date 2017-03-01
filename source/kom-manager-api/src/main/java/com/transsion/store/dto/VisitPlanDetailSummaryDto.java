package com.transsion.store.dto;

import java.io.Serializable;
/**
 * @author guihua.zhang on 2017-03-01
 * */
public class VisitPlanDetailSummaryDto  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 计划巡店日期
	 * */
	private String visitPlanDate;
	
	/**
	 * 计划巡店日期巡店数
	 * */
	private int visitPlanQty;

	/**
	 * 计划巡店日期
	 * */
	public String getVisitPlanDate() {
		return visitPlanDate;
	}

	/**
	 * 计划巡店日期
	 * */
	public void setVisitPlanDate(String visitPlanDate) {
		this.visitPlanDate = visitPlanDate;
	}

	/**
	 * 计划巡店日期巡店数
	 * */
	public int getVisitPlanQty() {
		return visitPlanQty;
	}

	/**
	 * 计划巡店日期巡店数
	 * */
	public void setVisitPlanQty(int visitPlanQty) {
		this.visitPlanQty = visitPlanQty;
	}

	@Override
	public String toString() {
		return "VisitPlanDetailSummaryDto [visitPlanDate=" + visitPlanDate + ", visitPlanQty=" + visitPlanQty + "]";
	}
	
}
