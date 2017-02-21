package com.transsion.store.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaleDailyDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 * */
	private Long id;
	
	/**
	 *  公司Id
	 * */
	private Long companyId;
	
	/**
	 * 单号
	 * */
	private String billNo;
	
	/**
	 * 销售日期
	 * */
	private String saleDate;
	
	/**
	 * 销售日期-至
	 * */
	private String saleEndDate;
	
	/**
	 * 国家ID
	 * */
	private Integer country;
	
	/**
	 * 国家名称
	 * */
	private String countryName;

	/**
	 * 城市ID
	 * */
	private Integer city;
	
	/**
	 * 城市名称
	 * */
	private String cityName;
	
	/**
	 * 门店代码
	 * */
	private Integer shopId;
	
	/**
	 * 门店名称
	 * */
	private String shopName;
	
	/**
	 * 门店等级ID
	 * */
	private Integer gradeId;
	
	/**
	 * 门店等级名称
	 * */
	private String gradeName;
	
	/**
	 * 门店类型ID
	 * */
	private Integer bizId;
	
	/**
	 * 门店类型名称
	 * */
	private String bizName;
	
	/**
	 * 品牌
	 * */
	private String brandCode;
	
	/**
	 * 机型
	 * */
	private String modelCode;
	
	/**
	 * imeiCode
	 * */
	private String imeiNo;
	
	/**
	 * imeiList
	 * */
	private String imeiList;
	
	/**
	 * 数量
	 * */
	private BigDecimal saleQty;
	
	/**
	 * 价格
	 * */
	private BigDecimal salePrice;
	
	/**
	 * 总金额
	 * */
	private BigDecimal saleAmount;
	
	/**
	 * 当前汇率
	 * */
	private BigDecimal currencyRatio;
	
	/**
	 * 用户ID
	 * */
	private Long userId;
	
	/**
	 * 用户名
	 * */
	private String userName;
	
	/**
	 * 员工姓名
	 * */
	private String empName;
	
	/**
	 * 职务
	 * */
	private String nation;
	
	/**
	 * 上传时间
	 * */
	private String createdTime;
	
	/**
	 * 上传时间
	 * */
	private String createdEndTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public String getSaleEndDate() {
		return saleEndDate;
	}

	public void setSaleEndDate(String saleEndDate) {
		this.saleEndDate = saleEndDate;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public Integer getBizId() {
		return bizId;
	}

	public void setBizId(Integer bizId) {
		this.bizId = bizId;
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}

	public String getImeiList() {
		return imeiList;
	}

	public void setImeiList(String imeiList) {
		this.imeiList = imeiList;
	}

	public BigDecimal getSaleQty() {
		return saleQty;
	}

	public void setSaleQty(BigDecimal saleQty) {
		this.saleQty = saleQty;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(BigDecimal saleAmount) {
		this.saleAmount = saleAmount;
	}

	public BigDecimal getCurrencyRatio() {
		return currencyRatio;
	}

	public void setCurrencyRatio(BigDecimal currencyRatio) {
		this.currencyRatio = currencyRatio;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedEndTime() {
		return createdEndTime;
	}

	public void setCreatedEndTime(String createdEndTime) {
		this.createdEndTime = createdEndTime;
	}

	@Override
	public String toString() {
		return "SaleDailyDto [id=" + id + ", companyId=" + companyId + ", billNo=" + billNo + ", saleDate=" + saleDate
						+ ", saleEndDate=" + saleEndDate + ", country=" + country + ", countryName=" + countryName
						+ ", city=" + city + ", cityName=" + cityName + ", shopId=" + shopId + ", shopName=" + shopName
						+ ", gradeId=" + gradeId + ", gradeName=" + gradeName + ", bizId=" + bizId + ", bizName="
						+ bizName + ", brandCode=" + brandCode + ", modelCode=" + modelCode + ", imeiNo=" + imeiNo
						+ ", imeiList=" + imeiList + ", saleQty=" + saleQty + ", salePrice=" + salePrice
						+ ", saleAmount=" + saleAmount + ", currencyRatio=" + currencyRatio + ", userId=" + userId
						+ ", userName=" + userName + ", empName=" + empName + ", nation=" + nation + ", createdTime="
						+ createdTime + ", createdEndTime=" + createdEndTime + "]";
	}
	
}
