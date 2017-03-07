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

public class VisitScoreSettingDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	  *	
	  */
	private Long id;

	/**
	  *	事业部Id
	  */
	private Long companyId;

	/**
	  *	
	  */
	private Long type;
	
	/**
	 * 1.门店形象 2.业务技能 3.人员形象
	 * */
	private Long sqe;

	/**
	  *	 英文描述
	  */
	private String descEn;

	/**
	  *	中文描述
	  */
	private String descCn;

	/**
	  *	
	  */
	private String remark;

	/**
	  *	
	  */
	public Long getId() {
		return id;
	}

	/**
	  *	
	  */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	  *	
	  */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	  *	
	  */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	  *	
	  */
	public Long getType() {
		return type;
	}

	public Long getSqe() {
		return sqe;
	}

	public void setSqe(Long sqe) {
		this.sqe = sqe;
	}

	/**
	  *	
	  */
	public void setType(Long type) {
		this.type = type;
	}

	/**
	  *	
	  */
	public String getDescEn() {
		return descEn;
	}

	/**
	  *	
	  */
	public void setDescEn(String descEn) {
		this.descEn = descEn;
	}

	/**
	  *	
	  */
	public String getDescCn() {
		return descCn;
	}

	/**
	  *	
	  */
	public void setDescCn(String descCn) {
		this.descCn = descCn;
	}

	/**
	  *	
	  */
	public String getRemark() {
		return remark;
	}

	/**
	  *	
	  */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "VisitScoreSettingDto [id=" + id + ", companyId=" + companyId + ", type=" + type + ", sqe=" + sqe
						+ ", descEn=" + descEn + ", descCn=" + descCn + ", remark=" + remark + "]";
	}
}
