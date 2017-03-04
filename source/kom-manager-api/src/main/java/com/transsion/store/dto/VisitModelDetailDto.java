package com.transsion.store.dto;

import java.io.Serializable;

public class VisitModelDetailDto implements Serializable {
	private static final long serialVersionUID = 1799165623786457391L;
	
	private String seriesCode;
	private String modelCode;
	
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
	
	
}
