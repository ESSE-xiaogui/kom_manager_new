package com.transsion.store.dto;

import java.math.BigDecimal;

/**
 * Created by pradmin on 2016/5/30.
 */
public class SalesDto implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private String brandCode;

    private String modelMatCode;

    private BigDecimal saleQty;

    private java.math.BigDecimal salePrice;

    private String saleDate;
    
    private String imeiNo;


    public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}

	public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getModelMatCode() {
        return modelMatCode;
    }

    public void setModelMatCode(String modelMatCode) {
        this.modelMatCode = modelMatCode;
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

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "SalesDto{" +
                "brandCode='" + brandCode + '\'' +
                ", modelMatCode='" + modelMatCode + '\'' +
                ", saleQty=" + saleQty +
                ", salePrice=" + salePrice +
                ", saleDate='" + saleDate + '\'' +
                ", imeiNo='"+ imeiNo + '\''+
                '}';
    }
}
