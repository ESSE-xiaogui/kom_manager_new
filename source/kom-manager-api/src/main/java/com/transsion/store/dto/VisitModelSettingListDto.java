package com.transsion.store.dto;

import java.io.Serializable;

public class VisitModelSettingListDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 重点机型设置Id
	 * */
	private Long visitModelSettingId;
	
	/**
	 * 机型Id
	 * */
	private Long modelId;
	
	/**
	 * 机型名称
	 * */
	private String modelName;

	public Long getVisitModelSettingId() {
		return visitModelSettingId;
	}

	public void setVisitModelSettingId(Long visitModelSettingId) {
		this.visitModelSettingId = visitModelSettingId;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	@Override
	public String toString() {
		return "VisitModelSettingListDto [visitModelSettingId=" + visitModelSettingId + ", modelId=" + modelId
						+ ", modelName=" + modelName + "]";
	}

}
