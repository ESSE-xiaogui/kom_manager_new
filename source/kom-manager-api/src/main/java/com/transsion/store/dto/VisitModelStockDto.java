package com.transsion.store.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class VisitModelStockDto implements Serializable {
	private static final long serialVersionUID = 7899860481070140881L;
	
	private String modelName;
	private Integer stockQty;
	private BigDecimal stockIto;
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Integer getStockQty() {
		return stockQty;
	}
	public void setStockQty(Integer stockQty) {
		this.stockQty = stockQty;
	}
	public BigDecimal getStockIto() {
		return stockIto;
	}
	public void setStockIto(BigDecimal stockIto) {
		this.stockIto = stockIto;
	}
	
	@Override
	public String toString() {
		return "VisitModelStockDto [modelName=" + modelName + ", stockQty=" + stockQty + ", stockIto=" + stockIto + "]";
	}
}	
