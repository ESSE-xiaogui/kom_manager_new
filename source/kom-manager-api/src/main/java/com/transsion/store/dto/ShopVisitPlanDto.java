package com.transsion.store.dto;

import java.io.Serializable;
import java.util.Date;

public class ShopVisitPlanDto  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date visitDate;
	
	private Long shopId;
	
	private String shopName;
	
	private String cityName;
	
	private int lastMonthTimes;
	
	private int thisMonthTimes;
	
	private boolean isPlan;

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
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
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getLastMonthTimes() {
		return lastMonthTimes;
	}

	public void setLastMonthTimes(int lastMonthTimes) {
		this.lastMonthTimes = lastMonthTimes;
	}

	public int getThisMonthTimes() {
		return thisMonthTimes;
	}

	public void setThisMonthTimes(int thisMonthTimes) {
		this.thisMonthTimes = thisMonthTimes;
	}

	public boolean isPlan() {
		return isPlan;
	}

	public void setPlan(boolean isPlan) {
		this.isPlan = isPlan;
	}

	@Override
	public String toString() {
		return "ShopVisitPlanDto [visitDate=" + visitDate + ", shopId=" + shopId + ", shopName=" + shopName
				+ ", cityName=" + cityName + ", lastMonthTimes=" + lastMonthTimes + ", thisMonthTimes=" + thisMonthTimes
				+ ", isPlan=" + isPlan + "]";
	}
	
}
