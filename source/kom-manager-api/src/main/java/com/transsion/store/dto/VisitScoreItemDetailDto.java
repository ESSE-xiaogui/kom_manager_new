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


public class VisitScoreItemDetailDto implements Serializable {
	private static final long serialVersionUID = 5891973057158196773L;
	
	private String nameCn;
	private String nameEn;
	private String descCn;
	private String descEn;
	private Integer score;
	private Integer shopScore;
	private Integer saleScore;
	private Integer staffScore;
	private Integer totalScore;
	private String issue;
	private String action;
	
	public String getNameCn() {
		return nameCn;
	}
	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getDescCn() {
		return descCn;
	}
	public void setDescCn(String descCn) {
		this.descCn = descCn;
	}
	public String getDescEn() {
		return descEn;
	}
	public void setDescEn(String descEn) {
		this.descEn = descEn;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
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
	
	@Override
	public String toString() {
		return "VisitScoreItemDetailDto [nameCn=" + nameCn + ", nameEn=" + nameEn + ", descCn=" + descCn + ", descEn="
				+ descEn + ", score=" + score + ", shopScore=" + shopScore + ", saleScore=" + saleScore
				+ ", staffScore=" + staffScore + ", totalScore=" + totalScore + ", issue=" + issue + ", action="
				+ action + "]";
	}
	
}

