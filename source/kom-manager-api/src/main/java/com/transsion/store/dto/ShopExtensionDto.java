/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-17 11:25:38
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
import java.util.Map;

public class ShopExtensionDto implements Serializable {

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
	private java.lang.Long shopId;

	/**
	  *	
	  */
	private java.lang.Long shopArea;

	/**
	  *	
	  */
	private java.lang.Integer clerkTotalQty;

	/**
	  *	
	  */
	private java.lang.Integer clerkBrandQty;

	/**
	  *	
	  */
	private java.lang.Long relationship;

	/**
	  *	
	  */
	private java.lang.Long bizCategory;

	/**
	  *	
	  */
	private java.lang.String supervisor;

	/**
	  *	
	  */
	private java.lang.String promoter;

	/**
	  *	
	  */
	private java.lang.Long saleTotalQty;

	/**
	  *	
	  */
	private java.lang.Long saleSpQty;

	/**
	  *	
	  */
	private java.lang.Long saleBrandQty;

	/**
	  *	
	  */
	private java.lang.Long saleBrandspQty;

	private List<Map<String, String>> brandClerkList;

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
	public java.lang.Long getShopId() {
		return shopId;
	}

	/**
	  *	
	  */
	public void setShopId(java.lang.Long shopId) {
		this.shopId = shopId;
	}

	public java.lang.Long getShopArea() {
		return shopArea;
	}

	public void setShopArea(java.lang.Long shopArea) {
		this.shopArea = shopArea;
	}

	/**
	  *	
	  */
	public java.lang.Integer getClerkTotalQty() {
		return clerkTotalQty;
	}

	/**
	  *	
	  */
	public void setClerkTotalQty(java.lang.Integer clerkTotalQty) {
		this.clerkTotalQty = clerkTotalQty;
	}

	/**
	  *	
	  */
	public java.lang.Integer getClerkBrandQty() {
		return clerkBrandQty;
	}

	/**
	  *	
	  */
	public void setClerkBrandQty(java.lang.Integer clerkBrandQty) {
		this.clerkBrandQty = clerkBrandQty;
	}

	/**
	  *	
	  */
	public java.lang.Long getRelationship() {
		return relationship;
	}

	/**
	  *	
	  */
	public void setRelationship(java.lang.Long relationship) {
		this.relationship = relationship;
	}

	/**
	  *	
	  */
	public java.lang.Long getBizCategory() {
		return bizCategory;
	}

	/**
	  *	
	  */
	public void setBizCategory(java.lang.Long bizCategory) {
		this.bizCategory = bizCategory;
	}

	
	public List<Map<String, String>> getBrandClerkList() {
		return brandClerkList;
	}

	public void setBrandClerkList(List<Map<String, String>> brandClerkList) {
		this.brandClerkList = brandClerkList;
	}

	/**
	  *	
	  */
	public java.lang.String getSupervisor() {
		return supervisor;
	}

	/**
	  *	
	  */
	public void setSupervisor(java.lang.String supervisor) {
		this.supervisor = supervisor;
	}

	/**
	  *	
	  */
	public java.lang.String getPromoter() {
		return promoter;
	}

	/**
	  *	
	  */
	public void setPromoter(java.lang.String promoter) {
		this.promoter = promoter;
	}

	/**
	  *	
	  */
	public java.lang.Long getSaleTotalQty() {
		return saleTotalQty;
	}

	/**
	  *	
	  */
	public void setSaleTotalQty(java.lang.Long saleTotalQty) {
		this.saleTotalQty = saleTotalQty;
	}

	/**
	  *	
	  */
	public java.lang.Long getSaleSpQty() {
		return saleSpQty;
	}

	/**
	  *	
	  */
	public void setSaleSpQty(java.lang.Long saleSpQty) {
		this.saleSpQty = saleSpQty;
	}

	/**
	  *	
	  */
	public java.lang.Long getSaleBrandQty() {
		return saleBrandQty;
	}

	/**
	  *	
	  */
	public void setSaleBrandQty(java.lang.Long saleBrandQty) {
		this.saleBrandQty = saleBrandQty;
	}

	/**
	  *	
	  */
	public java.lang.Long getSaleBrandspQty() {
		return saleBrandspQty;
	}

	/**
	  *	
	  */
	public void setSaleBrandspQty(java.lang.Long saleBrandspQty) {
		this.saleBrandspQty = saleBrandspQty;
	}

	@Override
	public String toString() {
		return "ShopExtensionDto [id=" + id + ", shopId=" + shopId + ", shopArea=" + shopArea + ", clerkTotalQty="
				+ clerkTotalQty + ", clerkBrandQty=" + clerkBrandQty + ", relationship=" + relationship
				+ ", bizCategory=" + bizCategory + ", supervisor=" + supervisor + ", promoter=" + promoter
				+ ", saleTotalQty=" + saleTotalQty + ", saleSpQty=" + saleSpQty + ", saleBrandQty=" + saleBrandQty
				+ ", saleBrandspQty=" + saleBrandspQty + ", brandClerkList=" + brandClerkList + "]";
	}

}
