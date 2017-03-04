package com.transsion.store.dto;

import java.io.Serializable;

public class VisitScoreInfoDto implements Serializable{
	private static final long serialVersionUID = 4659658164094380620L;
	
	private Integer type;
	private String descCn;
	private String descEn;
	private Integer score;
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	
	@Override
	public String toString() {
		return "VisitScoreInfoDto [type=" + type + ", descCn=" + descCn + ", descEn=" + descEn + ", score=" + score
				+ "]";
	}
}	
