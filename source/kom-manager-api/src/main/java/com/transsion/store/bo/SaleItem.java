/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:38
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class SaleItem extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.Long saleId;

	/**
	  *	上下端单据编码相同
	  */
	private java.lang.String billno;

	/**
	  *	入库单明细ID号
	  */
	private java.lang.Integer lineId;

	/**
	  *	
	  */
	private java.lang.Integer shopId;

	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	private java.lang.Integer companyId;

	/**
	  *	
	  */
	private java.lang.String brandCode;

	/**
	  *	机型代码
	  */
	private java.lang.String modelCode;

	/**
	  *	
	  */
	private java.lang.String imeiNo;

	/**
	  *	
	  */
	private java.lang.String imeiList;

	/**
	  *	
	  */
	private java.math.BigDecimal saleQty;

	/**
	  *	输入单价可自动计算金额
	  */
	private java.math.BigDecimal salePrice;

	/**
	  *	输入金额可自动计算单价
	  */
	private java.math.BigDecimal saleAmount;

	/**
	  *	
	  */
	private java.lang.Long sellerId;

	/**
	  *	
	  */
	private java.lang.String invoiceNo;

	/**
	  *	
	  */
	private java.lang.String qrCode;

	/**
	  *	
	  */
	private java.lang.String productDate;

	/**
	  *	
	  */
	private java.lang.String factoryCode;

	/**
	  *	
	  */
	private java.lang.String userName;

	/**
	  *	
	  */
	private java.lang.Integer gender;

	/**
	  *	手机或固定电话
	  */
	private java.lang.String phoneNo;

	/**
	  *	电子邮箱
	  */
	private java.lang.String email;

	/**
	  *	
	  */
	private java.lang.String homeAddress;

	/**
	  *	邮政编码
	  */
	private java.lang.String zipCode;

	/**
	  *	备注-512
	  */
	private java.lang.String remark;

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
	  *	
	  */
	public java.lang.Long getSaleId() 
	{
		return saleId;
	}
	
	/**
	  *	
	  */
	public void setSaleId(java.lang.Long saleId) 
	{
		this.saleId = saleId;
	}
	
	/**
	  *	上下端单据编码相同
	  */
	public java.lang.String getBillno() 
	{
		return billno;
	}
	
	/**
	  *	上下端单据编码相同
	  */
	public void setBillno(java.lang.String billno) 
	{
		this.billno = billno;
	}
	
	/**
	  *	入库单明细ID号
	  */
	public java.lang.Integer getLineId() 
	{
		return lineId;
	}
	
	/**
	  *	入库单明细ID号
	  */
	public void setLineId(java.lang.Integer lineId) 
	{
		this.lineId = lineId;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getShopId() 
	{
		return shopId;
	}
	
	/**
	  *	
	  */
	public void setShopId(java.lang.Integer shopId) 
	{
		this.shopId = shopId;
	}
	
	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	public java.lang.Integer getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	public void setCompanyId(java.lang.Integer companyId) 
	{
		this.companyId = companyId;
	}
	
	/**
	  *	
	  */
	public java.lang.String getBrandCode() 
	{
		return brandCode;
	}
	
	/**
	  *	
	  */
	public void setBrandCode(java.lang.String brandCode) 
	{
		this.brandCode = brandCode;
	}
	
	/**
	  *	机型代码
	  */
	public java.lang.String getModelCode() 
	{
		return modelCode;
	}
	
	/**
	  *	机型代码
	  */
	public void setModelCode(java.lang.String modelCode) 
	{
		this.modelCode = modelCode;
	}
	
	/**
	  *	
	  */
	public java.lang.String getImeiNo() 
	{
		return imeiNo;
	}
	
	/**
	  *	
	  */
	public void setImeiNo(java.lang.String imeiNo) 
	{
		this.imeiNo = imeiNo;
	}
	
	/**
	  *	
	  */
	public java.lang.String getImeiList() 
	{
		return imeiList;
	}
	
	/**
	  *	
	  */
	public void setImeiList(java.lang.String imeiList) 
	{
		this.imeiList = imeiList;
	}
	
	/**
	  *	
	  */
	public java.math.BigDecimal getSaleQty() 
	{
		return saleQty;
	}
	
	/**
	  *	
	  */
	public void setSaleQty(java.math.BigDecimal saleQty) 
	{
		this.saleQty = saleQty;
	}
	
	/**
	  *	输入单价可自动计算金额
	  */
	public java.math.BigDecimal getSalePrice() 
	{
		return salePrice;
	}
	
	/**
	  *	输入单价可自动计算金额
	  */
	public void setSalePrice(java.math.BigDecimal salePrice) 
	{
		this.salePrice = salePrice;
	}
	
	/**
	  *	输入金额可自动计算单价
	  */
	public java.math.BigDecimal getSaleAmount() 
	{
		return saleAmount;
	}
	
	/**
	  *	输入金额可自动计算单价
	  */
	public void setSaleAmount(java.math.BigDecimal saleAmount) 
	{
		this.saleAmount = saleAmount;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getSellerId() 
	{
		return sellerId;
	}
	
	/**
	  *	
	  */
	public void setSellerId(java.lang.Long sellerId) 
	{
		this.sellerId = sellerId;
	}
	
	/**
	  *	
	  */
	public java.lang.String getInvoiceNo() 
	{
		return invoiceNo;
	}
	
	/**
	  *	
	  */
	public void setInvoiceNo(java.lang.String invoiceNo) 
	{
		this.invoiceNo = invoiceNo;
	}
	
	/**
	  *	
	  */
	public java.lang.String getQrCode() 
	{
		return qrCode;
	}
	
	/**
	  *	
	  */
	public void setQrCode(java.lang.String qrCode) 
	{
		this.qrCode = qrCode;
	}
	
	/**
	  *	
	  */
	public java.lang.String getProductDate() 
	{
		return productDate;
	}
	
	/**
	  *	
	  */
	public void setProductDate(java.lang.String productDate) 
	{
		this.productDate = productDate;
	}
	
	/**
	  *	
	  */
	public java.lang.String getFactoryCode() 
	{
		return factoryCode;
	}
	
	/**
	  *	
	  */
	public void setFactoryCode(java.lang.String factoryCode) 
	{
		this.factoryCode = factoryCode;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUserName() 
	{
		return userName;
	}
	
	/**
	  *	
	  */
	public void setUserName(java.lang.String userName) 
	{
		this.userName = userName;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getGender() 
	{
		return gender;
	}
	
	/**
	  *	
	  */
	public void setGender(java.lang.Integer gender) 
	{
		this.gender = gender;
	}
	
	/**
	  *	手机或固定电话
	  */
	public java.lang.String getPhoneNo() 
	{
		return phoneNo;
	}
	
	/**
	  *	手机或固定电话
	  */
	public void setPhoneNo(java.lang.String phoneNo) 
	{
		this.phoneNo = phoneNo;
	}
	
	/**
	  *	电子邮箱
	  */
	public java.lang.String getEmail() 
	{
		return email;
	}
	
	/**
	  *	电子邮箱
	  */
	public void setEmail(java.lang.String email) 
	{
		this.email = email;
	}
	
	/**
	  *	
	  */
	public java.lang.String getHomeAddress() 
	{
		return homeAddress;
	}
	
	/**
	  *	
	  */
	public void setHomeAddress(java.lang.String homeAddress) 
	{
		this.homeAddress = homeAddress;
	}
	
	/**
	  *	邮政编码
	  */
	public java.lang.String getZipCode() 
	{
		return zipCode;
	}
	
	/**
	  *	邮政编码
	  */
	public void setZipCode(java.lang.String zipCode) 
	{
		this.zipCode = zipCode;
	}
	
	/**
	  *	备注-512
	  */
	public java.lang.String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	备注-512
	  */
	public void setRemark(java.lang.String remark) 
	{
		this.remark = remark;
	}
	
	public String toString()
	{
		return "SaleItem [" + 
					"id=" + id + 
					", saleId=" + saleId + 
					", billno=" + billno + 
					", lineId=" + lineId + 
					", shopId=" + shopId + 
					", companyId=" + companyId + 
					", brandCode=" + brandCode + 
					", modelCode=" + modelCode + 
					", imeiNo=" + imeiNo + 
					", imeiList=" + imeiList + 
					", saleQty=" + saleQty + 
					", salePrice=" + salePrice + 
					", saleAmount=" + saleAmount + 
					", sellerId=" + sellerId + 
					", invoiceNo=" + invoiceNo + 
					", qrCode=" + qrCode + 
					", productDate=" + productDate + 
					", factoryCode=" + factoryCode + 
					", userName=" + userName + 
					", gender=" + gender + 
					", phoneNo=" + phoneNo + 
					", email=" + email + 
					", homeAddress=" + homeAddress + 
					", zipCode=" + zipCode + 
					", remark=" + remark + 
				"]";
	}
}

