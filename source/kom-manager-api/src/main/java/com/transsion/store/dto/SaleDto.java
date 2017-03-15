package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

import com.transsion.store.bo.Sale;
import com.transsion.store.bo.SaleItem;

public class SaleDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Sale sale;
	private List<SaleItem> saleItems;
	
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	public List<SaleItem> getSaleItems() {
		return saleItems;
	}
	public void setSaleItems(List<SaleItem> saleItems) {
		this.saleItems = saleItems;
	}

}
