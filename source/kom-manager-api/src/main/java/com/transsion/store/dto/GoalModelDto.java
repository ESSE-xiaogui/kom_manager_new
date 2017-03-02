package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class GoalModelDto implements Serializable{

	private static final long serialVersionUID = 1388253998087474429L;
	
	private Long shopId;
	private String goalMonth;
	private List<String> modelCodeList;
	
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public String getGoalMonth() {
		return goalMonth;
	}
	public void setGoalMonth(String goalMonth) {
		this.goalMonth = goalMonth;
	}
	public List<String> getModelCodeList() {
		return modelCodeList;
	}
	public void setModelCodeList(List<String> modelCodeList) {
		this.modelCodeList = modelCodeList;
	}
	
	@Override
	public String toString() {
		return "GoalModelDto [shopId=" + shopId + ", goalMonth=" + goalMonth + ", modelCodeList=" + modelCodeList + "]";
	}
	
}
