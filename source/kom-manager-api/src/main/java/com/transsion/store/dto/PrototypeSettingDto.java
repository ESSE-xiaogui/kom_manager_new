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
	private String createName;		// 创建人
	private String updateName;		// 修改人
	private String modelName;		// 机型
	private String countryId;		// 国家ID
	private String brandId;			// 品牌ID
	
	private List<PrototypeSettingModel> prototypeSettingModels;			// 盘点计划机型列表
	private List<PrototypeSettingRegion> prototypeSettingRegions;		// 盘点计划国家列表
	private List<PrototypeSettingTime> prototypeSettingTimes;			// 盘点计划时间列表
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
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
