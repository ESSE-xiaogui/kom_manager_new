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

import com.transsion.store.bo.VisitStock;

public class VisitStockDto implements Serializable {

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
	private java.lang.Long stockQty;

	/**
	  *	
	  */
	private java.lang.Long currentSaleQty;
	
	/**
	  *	
	  */
	private java.lang.Long targetSaleQty;
	
	
	/**
	 * avg sale per four weeks
	 */
	private java.math.BigDecimal saleAvg;

	/**
	 * Inventory turn over, STOCK_QTY/SALE_AVG
	 */
	private java.math.BigDecimal stockIto;

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
	public java.lang.Long getStockQty() {
		return stockQty;
	}

	/**
	  *	
	  */
	public void setStockQty(java.lang.Long stockQty) {
		this.stockQty = stockQty;
	}

	public java.lang.Long getCurrentSaleQty() {
		return currentSaleQty;
	}

	public void setCurrentSaleQty(java.lang.Long currentSaleQty) {
		this.currentSaleQty = currentSaleQty;
	}

	public java.lang.Long getTargetSaleQty() {
		return targetSaleQty;
	}

	public void setTargetSaleQty(java.lang.Long targetSaleQty) {
		this.targetSaleQty = targetSaleQty;
	}

	/**
	 * avg sale per four weeks
	 */
	public java.math.BigDecimal getSaleAvg() {
		return saleAvg;
	}

	/**
	 * avg sale per four weeks
	 */
	public void setSaleAvg(java.math.BigDecimal saleAvg) {
		this.saleAvg = saleAvg;
	}

	/**
	 * Inventory turn over, STOCK_QTY/SALE_AVG
	 */
	public java.math.BigDecimal getStockIto() {
		return stockIto;
	}

	/**
	 * Inventory turn over, STOCK_QTY/SALE_AVG
	 */
	public void setStockIto(java.math.BigDecimal stockIto) {
		this.stockIto = stockIto;
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
	
	public VisitStock toModel() {
		VisitStock visitStock = new VisitStock();
		visitStock.setId(this.getId());
		visitStock.setVisitId(this.getVisitId());
		visitStock.setBrandId(this.getBrandId());
		visitStock.setModelId(this.getModelId());
		visitStock.setStockQty(this.getStockQty());
		visitStock.setSaleAvg(this.getSaleAvg());
		visitStock.setStockIto(this.getStockIto());
		visitStock.setRemark(this.getRemark());
//		visitStock.setCreateBy();
//		visitStock.setCreateTime();
//		visitStock.setUpdateBy();
//		visitStock.setUpdateTime();
//		visitStock.setVersion();
		return visitStock;
	}

	@Override
	public String toString() {
		return "VisitStockDto [id=" + id + ", visitId=" + visitId + ", brandId=" + brandId + ", modelId=" + modelId
				+ ", stockQty=" + stockQty + ", saleAvg=" + saleAvg + ", stockIto=" + stockIto + ", remark=" + remark
				+ "]";
	}

}
