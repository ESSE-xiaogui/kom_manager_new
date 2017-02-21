package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;


/*
 * VisitDefinitionDto info
 */
public class VisitSettingDto implements Serializable {
	
	private List<VisitModelSettingDto> visitModelSettingDtoList;
	
	private List<VisitScoreSettingDto> visitScoreSettingDtoList;

	public List<VisitModelSettingDto> getVisitModelSettingDtoList() {
		return visitModelSettingDtoList;
	}

	public void setVisitModelSettingDtoList(List<VisitModelSettingDto> visitModelSettingDtoList) {
		this.visitModelSettingDtoList = visitModelSettingDtoList;
	}

	public List<VisitScoreSettingDto> getVisitScoreSettingDtoList() {
		return visitScoreSettingDtoList;
	}

	public void setVisitScoreSettingDtoList(List<VisitScoreSettingDto> visitScoreSettingDtoList) {
		this.visitScoreSettingDtoList = visitScoreSettingDtoList;
	}

}