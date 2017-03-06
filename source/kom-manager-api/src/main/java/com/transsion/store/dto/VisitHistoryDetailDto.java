package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class VisitHistoryDetailDto implements Serializable {
	private static final long serialVersionUID = 4773339162355387872L;
	
	private Integer salePbQty;
	
	// 问题描述
	private String issue;
	
	// 上柜机型列表
	private List<VisitModelDetailDto> visitModelDetailDtoList;
	
	// itel销量列表
	private List<VisitSaleDetailDto> visitSaleDetailDtoList;
	
	// 竞品销量列表
	private List<VisitCompetitorInfoDto> visitCompetitorInfoDtoList;
	
	// 物料信息列表
	private List<VisitMaterielDetailDto> visitMaterielDetailDtoList;

	public Integer getSalePbQty() {
		return salePbQty;
	}

	public void setSalePbQty(Integer salePbQty) {
		this.salePbQty = salePbQty;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public List<VisitModelDetailDto> getVisitModelDetailDtoList() {
		return visitModelDetailDtoList;
	}

	public void setVisitModelDetailDtoList(List<VisitModelDetailDto> visitModelDetailDtoList) {
		this.visitModelDetailDtoList = visitModelDetailDtoList;
	}

	public List<VisitSaleDetailDto> getVisitSaleDetailDtoList() {
		return visitSaleDetailDtoList;
	}

	public void setVisitSaleDetailDtoList(List<VisitSaleDetailDto> visitSaleDetailDtoList) {
		this.visitSaleDetailDtoList = visitSaleDetailDtoList;
	}

	public List<VisitCompetitorInfoDto> getVisitCompetitorInfoDtoList() {
		return visitCompetitorInfoDtoList;
	}

	public void setVisitCompetitorInfoDtoList(List<VisitCompetitorInfoDto> visitCompetitorInfoDtoList) {
		this.visitCompetitorInfoDtoList = visitCompetitorInfoDtoList;
	}

	public List<VisitMaterielDetailDto> getVisitMaterielDetailDtoList() {
		return visitMaterielDetailDtoList;
	}

	public void setVisitMaterielDetailDtoList(List<VisitMaterielDetailDto> visitMaterielDetailDtoList) {
		this.visitMaterielDetailDtoList = visitMaterielDetailDtoList;
	}

	@Override
	public String toString() {
		return "VisitHistoryDetailDto [salePbQty=" + salePbQty + ", issue=" + issue + ", visitModelDetailDtoList="
				+ visitModelDetailDtoList + ", visitSaleDetailDtoList=" + visitSaleDetailDtoList
				+ ", visitCompetitorInfoDtoList=" + visitCompetitorInfoDtoList + ", visitMaterielDetailDtoList="
				+ visitMaterielDetailDtoList + "]";
	}
	
}
