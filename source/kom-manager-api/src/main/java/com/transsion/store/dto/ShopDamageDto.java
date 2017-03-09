package com.transsion.store.dto;

import java.io.Serializable;

public class ShopDamageDto implements Serializable{
	private static final long serialVersionUID = 9004711763566367909L;
	
	private Long damageId;
	private String companyName;
	private String damageTime;
	private String countryName;
	private String cityName;
	private String shopCode;
	private String shopName;
	private String createBy;
	private String empName;
	private String dutyName;
	private String nameCn;
	private String nameEn;
	private String createTime;
	
	private String damageStartDate;
	private String damageEndDate;
	private String createStartDate;
	private String createEndDate;
	private Long companyId;
	private Long regionId;
	
	private String imgFirstUrl;
	private String imgSecondUrl;
	private String imgThirdUrl;
	
	public Long getDamageId() {
		return damageId;
	}
	public void setDamageId(Long damageId) {
		this.damageId = damageId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDamageTime() {
		return damageTime;
	}
	public void setDamageTime(String damageTime) {
		this.damageTime = damageTime;
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
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDutyName() {
		return dutyName;
	}
	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getDamageStartDate() {
		return damageStartDate;
	}
	public void setDamageStartDate(String damageStartDate) {
		this.damageStartDate = damageStartDate;
	}
	public String getDamageEndDate() {
		return damageEndDate;
	}
	public void setDamageEndDate(String damageEndDate) {
		this.damageEndDate = damageEndDate;
	}
	public String getCreateStartDate() {
		return createStartDate;
	}
	public void setCreateStartDate(String createStartDate) {
		this.createStartDate = createStartDate;
	}
	public String getCreateEndDate() {
		return createEndDate;
	}
	public void setCreateEndDate(String createEndDate) {
		this.createEndDate = createEndDate;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	public String getImgFirstUrl() {
		return imgFirstUrl;
	}
	public void setImgFirstUrl(String imgFirstUrl) {
		this.imgFirstUrl = imgFirstUrl;
	}
	public String getImgSecondUrl() {
		return imgSecondUrl;
	}
	public void setImgSecondUrl(String imgSecondUrl) {
		this.imgSecondUrl = imgSecondUrl;
	}
	public String getImgThirdUrl() {
		return imgThirdUrl;
	}
	public void setImgThirdUrl(String imgThirdUrl) {
		this.imgThirdUrl = imgThirdUrl;
	}
	
	@Override
	public String toString() {
		return "ShopDamageDto [damageId=" + damageId + ", companyName=" + companyName + ", damageTime=" + damageTime
				+ ", countryName=" + countryName + ", cityName=" + cityName + ", shopCode=" + shopCode + ", shopName="
				+ shopName + ", createBy=" + createBy + ", empName=" + empName + ", dutyName=" + dutyName + ", nameCn="
				+ nameCn + ", nameEn=" + nameEn + ", createTime=" + createTime + ", damageStartDate=" + damageStartDate
				+ ", damageEndDate=" + damageEndDate + ", createStartDate=" + createStartDate + ", createEndDate="
				+ createEndDate + ", companyId=" + companyId + ", regionId=" + regionId + ", imgFirstUrl=" + imgFirstUrl
				+ ", imgSecondUrl=" + imgSecondUrl + ", imgThirdUrl=" + imgThirdUrl + "]";
	}
	
}
