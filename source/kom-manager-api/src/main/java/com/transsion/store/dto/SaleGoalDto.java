package com.transsion.store.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaleGoalDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private BigDecimal goalQty;

	public BigDecimal getGoalQty() {
		return goalQty;
	}

	public void setGoalQty(BigDecimal goalQty) {
		this.goalQty = goalQty;
	}

	@Override
	public String toString() {
		return "SaleGoalDto [goalQty=" + goalQty + "]";
	}
	
}
