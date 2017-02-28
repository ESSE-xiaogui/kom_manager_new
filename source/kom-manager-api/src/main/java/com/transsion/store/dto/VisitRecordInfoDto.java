package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class VisitRecordInfoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * shop visit basic info(ALL)
	 */
	private VisitShopDto visitShopDto;

	/*
	 * shop visit model stock info(TECNO)
	 */
	private List<VisitStockInfoDto> VisitStockInfoDtoList;
	
	/*
	 * shop visit score summary(TECNO)
	 */
	private VisitScoreDto visitScoreDto;

	/*
	 * shop visit score info(TECNO)
	 */
	private List<VisitScoreItemInfoDto> visitScoreItemInfoDtoList;

	/*
	 * shop visit feedback info(ALL)
	 */
	private VisitFeedbackDto visitFeedbackDto;

	/*
	 * shop visit sale info(ITEL)
	 */
	private List<VisitSaleDto> visitSaleDtoList;

	/*
	 * shop visit model info(ITEL)
	 */
	private List<VisitModelDto> visitModelDtoList;

	/*
	 * shop visit materiel info(ITEL)
	 */
	private List<VisitMaterielDto> visitMaterielDtoList;

	/*
	 * shop visit competitor info(ITEL)
	 */
	private List<VisitCompetitorDto> visitCompetitorDtoList;



	public VisitShopDto getVisitShopDto() {
		return visitShopDto;
	}

	public void setVisitShopDto(VisitShopDto visitShopDto) {
		this.visitShopDto = visitShopDto;
	}
	
	public List<VisitStockInfoDto> getVisitStockInfoDtoList() {
		return VisitStockInfoDtoList;
	}

	public void setVisitStockInfoDtoList(List<VisitStockInfoDto> visitStockInfoDtoList) {
		VisitStockInfoDtoList = visitStockInfoDtoList;
	}

	public VisitScoreDto getVisitScoreDto() {
		return visitScoreDto;
	}

	public void setVisitScoreDto(VisitScoreDto visitScoreDto) {
		this.visitScoreDto = visitScoreDto;
	}


	public List<VisitScoreItemInfoDto> getVisitScoreItemInfoDtoList() {
		return visitScoreItemInfoDtoList;
	}

	public void setVisitScoreItemInfoDtoList(List<VisitScoreItemInfoDto> visitScoreItemInfoDtoList) {
		this.visitScoreItemInfoDtoList = visitScoreItemInfoDtoList;
	}

	public VisitFeedbackDto getVisitFeedbackDto() {
		return visitFeedbackDto;
	}

	public void setVisitFeedbackDto(VisitFeedbackDto visitFeedbackDto) {
		this.visitFeedbackDto = visitFeedbackDto;
	}

	public List<VisitSaleDto> getVisitSaleDtoList() {
		return visitSaleDtoList;
	}

	public void setVisitSaleDtoList(List<VisitSaleDto> visitSaleDtoList) {
		this.visitSaleDtoList = visitSaleDtoList;
	}

	public List<VisitModelDto> getVisitModelDtoList() {
		return visitModelDtoList;
	}

	public void setVisitModelDtoList(List<VisitModelDto> visitModelDtoList) {
		this.visitModelDtoList = visitModelDtoList;
	}

	public List<VisitMaterielDto> getVisitMaterielDtoList() {
		return visitMaterielDtoList;
	}

	public void setVisitMaterielDtoList(List<VisitMaterielDto> visitMaterielDtoList) {
		this.visitMaterielDtoList = visitMaterielDtoList;
	}

	public List<VisitCompetitorDto> getVisitCompetitorDtoList() {
		return visitCompetitorDtoList;
	}

	public void setVisitCompetitorDtoList(List<VisitCompetitorDto> visitCompetitorDtoList) {
		this.visitCompetitorDtoList = visitCompetitorDtoList;
	}

}
