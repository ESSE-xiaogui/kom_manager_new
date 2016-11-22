package com.transsion.store.dto;

import java.io.Serializable;

public class BrandResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 状态 注：1成功 2失败。
	 * */
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BrandResponseDto [status=" + status + "]";
	}
}
