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

import com.transsion.store.bo.VisitFeedback;

public class VisitFeedbackDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	  *	visit feedback id
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.Long visitId;

	/**
	  *	
	  */
	private java.lang.String issue;

	/**
	  *	
	  */
	private java.lang.String action;

	/**
	  *	
	  */
	private java.lang.String imgFirstUrl;

	/**
	  *	
	  */
	private java.lang.String imgSecondUrl;

	/**
	  *	
	  */
	private java.lang.String imgThirdUrl;

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
	public java.lang.String getIssue() {
		return issue;
	}

	/**
	  *	
	  */
	public void setIssue(java.lang.String issue) {
		this.issue = issue;
	}

	/**
	  *	
	  */
	public java.lang.String getAction() {
		return action;
	}

	/**
	  *	
	  */
	public void setAction(java.lang.String action) {
		this.action = action;
	}

	/**
	  *	
	  */
	public java.lang.String getImgFirstUrl() {
		return imgFirstUrl;
	}

	/**
	  *	
	  */
	public void setImgFirstUrl(java.lang.String imgFirstUrl) {
		this.imgFirstUrl = imgFirstUrl;
	}

	/**
	  *	
	  */
	public java.lang.String getImgSecondUrl() {
		return imgSecondUrl;
	}

	/**
	  *	
	  */
	public void setImgSecondUrl(java.lang.String imgSecondUrl) {
		this.imgSecondUrl = imgSecondUrl;
	}

	/**
	  *	
	  */
	public java.lang.String getImgThirdUrl() {
		return imgThirdUrl;
	}

	/**
	  *	
	  */
	public void setImgThirdUrl(java.lang.String imgThirdUrl) {
		this.imgThirdUrl = imgThirdUrl;
	}
	
	public VisitFeedback toModel() {
		VisitFeedback visitFeedback = new VisitFeedback();
		visitFeedback.setId(this.getId());
		visitFeedback.setVisitId(this.getVisitId());
		visitFeedback.setIssue(this.getIssue());
		visitFeedback.setAction(this.getAction());
		visitFeedback.setImgFirstUrl(this.getImgFirstUrl());
		visitFeedback.setImgSecondUrl(this.getImgSecondUrl());
		visitFeedback.setImgThirdUrl(this.getImgThirdUrl());
//		visitFeedback.setRemark();
//		visitFeedback.setCreateBy();
//		visitFeedback.setCreateTime();
//		visitFeedback.setUpdateBy();
//		visitFeedback.setUpdateTime();
//		visitFeedback.setVersion();
		return visitFeedback;
	}

	@Override
	public String toString() {
		return "VisitFeedbackDto [id=" + id + ", visitId=" + visitId + ", issue=" + issue + ", action=" + action
				+ ", imgFirstUrl=" + imgFirstUrl + ", imgSecondUrl=" + imgSecondUrl + ", imgThirdUrl=" + imgThirdUrl
				+ "]";
	}

}
