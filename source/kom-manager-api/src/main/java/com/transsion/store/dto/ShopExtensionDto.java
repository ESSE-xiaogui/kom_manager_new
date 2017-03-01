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

import com.transsion.store.bo.ShopExtension;

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

	private List<ShopExtBrandDto> brandClerkList;
	
	private java.lang.String relationshipName;
	
	private java.lang.String bizCategoryName;
	
	public ShopExtensionDto()
	{
		
	}
	
	public ShopExtensionDto(ShopExtension model)
	{
		this.id = model.getId();
		this.shopId = model.getShopId();
		this.shopArea = model.getShopArea();
		this.clerkTotalQty = model.getClerkTotalQty();
		this.clerkBrandQty = model.getClerkBrandQty();
		this.relationship = model.getRelationship();
		this.bizCategory = model.getBizCategory();
		this.supervisor = model.getSupervisor();
		this.promoter = model.getPromoter();
		this.saleTotalQty = model.getSaleTotalQty();
		this.saleSpQty = model.getSaleSpQty();
		this.saleBrandQty = model.getSaleBrandQty();
		this.saleBrandspQty = model.getSaleBrandspQty();
		this.relationshipName = model.getRelationshipName();
		this.bizCategoryName = model.getBizCategoryName();
		
		ShopExtBrandDto shopExtBrandDto = new ShopExtBrandDto();
		shopExtBrandDto.setBrandName(model.getBrandOne());
		shopExtBrandDto.setBrandQty(model.getClerkOneQty());
		shopExtBrandDto.setBrandName(model.getBrandTwo());
		shopExtBrandDto.setBrandQty(model.getClerkTwoQty());
		shopExtBrandDto.setBrandName(model.getBrandThree());
		shopExtBrandDto.setBrandQty(model.getClerkThreeQty());
		shopExtBrandDto.setBrandName(model.getBrandFour());
		shopExtBrandDto.setBrandQty(model.getClerkFourQty());
		shopExtBrandDto.setBrandName(model.getBrandFive());
		shopExtBrandDto.setBrandQty(model.getClerkFiveQty());
		shopExtBrandDto.setBrandName(model.getBrandSix());
		shopExtBrandDto.setBrandQty(model.getClerkSixQty());
		this.brandClerkList.add(shopExtBrandDto);
	}

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

	
	public List<ShopExtBrandDto> getBrandClerkList() {
		return brandClerkList;
	}

	public void setBrandClerkList(List<ShopExtBrandDto> brandClerkList) {
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
	
	public java.lang.String getRelationshipName() {
		return relationshipName;
	}

	public void setRelationshipName(java.lang.String relationshipName) {
		this.relationshipName = relationshipName;
	}

	public java.lang.String getBizCategoryName() {
		return bizCategoryName;
	}

	public void setBizCategoryName(java.lang.String bizCategoryName) {
		this.bizCategoryName = bizCategoryName;
	}

	public ShopExtension toModel()
	{
		ShopExtension shopExtension = new ShopExtension();
		shopExtension.setId(this.getId());
		shopExtension.setShopId(this.getId());
		shopExtension.setShopArea(this.getShopArea());
		shopExtension.setClerkTotalQty(this.getClerkTotalQty());
		shopExtension.setClerkBrandQty(this.getClerkBrandQty());
		shopExtension.setRelationship(this.getRelationship());
		shopExtension.setBizCategory(this.getBizCategory());
		shopExtension.setSupervisor(this.getSupervisor());
		shopExtension.setPromoter(this.getPromoter());
		shopExtension.setSaleTotalQty(this.getSaleTotalQty());
		shopExtension.setSaleSpQty(this.getSaleSpQty()); 
		shopExtension.setSaleBrandQty(this.getSaleBrandQty());
		shopExtension.setSaleBrandspQty(this.getSaleBrandspQty());
		shopExtension.setRelationshipName(this.relationshipName);
		shopExtension.setBizCategoryName(this.bizCategoryName);
		
		if(brandClerkList != null &&brandClerkList.size()>0)
		{
			shopExtension.setBrandOne(brandClerkList.get(0).getBrandName());
			shopExtension.setClerkOneQty(brandClerkList.get(0).getBrandQty());
		}
		if(brandClerkList != null && brandClerkList.size()>1)
		{
			shopExtension.setBrandTwo(brandClerkList.get(1).getBrandName());
			shopExtension.setClerkTwoQty(brandClerkList.get(1).getBrandQty());
		}
		if(brandClerkList != null && brandClerkList.size()>2)
		{
			shopExtension.setBrandThree(brandClerkList.get(2).getBrandName());
			shopExtension.setClerkThreeQty(brandClerkList.get(2).getBrandQty());
		}
		if(brandClerkList != null && brandClerkList.size()>3)
		{
			shopExtension.setBrandFour(brandClerkList.get(3).getBrandName());
			shopExtension.setClerkFourQty(brandClerkList.get(3).getBrandQty());
		}
		if(brandClerkList != null && brandClerkList.size()>4)
		{
			shopExtension.setBrandFive(brandClerkList.get(4).getBrandName());
			shopExtension.setClerkFiveQty(brandClerkList.get(4).getBrandQty());
		}
		if(brandClerkList != null && brandClerkList.size()>5)
		{
			shopExtension.setBrandSix(brandClerkList.get(5).getBrandName());
			shopExtension.setClerkSixQty(brandClerkList.get(5).getBrandQty());
		}
		return shopExtension;
	}

	@Override
	public String toString() {
		return "ShopExtensionDto [id=" + id + ", shopId=" + shopId + ", shopArea=" + shopArea + ", clerkTotalQty="
				+ clerkTotalQty + ", clerkBrandQty=" + clerkBrandQty + ", relationship=" + relationship
				+ ", bizCategory=" + bizCategory + ", supervisor=" + supervisor + ", promoter=" + promoter
				+ ", saleTotalQty=" + saleTotalQty + ", saleSpQty=" + saleSpQty + ", saleBrandQty=" + saleBrandQty
				+ ", saleBrandspQty=" + saleBrandspQty + ", brandClerkList=" + brandClerkList + ", relationshipName="
				+ relationshipName + ", bizCategoryName=" + bizCategoryName + "]";
	}

}
