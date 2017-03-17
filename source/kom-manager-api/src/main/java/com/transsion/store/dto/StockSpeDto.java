package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

import com.transsion.store.bo.Stock;
import com.transsion.store.bo.StockItem;

public class StockSpeDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Stock stock;
	private List<StockItem> stockItems;
	private String authorization; 
	
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public List<StockItem> getStockItems() {
		return stockItems;
	}
	public void setStockItems(List<StockItem> stockItems) {
		this.stockItems = stockItems;
	}
	
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
}
