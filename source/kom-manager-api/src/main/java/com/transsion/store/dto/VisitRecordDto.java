package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

public class VisitRecordDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * shop visit basic info(ALL)
	 */
	private VisitDto visitDto;

	/*
	 * shop visit model stock info(TECNO)
	 */
	private List<VisitStockDto> visitStockDtoList;
	
	/*
	 * shop visit score summary(TECNO)
	 */
	private VisitScoreDto visitScoreDto;

	/*
	 * shop visit score info(TECNO)
	 */
	private List<VisitScoreItemDto> visitScoreItemDtoList;

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

	public VisitDto getVisitDto() {
		return visitDto;
	}

	public void setVisitDto(VisitDto visitDto) {
		this.visitDto = visitDto;
	}

	public List<VisitStockDto> getVisitStockDtoList() {
		return visitStockDtoList;
	}

	public void setVisitStockDtoList(List<VisitStockDto> visitStockDtoList) {
		this.visitStockDtoList = visitStockDtoList;
	}
	
	public VisitScoreDto getVisitScoreDto() {
		return visitScoreDto;
	}

	public void setVisitScoreDto(VisitScoreDto visitScoreDto) {
		this.visitScoreDto = visitScoreDto;
	}

	public List<VisitScoreItemDto> getVisitScoreItemDtoList() {
		return visitScoreItemDtoList;
	}

	public void setVisitScoreItemDtoList(List<VisitScoreItemDto> visitScoreItemDtoList) {
		this.visitScoreItemDtoList = visitScoreItemDtoList;
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
