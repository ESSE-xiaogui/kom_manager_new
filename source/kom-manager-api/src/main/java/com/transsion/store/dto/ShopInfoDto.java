package com.transsion.store.dto;

import java.io.Serializable;

import com.transsion.store.bo.Shop;
import com.transsion.store.bo.ShopExtension;

/*
	  *	dto use for creating shop by web 
 */
public class ShopInfoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	
	private java.lang.String countryName;
	
	private java.lang.String cityName;
	
	private java.lang.String regionName;
	
	private String companyCode;
	
	private String gradeName;
	
	private String bizName;
	
	private java.lang.String createDateStart;
	
	private java.lang.String createDateEnd;
	
	private java.lang.String updateDateStart;
	
	private java.lang.String updateDateEnd;
	
	/**
	  *	keep for align with kom pc
	  */
	private java.lang.Long shopId;

	/**
	  *	生成方式：国家简称加六位数的序号。
	  */
	private java.lang.String shopCode;

	/**
	  *	
	  */
	private java.lang.String shopName;

	/**
	  *	
	  */
	private java.lang.Integer companyId;

	/**
	  *	
	  */
	private java.lang.Long parentId;

	/**
	  *	
	  */
	private java.lang.Long regionId;

	/**
	  *	
	  */
	private java.lang.Integer country;

	/**
	  *	根据督导所属国家选择城市列表
	  */
	private java.lang.Integer city;

	/**
	  *	
	  */
	private java.lang.String shopIcon;

	/**
	  *	
	  */
	private java.lang.String address;
	
	/**
	  *	
	  */
	private java.lang.Long gradeId;

	/**
	  *	
	  */
	private java.lang.Long bizId;

	/**
	  *	
	  */
	private java.lang.String ownerName;

	/**
	  *	
	  */
	private java.lang.String ownerPhone;

	/**
	  *	
	  */
	private java.lang.String purchasChannel;
	
	/**
	  *	信息上传当天的北京时间
	  */
	private java.lang.String openDate;

	/**
	  *	审核状态 0:(默认)待审核 1:通过 2:未通过 3:再次申请
	  */
	private java.lang.Integer status;

	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	Table User ID
	  */
	private java.lang.String createBy;

	/**
	  *	
	  */
	private java.lang.String createDate;

	/**
	  *	
	  */
	private java.lang.String updateBy;

	/**
	  *	
	  */
	private java.lang.String updateDate;

	/**
	  *	
	  */
	private java.lang.Integer version;
	
	private ShopExtension shopExtension;
	

//---------------------------------------------------------------
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
	
	private java.lang.String relationshipName;

	/**
	  *	
	  */
	private java.lang.Long bizCategory;
	
	private java.lang.String bizCategoryName;

	/**
	  *	
	  */
	private java.lang.String brandOne;

	/**
	  *	
	  */
	private java.lang.String brandTwo;

	/**
	  *	
	  */
	private java.lang.String brandThree;

	/**
	  *	
	  */
	private java.lang.String brandFour;

	/**
	  *	
	  */
	private java.lang.String brandFive;

	/**
	  *	
	  */
	private java.lang.String brandSix;

	/**
	  *	
	  */
	private java.lang.Integer clerkOneQty;

	/**
	  *	
	  */
	private java.lang.Integer clerkTwoQty;

	/**
	  *	
	  */
	private java.lang.Integer clerkThreeQty;

	/**
	  *	
	  */
	private java.lang.Integer clerkFourQty;

	/**
	  *	
	  */
	private java.lang.Integer clerkFiveQty;

	/**
	  *	
	  */
	private java.lang.Integer clerkSixQty;

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

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public java.lang.Long getShopId() {
		return shopId;
	}

	public void setShopId(java.lang.Long shopId) {
		this.shopId = shopId;
	}

	public java.lang.String getShopCode() {
		return shopCode;
	}

	public void setShopCode(java.lang.String shopCode) {
		this.shopCode = shopCode;
	}

	public java.lang.String getShopName() {
		return shopName;
	}

	public void setShopName(java.lang.String shopName) {
		this.shopName = shopName;
	}

	public java.lang.Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}

	public java.lang.Long getParentId() {
		return parentId;
	}

	public void setParentId(java.lang.Long parentId) {
		this.parentId = parentId;
	}

	public java.lang.Long getRegionId() {
		return regionId;
	}

	public void setRegionId(java.lang.Long regionId) {
		this.regionId = regionId;
	}

	public java.lang.Integer getCountry() {
		return country;
	}

	public void setCountry(java.lang.Integer country) {
		this.country = country;
	}

	public java.lang.Integer getCity() {
		return city;
	}

	public void setCity(java.lang.Integer city) {
		this.city = city;
	}

	public java.lang.String getShopIcon() {
		return shopIcon;
	}

	public void setShopIcon(java.lang.String shopIcon) {
		this.shopIcon = shopIcon;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(java.lang.Long gradeId) {
		this.gradeId = gradeId;
	}

	public java.lang.Long getBizId() {
		return bizId;
	}

	public void setBizId(java.lang.Long bizId) {
		this.bizId = bizId;
	}

	public java.lang.String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(java.lang.String ownerName) {
		this.ownerName = ownerName;
	}

	public java.lang.String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(java.lang.String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public java.lang.String getPurchasChannel() {
		return purchasChannel;
	}

	public void setPurchasChannel(java.lang.String purchasChannel) {
		this.purchasChannel = purchasChannel;
	}

	public java.lang.String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(java.lang.String openDate) {
		this.openDate = openDate;
	}

	public java.lang.Integer getStatus() {
		return status;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	public java.lang.String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.lang.String createDate) {
		this.createDate = createDate;
	}

	public java.lang.String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}

	public java.lang.String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.lang.String updateDate) {
		this.updateDate = updateDate;
	}

	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}

	public ShopExtension getShopExtension() {
		return shopExtension;
	}

	public void setShopExtension(ShopExtension shopExtension) {
		this.shopExtension = shopExtension;
	}

	public java.lang.Long getShopArea() {
		return shopArea;
	}

	public void setShopArea(java.lang.Long shopArea) {
		this.shopArea = shopArea;
	}

	public java.lang.Integer getClerkTotalQty() {
		return clerkTotalQty;
	}

	public void setClerkTotalQty(java.lang.Integer clerkTotalQty) {
		this.clerkTotalQty = clerkTotalQty;
	}

	public java.lang.Integer getClerkBrandQty() {
		return clerkBrandQty;
	}

	public void setClerkBrandQty(java.lang.Integer clerkBrandQty) {
		this.clerkBrandQty = clerkBrandQty;
	}

	public java.lang.Long getRelationship() {
		return relationship;
	}

	public void setRelationship(java.lang.Long relationship) {
		this.relationship = relationship;
	}

	public java.lang.Long getBizCategory() {
		return bizCategory;
	}

	public void setBizCategory(java.lang.Long bizCategory) {
		this.bizCategory = bizCategory;
	}

	public java.lang.String getBrandOne() {
		return brandOne;
	}

	public void setBrandOne(java.lang.String brandOne) {
		this.brandOne = brandOne;
	}

	public java.lang.String getBrandTwo() {
		return brandTwo;
	}

	public void setBrandTwo(java.lang.String brandTwo) {
		this.brandTwo = brandTwo;
	}

	public java.lang.String getBrandThree() {
		return brandThree;
	}

	public void setBrandThree(java.lang.String brandThree) {
		this.brandThree = brandThree;
	}

	public java.lang.String getBrandFour() {
		return brandFour;
	}

	public void setBrandFour(java.lang.String brandFour) {
		this.brandFour = brandFour;
	}

	public java.lang.String getBrandFive() {
		return brandFive;
	}

	public void setBrandFive(java.lang.String brandFive) {
		this.brandFive = brandFive;
	}

	public java.lang.String getBrandSix() {
		return brandSix;
	}

	public void setBrandSix(java.lang.String brandSix) {
		this.brandSix = brandSix;
	}

	public java.lang.Integer getClerkOneQty() {
		return clerkOneQty;
	}

	public void setClerkOneQty(java.lang.Integer clerkOneQty) {
		this.clerkOneQty = clerkOneQty;
	}

	public java.lang.Integer getClerkTwoQty() {
		return clerkTwoQty;
	}

	public void setClerkTwoQty(java.lang.Integer clerkTwoQty) {
		this.clerkTwoQty = clerkTwoQty;
	}

	public java.lang.Integer getClerkThreeQty() {
		return clerkThreeQty;
	}

	public void setClerkThreeQty(java.lang.Integer clerkThreeQty) {
		this.clerkThreeQty = clerkThreeQty;
	}

	public java.lang.Integer getClerkFourQty() {
		return clerkFourQty;
	}

	public void setClerkFourQty(java.lang.Integer clerkFourQty) {
		this.clerkFourQty = clerkFourQty;
	}

	public java.lang.Integer getClerkFiveQty() {
		return clerkFiveQty;
	}

	public void setClerkFiveQty(java.lang.Integer clerkFiveQty) {
		this.clerkFiveQty = clerkFiveQty;
	}

	public java.lang.Integer getClerkSixQty() {
		return clerkSixQty;
	}

	public void setClerkSixQty(java.lang.Integer clerkSixQty) {
		this.clerkSixQty = clerkSixQty;
	}

	public java.lang.String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(java.lang.String supervisor) {
		this.supervisor = supervisor;
	}

	public java.lang.String getPromoter() {
		return promoter;
	}

	public void setPromoter(java.lang.String promoter) {
		this.promoter = promoter;
	}

	public java.lang.Long getSaleTotalQty() {
		return saleTotalQty;
	}

	public void setSaleTotalQty(java.lang.Long saleTotalQty) {
		this.saleTotalQty = saleTotalQty;
	}

	public java.lang.Long getSaleSpQty() {
		return saleSpQty;
	}

	public void setSaleSpQty(java.lang.Long saleSpQty) {
		this.saleSpQty = saleSpQty;
	}

	public java.lang.Long getSaleBrandQty() {
		return saleBrandQty;
	}

	public void setSaleBrandQty(java.lang.Long saleBrandQty) {
		this.saleBrandQty = saleBrandQty;
	}

	public java.lang.Long getSaleBrandspQty() {
		return saleBrandspQty;
	}

	public void setSaleBrandspQty(java.lang.Long saleBrandspQty) {
		this.saleBrandspQty = saleBrandspQty;
	}

	public java.lang.String getCountryName() {
		return countryName;
	}

	public void setCountryName(java.lang.String countryName) {
		this.countryName = countryName;
	}

	public java.lang.String getCityName() {
		return cityName;
	}

	public void setCityName(java.lang.String cityName) {
		this.cityName = cityName;
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

	public java.lang.String getRegionName() {
		return regionName;
	}

	public void setRegionName(java.lang.String regionName) {
		this.regionName = regionName;
	}

	public java.lang.String getCreateDateStart() {
		return createDateStart;
	}

	public void setCreateDateStart(java.lang.String createDateStart) {
		this.createDateStart = createDateStart;
	}

	public java.lang.String getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(java.lang.String createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public java.lang.String getUpdateDateStart() {
		return updateDateStart;
	}

	public void setUpdateDateStart(java.lang.String updateDateStart) {
		this.updateDateStart = updateDateStart;
	}

	public java.lang.String getUpdateDateEnd() {
		return updateDateEnd;
	}

	public void setUpdateDateEnd(java.lang.String updateDateEnd) {
		this.updateDateEnd = updateDateEnd;
	}

	@Override
	public String toString() {
		return "ShopInfoDto [id=" + id + ", countryName=" + countryName + ", cityName=" + cityName + ", regionName="
						+ regionName + ", companyCode=" + companyCode + ", gradeName=" + gradeName + ", bizName="
						+ bizName + ", createDateStart=" + createDateStart + ", createDateEnd=" + createDateEnd
						+ ", updateDateStart=" + updateDateStart + ", updateDateEnd=" + updateDateEnd + ", shopId="
						+ shopId + ", shopCode=" + shopCode + ", shopName=" + shopName + ", companyId=" + companyId
						+ ", parentId=" + parentId + ", regionId=" + regionId + ", country=" + country + ", city="
						+ city + ", shopIcon=" + shopIcon + ", address=" + address + ", gradeId=" + gradeId + ", bizId="
						+ bizId + ", ownerName=" + ownerName + ", ownerPhone=" + ownerPhone + ", purchasChannel="
						+ purchasChannel + ", openDate=" + openDate + ", status=" + status + ", remark=" + remark
						+ ", createBy=" + createBy + ", createDate=" + createDate + ", updateBy=" + updateBy
						+ ", updateDate=" + updateDate + ", version=" + version + ", shopExtension=" + shopExtension
						+ ", shopArea=" + shopArea + ", clerkTotalQty=" + clerkTotalQty + ", clerkBrandQty="
						+ clerkBrandQty + ", relationship=" + relationship + ", relationshipName=" + relationshipName
						+ ", bizCategory=" + bizCategory + ", bizCategoryName=" + bizCategoryName + ", brandOne="
						+ brandOne + ", brandTwo=" + brandTwo + ", brandThree=" + brandThree + ", brandFour="
						+ brandFour + ", brandFive=" + brandFive + ", brandSix=" + brandSix + ", clerkOneQty="
						+ clerkOneQty + ", clerkTwoQty=" + clerkTwoQty + ", clerkThreeQty=" + clerkThreeQty
						+ ", clerkFourQty=" + clerkFourQty + ", clerkFiveQty=" + clerkFiveQty + ", clerkSixQty="
						+ clerkSixQty + ", supervisor=" + supervisor + ", promoter=" + promoter + ", saleTotalQty="
						+ saleTotalQty + ", saleSpQty=" + saleSpQty + ", saleBrandQty=" + saleBrandQty
						+ ", saleBrandspQty=" + saleBrandspQty + "]";
	}

}
