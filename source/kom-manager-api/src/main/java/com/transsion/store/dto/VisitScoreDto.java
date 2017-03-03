/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 10:24:48
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.dto;

import java.io.Serializable;

import com.transsion.store.bo.VisitScore;

public class VisitScoreDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	  *	visit score id
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.Long visitId;

	/**
	  *	
	  */
	private java.math.BigDecimal shopScore;

	/**
	  *	
	  */
	private java.math.BigDecimal saleScore;

	/**
	  *	
	  */
	private java.math.BigDecimal staffScore;

	/**
	  *	
	  */
	private java.math.BigDecimal totalScore;

	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	
	  */
	public java.lang.Long getId() {
		return id;
	}

	/**
	  *	
	  */
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	/**
	  *	
	  */
	public java.lang.Long getVisitId() {
		return visitId;
	}

	/**
	  *	
	  */
	public void setVisitId(java.lang.Long visitId) {
		this.visitId = visitId;
	}

	/**
	  *	
	  */
	public java.math.BigDecimal getShopScore() {
		return shopScore;
	}

	/**
	  *	
	  */
	public void setShopScore(java.math.BigDecimal shopScore) {
		this.shopScore = shopScore;
	}

	/**
	  *	
	  */
	public java.math.BigDecimal getSaleScore() {
		return saleScore;
	}

	/**
	  *	
	  */
	public void setSaleScore(java.math.BigDecimal saleScore) {
		this.saleScore = saleScore;
	}

	/**
	  *	
	  */
	public java.math.BigDecimal getStaffScore() {
		return staffScore;
	}

	/**
	  *	
	  */
	public void setStaffScore(java.math.BigDecimal staffScore) {
		this.staffScore = staffScore;
	}

	/**
	  *	
	  */
	public java.math.BigDecimal getTotalScore() {
		return totalScore;
	}

	/**
	  *	
	  */
	public void setTotalScore(java.math.BigDecimal totalScore) {
		this.totalScore = totalScore;
	}

	/**
	  *	
	  */
	public java.lang.String getRemark() {
		return remark;
	}

	/**
	  *	
	  */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	
	public VisitScore toModel() {
		VisitScore visitScore = new VisitScore();
		visitScore.setId(this.getId());
		visitScore.setVisitId(this.getVisitId());
		visitScore.setShopScore(this.getShopScore());
		visitScore.setSaleScore(this.getSaleScore());
		visitScore.setStaffScore(this.getStaffScore());
		visitScore.setTotalScore(this.getTotalScore());
		visitScore.setRemark(this.getRemark());
//		visitScore.setCreateBy();
//		visitScore.setCreateTime();
//		visitScore.setUpdateBy();
//		visitScore.setUpdateTime();
//		visitScore.setVersion();
		return visitScore;
	}

	@Override
	public String toString() {
		return "VisitScoreDto [id=" + id + ", visitId=" + visitId + ", shopScore=" + shopScore + ", saleScore="
				+ saleScore + ", staffScore=" + staffScore + ", totalScore=" + totalScore + ", remark=" + remark + "]";
	}

}
