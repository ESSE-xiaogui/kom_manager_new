package com.transsion.store.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaleTaskDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer companyId;
	private String saleDate;
	private String shopCode;
	private String userCode;
	private String imeiNo;
	private BigDecimal price;
	private String remark;
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getImeiNo() {
		return imeiNo;
	}
	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "SaleTaskDto [companyId=" + companyId + ", saleDate=" + saleDate + ", shopCode=" + shopCode
				+ ", userCode=" + userCode + ", imeiNo=" + imeiNo + ", price=" + price + ", remark=" + remark + "]";
	}
}
