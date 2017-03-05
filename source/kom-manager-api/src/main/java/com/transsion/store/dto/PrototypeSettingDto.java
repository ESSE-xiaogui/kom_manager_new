package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

import com.transsion.store.bo.PrototypeSetting;
import com.transsion.store.bo.PrototypeSettingModel;
import com.transsion.store.bo.PrototypeSettingRegion;
import com.transsion.store.bo.PrototypeSettingTime;

public class PrototypeSettingDto extends PrototypeSetting implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String companyName;		// 事业部名称
	private String modelName;		// 机型
	private String countryId;		// 国家ID
	private String brandId;			// 品牌ID
	private String countDates;		// 时间列表 逗好隔开
	
	private List<Long> modelIds;	// 机型list
	private List<Long> regionIds;	// 国家List
	
	private List<PrototypeSettingModel> prototypeSettingModels;			// 盘点计划机型列表
	private List<PrototypeSettingRegion> prototypeSettingRegions;		// 盘点计划国家列表
	private List<PrototypeSettingTime> prototypeSettingTimes;			// 盘点计划时间列表
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	
	public String getCountDates() {
		return countDates;
	}
	public void setCountDates(String countDates) {
		this.countDates = countDates;
	}

	public List<Long> getModelIds() {
		return modelIds;
	}
	public void setModelIds(List<Long> modelIds) {
		this.modelIds = modelIds;
	}
	public List<Long> getRegionIds() {
		return regionIds;
	}
	public void setRegionIds(List<Long> regionIds) {
		this.regionIds = regionIds;
	}
	public List<PrototypeSettingModel> getPrototypeSettingModels() {
		return prototypeSettingModels;
	}
	public void setPrototypeSettingModels(List<PrototypeSettingModel> prototypeSettingModels) {
		this.prototypeSettingModels = prototypeSettingModels;
	}
	
	public List<PrototypeSettingRegion> getPrototypeSettingRegions() {
		return prototypeSettingRegions;
	}
	public void setPrototypeSettingRegions(List<PrototypeSettingRegion> prototypeSettingRegions) {
		this.prototypeSettingRegions = prototypeSettingRegions;
	}
	
	public List<PrototypeSettingTime> getPrototypeSettingTimes() {
		return prototypeSettingTimes;
	}
	public void setPrototypeSettingTimes(List<PrototypeSettingTime> prototypeSettingTimes) {
		this.prototypeSettingTimes = prototypeSettingTimes;
	}
}
