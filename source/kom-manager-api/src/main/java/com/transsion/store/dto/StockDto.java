package com.transsion.store.dto;
import java.math.BigDecimal;
/**
 * Created by pradmin on 2016/5/30.
 * update by zhangguihua on 2016/08/05
 */
public class StockDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String brandCode;

	private String modelMatCode;

	private java.math.BigDecimal fqty;

	private String fdate;

	private java.math.BigDecimal fprice;

	public java.math.BigDecimal getFprice() {
		return fprice;
	}

	public void setFprice(java.math.BigDecimal fprice) {
		this.fprice = fprice;
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

	public BigDecimal getFqty() {
		return fqty;
	}

	public void setFqty(BigDecimal fqty) {
		this.fqty = fqty;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	@Override
	public String toString() {
		return "StockDto [brandCode=" + brandCode + ", modelMatCode=" + modelMatCode + ", fqty=" + fqty + ", fdate="
				+ fdate + ", fprice=" + fprice + "]";
	}

}
