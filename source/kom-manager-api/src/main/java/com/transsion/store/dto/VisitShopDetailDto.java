/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 14:48:56
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;


public class VisitShopDetailDto implements Serializable {
	private static final long serialVersionUID = 5891973057158196773L;
	
	private Integer shopScore;
	private Integer saleScore;
	private Integer staffScore;
	private Integer totalScore;
	private String issue;
	private String action;
	
	private List<VisitScoreInfoDto> visitScoreInfoList;
	
	private List<VisitModelStockDto> visitModelStockList;
	
	public Integer getShopScore() {
		return shopScore;
	}
	public void setShopScore(Integer shopScore) {
		this.shopScore = shopScore;
	}
	public Integer getSaleScore() {
		return saleScore;
	}
	public void setSaleScore(Integer saleScore) {
		this.saleScore = saleScore;
	}
	public Integer getStaffScore() {
		return staffScore;
	}
	public void setStaffScore(Integer staffScore) {
		this.staffScore = staffScore;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public List<VisitScoreInfoDto> getVisitScoreInfoList() {
		return visitScoreInfoList;
	}
	public void setVisitScoreInfoList(List<VisitScoreInfoDto> visitScoreInfoList) {
		this.visitScoreInfoList = visitScoreInfoList;
	}
	
	public List<VisitModelStockDto> getVisitModelStockList() {
		return visitModelStockList;
	}
	public void setVisitModelStockList(List<VisitModelStockDto> visitModelStockList) {
		this.visitModelStockList = visitModelStockList;
	}
	
	@Override
	public String toString() {
		return "VisitShopDetailDto [shopScore=" + shopScore + ", saleScore=" + saleScore + ", staffScore=" + staffScore
				+ ", totalScore=" + totalScore + ", issue=" + issue + ", action=" + action + ", visitScoreInfoList="
				+ visitScoreInfoList + ", visitModelStockList=" + visitModelStockList + "]";
	}
	
}

