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

public class VisitSaleDto implements Serializable {

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
	private java.lang.Long visitId;

	/**
	  *	
	  */
	private java.lang.Long brandId;

	/**
	  *	
	  */
	private java.lang.Long modelId;

	/**
	  *	
	  */
	private java.lang.Long saleQty;

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
	public java.lang.Long getBrandId() {
		return brandId;
	}

	/**
	  *	
	  */
	public void setBrandId(java.lang.Long brandId) {
		this.brandId = brandId;
	}

	/**
	  *	
	  */
	public java.lang.Long getModelId() {
		return modelId;
	}

	/**
	  *	
	  */
	public void setModelId(java.lang.Long modelId) {
		this.modelId = modelId;
	}

	/**
	  *	
	  */
	public java.lang.Long getSaleQty() {
		return saleQty;
	}

	/**
	  *	
	  */
	public void setSaleQty(java.lang.Long saleQty) {
		this.saleQty = saleQty;
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
		return "VisitSaleDto [id=" + id + ", visitId=" + visitId + ", brandId=" + brandId + ", modelId=" + modelId
				+ ", saleQty=" + saleQty + ", remark=" + remark + "]";
	}

}
