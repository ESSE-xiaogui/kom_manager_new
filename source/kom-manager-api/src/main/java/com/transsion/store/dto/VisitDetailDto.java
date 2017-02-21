package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

import com.transsion.store.bo.Visit;
import com.transsion.store.bo.VisitCompetitor;
import com.transsion.store.bo.VisitFeedback;
import com.transsion.store.bo.VisitMateriel;
import com.transsion.store.bo.VisitModel;
import com.transsion.store.bo.VisitSale;
import com.transsion.store.bo.VisitScore;
import com.transsion.store.bo.VisitScoreItem;
import com.transsion.store.bo.VisitStock;

public class VisitDetailDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * shop visit basic info(ALL)
	 */
	private Visit visit;

	/*
	 * shop visit model stock info(TECNO)
	 */
	private List<VisitStock> visitStockList;

	/*
	 * shop visit score info(TECNO)
	 */
	private VisitScore visitScore;

	/*
	 * shop visit score info(TECNO)
	 */
	private List<VisitScoreItem> visitScoreItemList;

	/*
	 * shop visit feedback info(ALL)
	 */
	private VisitFeedback visitFeedback;

	/*
	 * shop visit sale info(ITEL)
	 */
	private List<VisitSale> visitSaleList;

	/*
	 * shop visit model info(ITEL)
	 */
	private List<VisitModel> visitModelList;

	/*
	 * shop visit materiel info(ITEL)
	 */
	private List<VisitMateriel> visitMaterielList;

	/*
	 * shop visit competitor info(ITEL)
	 */
	private List<VisitCompetitor> visitCompetitorList;

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public List<VisitStock> getVisitStockList() {
		return visitStockList;
	}

	public void setVisitStockList(List<VisitStock> visitStockList) {
		this.visitStockList = visitStockList;
	}

	public VisitScore getVisitScore() {
		return visitScore;
	}

	public void setVisitScore(VisitScore visitScore) {
		this.visitScore = visitScore;
	}

	public List<VisitScoreItem> getVisitScoreItemList() {
		return visitScoreItemList;
	}

	public void setVisitScoreItemList(List<VisitScoreItem> visitScoreItemList) {
		this.visitScoreItemList = visitScoreItemList;
	}

	public VisitFeedback getVisitFeedback() {
		return visitFeedback;
	}

	public void setVisitFeedback(VisitFeedback visitFeedback) {
		this.visitFeedback = visitFeedback;
	}

	public List<VisitSale> getVisitSaleList() {
		return visitSaleList;
	}

	public void setVisitSaleList(List<VisitSale> visitSaleList) {
		this.visitSaleList = visitSaleList;
	}

	public List<VisitModel> getVisitModelList() {
		return visitModelList;
	}

	public void setVisitModelList(List<VisitModel> visitModelList) {
		this.visitModelList = visitModelList;
	}

	public List<VisitMateriel> getVisitMaterielList() {
		return visitMaterielList;
	}

	public void setVisitMaterielList(List<VisitMateriel> visitMaterielList) {
		this.visitMaterielList = visitMaterielList;
	}

	public List<VisitCompetitor> getVisitCompetitorList() {
		return visitCompetitorList;
	}

	public void setVisitCompetitorList(List<VisitCompetitor> visitCompetitorList) {
		this.visitCompetitorList = visitCompetitorList;
	}

}
