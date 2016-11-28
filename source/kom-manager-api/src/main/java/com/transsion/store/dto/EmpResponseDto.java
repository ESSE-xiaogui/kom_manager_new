package com.transsion.store.dto;

public class EmpResponseDto {
	/**
	 * 状态 注：1： 成功 2：失败 
	 * */
	private Integer status;
	
	/**
	 * 员工姓名
	 * */
	private String empName;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "EmpResponseDto [status=" + status + ", empName=" + empName + "]";
	}

}
