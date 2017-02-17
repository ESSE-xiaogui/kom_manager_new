package com.transsion.store.dto;

import java.io.Serializable;

public class ShopGradeDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	店铺等级
	  */
	private java.lang.String gradeName;
	
	private java.lang.String brandCode;
	
	private java.lang.Integer saleQTY;
	
	private java.lang.String enSaleQTY;
	
	private java.lang.String cnSaleQTY;
	
	private java.lang.Integer isInactive;

	/**
	  *	
	  */
	private java.lang.Integer companyId;

	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	
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
	  *	店铺等级
	  */
	public java.lang.String getGradeName() 
	{
		return gradeName;
	}
	
	/**
	  *	店铺等级
	  */
	public void setGradeName(java.lang.String gradeName) 
	{
		this.gradeName = gradeName;
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
	  *	
	  */
	public java.lang.String getCreateBy() 
	{
		return createBy;
	}
	
	/**
	  *	
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
	
	public java.lang.String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(java.lang.String brandCode) {
		this.brandCode = brandCode;
	}

	public java.lang.Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(java.lang.Integer isInactive) {
		this.isInactive = isInactive;
	}

	public java.lang.Integer getSaleQTY() {
		return saleQTY;
	}

	public void setSaleQTY(java.lang.Integer saleQTY) {
		this.saleQTY = saleQTY;
	}

	public java.lang.String getEnSaleQTY() {
		return enSaleQTY;
	}

	public void setEnSaleQTY(java.lang.String enSaleQTY) {
		this.enSaleQTY = enSaleQTY;
	}

	public java.lang.String getCnSaleQTY() {
		return cnSaleQTY;
	}

	public void setCnSaleQTY(java.lang.String cnSaleQTY) {
		this.cnSaleQTY = cnSaleQTY;
	}

	@Override
	public String toString() {
		return "ShopGradeDto [id=" + id + ", gradeName=" + gradeName + ", brandCode=" + brandCode + ", saleQTY="
						+ saleQTY + ", enSaleQTY=" + enSaleQTY + ", cnSaleQTY=" + cnSaleQTY + ", isInactive="
						+ isInactive + ", companyId=" + companyId + ", remark=" + remark + ", createBy=" + createBy
						+ ", createDate=" + createDate + ", updateBy=" + updateBy + ", updateDate=" + updateDate
						+ ", version=" + version + "]";
	}

}
