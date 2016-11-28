package com.transsion.store.dto;

public class RegionResponseDto {
	/**
	 * 状态 注：1： 成功 2：失败
	 * */
	private Integer status;
	
	/**
	 * 销售区域名称
	 * */
	private String regionName;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Override
	public String toString() {
		return "RegionResponseDto [status=" + status + ", regionName=" + regionName + "]";
	}
	
	
}
