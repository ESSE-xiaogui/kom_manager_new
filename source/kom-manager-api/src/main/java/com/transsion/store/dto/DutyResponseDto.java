package com.transsion.store.dto;

public class DutyResponseDto {
	/**
	 * 状态 注：1： 成功 2：失败 
	 * */
	private Integer status;
	
	/**
	 * 组织机构名称
	 * */
	private String dutyName;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	@Override
	public String toString() {
		return "DutyResponseDto [status=" + status + ", dutyName=" + dutyName + "]";
	}
	
	
}
