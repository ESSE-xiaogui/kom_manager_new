package com.transsion.store.dto;

public class StockResponseDto implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer status;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StockResponseDto [status=" + status + "]";
	}

}
