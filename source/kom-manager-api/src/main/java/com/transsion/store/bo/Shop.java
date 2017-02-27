/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:39
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class Shop extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

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
	  *	审核状态 :1：已生效 2：待审核
	  */
	private java.lang.Integer status;
	
	/**
	 * 是否启用：1：启用  2：停用
	 */
	private java.lang.Integer isInactive;

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
	

	
	/*********************************duplicated attributes move to shop extension **********************************/
	
	/**
	  *	
	  */
	private java.lang.String promoter;

	/**
	  *	
	  */
	private java.lang.String assistant;

	/**
	  *	
	  */
	private java.lang.Integer materielId;

	/**
	  *	
	  */
	private java.lang.Integer totalNum;

	/**
	  *	
	  */
	private java.lang.Integer currentNum;

	/**
	  *	
	  */
	private java.lang.Integer clerkNum;

	/**
	  *	
	  */
	private java.lang.String brandsFirst;

	/**
	  *	
	  */
	private java.lang.String brandsTwo;

	/**
	  *	
	  */
	private java.lang.String brandsThree;

	/**
	  *	
	  */
	private java.lang.Integer counterNum;

	/**
	  *	
	  */
	private java.lang.String darkPro;


	/**
	  *	
	  */
	private java.lang.Integer isKom;

	/**
	  *	
	  */
	private java.lang.Long relationship;

	/**
	  *	
	  */
	private java.lang.String incorporator;

	/**
	  *	
	  */
	private java.lang.String incorporatorTel;

	/**
	  *	
	  */
	private java.math.BigDecimal fwidth;

	/**
	  *	
	  */
	private java.math.BigDecimal fdepth;

	/**
	  *	10、10-20、 >20三选一
	  */
	private java.lang.Integer shopArea;

	/**
	  *	
	  */
	private java.lang.Long showNum;

	/**
	  *	
	  */
	private java.lang.Long staffNum;

	/**
	  *	
	  */
	private java.lang.Long salesNum;


	
	private String countryName;

	private String cityName;
	private String werks;
	
	private String gradeName;
	
	private String bizName;

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	/**
	  *	
	  */
	public java.lang.Long getId() 
	{
		return id;
	}
	
	/**
	  *	
	  */
	public void setId(java.lang.Long id) 
	{
		this.id = id;
	}
	
	/**
	  *	keep for align with kom pc
	  */
	public java.lang.Long getShopId() 
	{
		return shopId;
	}
	
	/**
	  *	keep for align with kom pc
	  */
	public void setShopId(java.lang.Long shopId) 
	{
		this.shopId = shopId;
	}
	
	/**
	  *	生成方式：国家简称加六位数的序号。
	  */
	public java.lang.String getShopCode() 
	{
		return shopCode;
	}
	
	/**
	  *	生成方式：国家简称加六位数的序号。
	  */
	public void setShopCode(java.lang.String shopCode) 
	{
		this.shopCode = shopCode;
	}
	
	/**
	  *	
	  */
	public java.lang.String getShopName() 
	{
		return shopName;
	}
	
	/**
	  *	
	  */
	public void setShopName(java.lang.String shopName) 
	{
		this.shopName = shopName;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	
	  */
	public void setCompanyId(java.lang.Integer companyId) 
	{
		this.companyId = companyId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getParentId() 
	{
		return parentId;
	}
	
	/**
	  *	
	  */
	public void setParentId(java.lang.Long parentId) 
	{
		this.parentId = parentId;
	}
	
	/**
	  *	
	  */

	public java.lang.Integer getCountry() 
	{
		return country;
	}
	
	/**
	  *	
	  */
	
	public java.lang.Long getRegionId() {
		return regionId;
	}
	
	/**
	  *	
	  */
	
	public void setRegionId(java.lang.Long regionId) {
		this.regionId = regionId;
	}

	/**
	  *	
	  */
	public void setCountry(java.lang.Integer country) 
	{
		this.country = country;
	}
	
	/**
	  *	根据督导所属国家选择城市列表
	  */
	public java.lang.Integer getCity() 
	{
		return city;
	}
	
	/**
	  *	根据督导所属国家选择城市列表
	  */
	public void setCity(java.lang.Integer city) 
	{
		this.city = city;
	}
	
	/**
	  *	
	  */
	public java.lang.String getShopIcon() 
	{
		return shopIcon;
	}
	
	/**
	  *	
	  */
	public void setShopIcon(java.lang.String shopIcon) 
	{
		this.shopIcon = shopIcon;
	}
	
	/**
	  *	
	  */
	public java.lang.String getAddress() 
	{
		return address;
	}
	
	/**
	  *	
	  */
	public void setAddress(java.lang.String address) 
	{
		this.address = address;
	}
	
	/**
	  *	
	  */
	public java.lang.String getOwnerName() 
	{
		return ownerName;
	}
	
	/**
	  *	
	  */
	public void setOwnerName(java.lang.String ownerName) 
	{
		this.ownerName = ownerName;
	}
	
	/**
	  *	
	  */
	public java.lang.String getOwnerPhone() 
	{
		return ownerPhone;
	}
	
	/**
	  *	
	  */
	public void setOwnerPhone(java.lang.String ownerPhone) 
	{
		this.ownerPhone = ownerPhone;
	}
	
	/**
	  *	
	  */
	public java.lang.String getPromoter() 
	{
		return promoter;
	}
	
	/**
	  *	
	  */
	public void setPromoter(java.lang.String promoter) 
	{
		this.promoter = promoter;
	}
	
	/**
	  *	
	  */
	public java.lang.String getAssistant() 
	{
		return assistant;
	}
	
	/**
	  *	
	  */
	public void setAssistant(java.lang.String assistant) 
	{
		this.assistant = assistant;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getMaterielId() 
	{
		return materielId;
	}
	
	/**
	  *	
	  */
	public void setMaterielId(java.lang.Integer materielId) 
	{
		this.materielId = materielId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getGradeId() 
	{
		return gradeId;
	}
	
	/**
	  *	
	  */
	public void setGradeId(java.lang.Long gradeId) 
	{
		this.gradeId = gradeId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getBizId() 
	{
		return bizId;
	}
	
	/**
	  *	
	  */
	public void setBizId(java.lang.Long bizId) 
	{
		this.bizId = bizId;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getTotalNum() 
	{
		return totalNum;
	}
	
	/**
	  *	
	  */
	public void setTotalNum(java.lang.Integer totalNum) 
	{
		this.totalNum = totalNum;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getCurrentNum() 
	{
		return currentNum;
	}
	
	/**
	  *	
	  */
	public void setCurrentNum(java.lang.Integer currentNum) 
	{
		this.currentNum = currentNum;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getClerkNum() 
	{
		return clerkNum;
	}
	
	/**
	  *	
	  */
	public void setClerkNum(java.lang.Integer clerkNum) 
	{
		this.clerkNum = clerkNum;
	}
	
	/**
	  *	
	  */
	public java.lang.String getBrandsFirst() 
	{
		return brandsFirst;
	}
	
	/**
	  *	
	  */
	public void setBrandsFirst(java.lang.String brandsFirst) 
	{
		this.brandsFirst = brandsFirst;
	}
	
	/**
	  *	
	  */
	public java.lang.String getBrandsTwo() 
	{
		return brandsTwo;
	}
	
	/**
	  *	
	  */
	public void setBrandsTwo(java.lang.String brandsTwo) 
	{
		this.brandsTwo = brandsTwo;
	}
	
	/**
	  *	
	  */
	public java.lang.String getBrandsThree() 
	{
		return brandsThree;
	}
	
	/**
	  *	
	  */
	public void setBrandsThree(java.lang.String brandsThree) 
	{
		this.brandsThree = brandsThree;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getCounterNum() 
	{
		return counterNum;
	}
	
	/**
	  *	
	  */
	public void setCounterNum(java.lang.Integer counterNum) 
	{
		this.counterNum = counterNum;
	}
	
	/**
	  *	
	  */
	public java.lang.String getDarkPro() 
	{
		return darkPro;
	}
	
	/**
	  *	
	  */
	public void setDarkPro(java.lang.String darkPro) 
	{
		this.darkPro = darkPro;
	}
	
	/**
	  *	
	  */
	public java.lang.String getPurchasChannel() 
	{
		return purchasChannel;
	}
	
	/**
	  *	
	  */
	public void setPurchasChannel(java.lang.String purchasChannel) 
	{
		this.purchasChannel = purchasChannel;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getIsKom() 
	{
		return isKom;
	}
	
	/**
	  *	
	  */
	public void setIsKom(java.lang.Integer isKom) 
	{
		this.isKom = isKom;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getRelationship() 
	{
		return relationship;
	}
	
	/**
	  *	
	  */
	public void setRelationship(java.lang.Long relationship) 
	{
		this.relationship = relationship;
	}
	
	/**
	  *	
	  */
	public java.lang.String getIncorporator() 
	{
		return incorporator;
	}
	
	/**
	  *	
	  */
	public void setIncorporator(java.lang.String incorporator) 
	{
		this.incorporator = incorporator;
	}
	
	/**
	  *	
	  */
	public java.lang.String getIncorporatorTel() 
	{
		return incorporatorTel;
	}
	
	/**
	  *	
	  */
	public void setIncorporatorTel(java.lang.String incorporatorTel) 
	{
		this.incorporatorTel = incorporatorTel;
	}
	
	/**
	  *	
	  */
	public java.math.BigDecimal getFwidth() 
	{
		return fwidth;
	}
	
	/**
	  *	
	  */
	public void setFwidth(java.math.BigDecimal fwidth) 
	{
		this.fwidth = fwidth;
	}
	
	/**
	  *	
	  */
	public java.math.BigDecimal getFdepth() 
	{
		return fdepth;
	}
	
	/**
	  *	
	  */
	public void setFdepth(java.math.BigDecimal fdepth) 
	{
		this.fdepth = fdepth;
	}
	
	/**
	  *	10、10-20、 >20三选一
	  */
	public java.lang.Integer getShopArea() 
	{
		return shopArea;
	}
	
	/**
	  *	10、10-20、 >20三选一
	  */
	public void setShopArea(java.lang.Integer shopArea) 
	{
		this.shopArea = shopArea;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getShowNum() 
	{
		return showNum;
	}
	
	/**
	  *	
	  */
	public void setShowNum(java.lang.Long showNum) 
	{
		this.showNum = showNum;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getStaffNum() 
	{
		return staffNum;
	}
	
	/**
	  *	
	  */
	public void setStaffNum(java.lang.Long staffNum) 
	{
		this.staffNum = staffNum;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getSalesNum() 
	{
		return salesNum;
	}
	
	/**
	  *	
	  */
	public void setSalesNum(java.lang.Long salesNum) 
	{
		this.salesNum = salesNum;
	}
	
	/**
	  *	信息上传当天的北京时间
	  */
	public java.lang.String getOpenDate() 
	{
		return openDate;
	}
	
	/**
	  *	信息上传当天的北京时间
	  */
	public void setOpenDate(java.lang.String openDate) 
	{
		this.openDate = openDate;
	}
	
	/**
	  *	审核状态 :1：已生效 2：待审核
	  */
	public java.lang.Integer getStatus() 
	{
		return status;
	}
	
	/**
	  *	审核状态 :1：已生效 2：待审核
	  */
	public void setStatus(java.lang.Integer status) 
	{
		this.status = status;
	}
	
	
	public java.lang.Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(java.lang.Integer isInactive) {
		this.isInactive = isInactive;
	}

	/**
	  *	
	  */
	public java.lang.String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	
	  */
	public void setRemark(java.lang.String remark) 
	{
		this.remark = remark;
	}
	
	/**
	  *	Table User ID
	  */
	public java.lang.String getCreateBy() 
	{
		return createBy;
	}
	
	/**
	  *	Table User ID
	  */
	public void setCreateBy(java.lang.String createBy) 
	{
		this.createBy = createBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCreateDate() 
	{
		return createDate;
	}
	
	/**
	  *	
	  */
	public void setCreateDate(java.lang.String createDate) 
	{
		this.createDate = createDate;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUpdateBy() 
	{
		return updateBy;
	}
	
	/**
	  *	
	  */
	public void setUpdateBy(java.lang.String updateBy) 
	{
		this.updateBy = updateBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUpdateDate() 
	{
		return updateDate;
	}
	
	/**
	  *	
	  */
	public void setUpdateDate(java.lang.String updateDate) 
	{
		this.updateDate = updateDate;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getVersion() 
	{
		return version;
	}
	
	/**
	  *	
	  */
	public void setVersion(java.lang.Integer version) 
	{
		this.version = version;
	}
	
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getWerks() {
		return werks;
	}

	public void setWerks(String werks) {
		this.werks = werks;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", shopId=" + shopId + ", shopCode=" + shopCode + ", shopName=" + shopName
						+ ", companyId=" + companyId + ", parentId=" + parentId + ", regionId=" + regionId
						+ ", country=" + country + ", city=" + city + ", shopIcon=" + shopIcon + ", address=" + address
						+ ", gradeId=" + gradeId + ", bizId=" + bizId + ", ownerName=" + ownerName + ", ownerPhone="
						+ ownerPhone + ", purchasChannel=" + purchasChannel + ", openDate=" + openDate + ", status="
						+ status + ", isInactive=" + isInactive + ", remark=" + remark + ", createBy=" + createBy
						+ ", createDate=" + createDate + ", updateBy=" + updateBy + ", updateDate=" + updateDate
						+ ", version=" + version + ", promoter=" + promoter + ", assistant=" + assistant
						+ ", materielId=" + materielId + ", totalNum=" + totalNum + ", currentNum=" + currentNum
						+ ", clerkNum=" + clerkNum + ", brandsFirst=" + brandsFirst + ", brandsTwo=" + brandsTwo
						+ ", brandsThree=" + brandsThree + ", counterNum=" + counterNum + ", darkPro=" + darkPro
						+ ", isKom=" + isKom + ", relationship=" + relationship + ", incorporator=" + incorporator
						+ ", incorporatorTel=" + incorporatorTel + ", fwidth=" + fwidth + ", fdepth=" + fdepth
						+ ", shopArea=" + shopArea + ", showNum=" + showNum + ", staffNum=" + staffNum + ", salesNum="
						+ salesNum + ", countryName=" + countryName + ", cityName=" + cityName + ", werks=" + werks
						+ ", gradeName=" + gradeName + ", bizName=" + bizName + "]";
	}


}

