package com.transsion.store.dto;


import java.util.List;

import com.transsion.store.bo.SaleItem;

/**
 * Created by pradmin on 2016/5/30.
 * @author guihua.zhang on 2016/08/11
 */
public class TShopSaleDto implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String saleDate;
	private Integer shopId;
    private List<SaleItem> tShopSaleitems;
    
    public String getSaleDate() {
		return saleDate;
	}
	public void setSalesDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public List<SaleItem> gettShopSaleitems() {
		return tShopSaleitems;
	}
	public void settShopSaleitems(List<SaleItem> tShopSaleitems) {
		this.tShopSaleitems = tShopSaleitems;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	
	@Override
	public String toString() {
		return "TShopSaleDto [saleDate=" + saleDate + ", shopId=" + shopId + ", tShopSaleitems=" + tShopSaleitems + "]";
	}
}
