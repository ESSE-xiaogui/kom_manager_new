package com.transsion.store.dto;

import java.io.Serializable;

public class ShopUploadDto implements Serializable {
	private static final long serialVersionUID = -7873466933053685496L;
	
	private Integer status = 0;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ShopUploadDto [status=" + status + "]";
	}
	
}	
