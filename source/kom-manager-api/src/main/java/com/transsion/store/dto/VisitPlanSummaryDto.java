package com.transsion.store.dto;

import java.io.Serializable;

public class VisitPlanSummaryDto  implements Serializable {

	private static final long serialVersionUID = 1L;

	private String visitDate;
	
	private int visitStoreQty;

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public int getVisitStoreQty() {
		return visitStoreQty;
	}

	public void setVisitStoreQty(int visitStoreQty) {
		this.visitStoreQty = visitStoreQty;
	}

	@Override
	public String toString() {
		return "VisitPlanSummaryDto [visitDate=" + visitDate + ", visitStoreQty=" + visitStoreQty + "]";
	}
	
}
