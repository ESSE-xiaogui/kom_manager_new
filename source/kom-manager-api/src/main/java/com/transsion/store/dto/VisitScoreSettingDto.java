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
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.Long companyId;

	/**
	  *	
	  */
	private java.lang.Long type;

	/**
	  *	
	  */
	private java.lang.String descEn;

	/**
	  *	
	  */
	private java.lang.String descCn;

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
	public java.lang.Long getCompanyId() {
		return companyId;
	}

	/**
	  *	
	  */
	public void setCompanyId(java.lang.Long companyId) {
		this.companyId = companyId;
	}

	/**
	  *	
	  */
	public java.lang.Long getType() {
		return type;
	}

	/**
	  *	
	  */
	public void setType(java.lang.Long type) {
		this.type = type;
	}

	/**
	  *	
	  */
	public java.lang.String getDescEn() {
		return descEn;
	}

	/**
	  *	
	  */
	public void setDescEn(java.lang.String descEn) {
		this.descEn = descEn;
	}

	/**
	  *	
	  */
	public java.lang.String getDescCn() {
		return descCn;
	}

	/**
	  *	
	  */
	public void setDescCn(java.lang.String descCn) {
		this.descCn = descCn;
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

	@Override
	public String toString() {
		return "VisitScoreSettingDto [id=" + id + ", companyId=" + companyId + ", type=" + type + ", descEn=" + descEn
				+ ", descCn=" + descCn + ", remark=" + remark + "]";
	}

}
