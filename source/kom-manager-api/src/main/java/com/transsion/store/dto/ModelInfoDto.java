package com.transsion.store.dto;

import java.io.Serializable;

/**
 * @author guihua.zhang on 2017-03-13
 * **/
public class ModelInfoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 机型id
	 * */
	private Long modelId;
	
	/**
	 * 产品代码 Smart:智能 Feature:功能
	 * */
	private String seriesCode;
	
	/**
	 * 机型编码
	 * */
	private String modelCode;
	
	/**
	 * 机型名称
	 * */
	private String modelName;
	
	/**
	 * true:选中 false:未选中 
	 * */
	private boolean isSelected;

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public String getSeriesCode() {
		return seriesCode;
	}

	public void setSeriesCode(String seriesCode) {
		this.seriesCode = seriesCode;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	@Override
	public String toString() {
		return "ModelInfoDto [modelId=" + modelId + ", seriesCode=" + seriesCode + ", modelCode=" + modelCode
						+ ", modelName=" + modelName + ", isSelected=" + isSelected + "]";
	}

}
