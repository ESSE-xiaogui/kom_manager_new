package com.transsion.store.dto;

import java.io.Serializable;

import com.transsion.store.bo.ReportSaleDaily;

public class ReportSaleDailyDto extends ReportSaleDaily implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long grandId;				// 门面等级ID
	private String gradeName;			// 门店等级
	private String beginSaleTime;		// 开始日期
	private String endSaleTime;			// 结束日期
	
	public Long getGrandId() {
		return grandId;
	}
	public void setGrandId(Long grandId) {
		this.grandId = grandId;
	}
	
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
	public String getBeginSaleTime() {
		return beginSaleTime;
	}
	public void setBeginSaleTime(String beginSaleTime) {
		this.beginSaleTime = beginSaleTime;
	}
	
	public String getEndSaleTime() {
		return endSaleTime;
	}
	public void setEndSaleTime(String endSaleTime) {
		this.endSaleTime = endSaleTime;
	}
}