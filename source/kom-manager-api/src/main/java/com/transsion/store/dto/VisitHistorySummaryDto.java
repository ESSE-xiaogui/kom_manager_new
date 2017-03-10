package com.transsion.store.dto;

import java.io.Serializable;

public class VisitHistorySummaryDto  implements Serializable {

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((visitDate == null) ? 0 : visitDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisitHistorySummaryDto other = (VisitHistorySummaryDto) obj;
		if (visitDate == null) {
			if (other.visitDate != null)
				return false;
		} else if (!visitDate.equals(other.visitDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisitHistorySummaryDto [visitDate=" + visitDate + ", visitStoreQty=" + visitStoreQty + "]";
	}
	
}
