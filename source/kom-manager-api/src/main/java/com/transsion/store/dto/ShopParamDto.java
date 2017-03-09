package com.transsion.store.dto;

import java.io.Serializable;

public class ShopParamDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id; 
	/**
	 * 门店名称
	 * */
	private String shopName;
	/**
	 * 国家ID
	 * */
	private Long country;
	/**
	 * 国家名称
	 */
	private String countryName;
	/**
	 * 城市ID
	 * */
	private Long city;
	/**
	 * 城市名称
	 * */
	private String cityName;
	/**
	 * 详细地址
	 * */
	private String address;
	/**
	 * 店主名称
	 * */
	private String ownerName;
	/**
	 * 店主电话
	 * */
	private String ownerPhone;
	/**
	 * itel促销员
	 * 
	 * */	
	private String itelPromoter;
	
	/**
	  *	销售代表（巡店员）
	  */
	private String shopAssistant;
	/**
	 * 物料ID
	 * */
	private Long materielId;
	/**
	 * 物料类型
	 * */	
	private String materielName;
	/**
	 * 等级ID
	 * */
	private Long gradeId;
	/**
	 * 等级名称
	 * */
	private String gradeName;
	/**
	 * 销售总数量
	 * */
	private Integer totalnum;
	/**
	  *	 itel 当前销售数量
	  */
	private Integer currentnum;
	/**
	 * 业务ID
	 * */
	private Long bizId;	
	/***
	 * 业务类型
	 * */
	private String bizName;
	/**
	 * 主推品牌一
	 * */
	private String brandsFirst;
	/**
	 * 主推品牌二
	 * */
	private String brandsTwo;
	/**
	 * 主推品牌三
	 * */
	private String brandsThree;
	/**
	 * 备注
	 * */
	private String remark;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Long getCountry() {
		return country;
	}
	public void setCountry(Long country) {
		this.country = country;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Long getCity() {
		return city;
	}
	public void setCity(Long city) {
		this.city = city;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public String getItelPromoter() {
		return itelPromoter;
	}
	public void setItelPromoter(String itelPromoter) {
		this.itelPromoter = itelPromoter;
	}
	public String getShopAssistant() {
		return shopAssistant;
	}
	public void setShopAssistant(String shopAssistant) {
		this.shopAssistant = shopAssistant;
	}
	public Long getMaterielId() {
		return materielId;
	}
	public void setMaterielId(Long materielId) {
		this.materielId = materielId;
	}
	public String getMaterielName() {
		return materielName;
	}
	public void setMaterielName(String materielName) {
		this.materielName = materielName;
	}
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public Integer getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}
	public Integer getCurrentnum() {
		return currentnum;
	}
	public void setCurrentnum(Integer currentnum) {
		this.currentnum = currentnum;
	}
	public Long getBizId() {
		return bizId;
	}
	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}
	public String getBizName() {
		return bizName;
	}
	public void setBizName(String bizName) {
		this.bizName = bizName;
	}
	public String getBrandsFirst() {
		return brandsFirst;
	}
	public void setBrandsFirst(String brandsFirst) {
		this.brandsFirst = brandsFirst;
	}
	public String getBrandsTwo() {
		return brandsTwo;
	}
	public void setBrandsTwo(String brandsTwo) {
		this.brandsTwo = brandsTwo;
	}
	public String getBrandsThree() {
		return brandsThree;
	}
	public void setBrandsThree(String brandsThree) {
		this.brandsThree = brandsThree;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "ShopParamDto [id=" + id + ", shopName=" + shopName + ", country=" + country + ", countryName="
						+ countryName + ", city=" + city + ", cityName=" + cityName + ", address=" + address
						+ ", ownerName=" + ownerName + ", ownerPhone=" + ownerPhone + ", itelPromoter=" + itelPromoter
						+ ", shopAssistant=" + shopAssistant + ", materielId=" + materielId + ", materielName="
						+ materielName + ", gradeId=" + gradeId + ", gradeName=" + gradeName + ", totalnum=" + totalnum
						+ ", currentnum=" + currentnum + ", bizId=" + bizId + ", bizName=" + bizName + ", brandsFirst="
						+ brandsFirst + ", brandsTwo=" + brandsTwo + ", brandsThree=" + brandsThree + ", remark="
						+ remark + "]";
	}
	
}
