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
	private Long brandId;				// 品牌ID
	private Long modelId;				// 机型ID
	private String beginSaleTime;		// 开始日期
	private String endSaleTime;			// 结束日期
	private Long regionId;				// 区域ID
	private String regionType;			// 区域类型 2:国家 3： 4：城市
	
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
	
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public Long getModelId() {
		return modelId;
	}
	public void setModelId(Long modelId) {
		this.modelId = modelId;
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
	
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	
	public String getRegionType() {
		return regionType;
	}
	public void setRegionType(String regionType) {
		this.regionType = regionType;
	}
}