package com.transsion.store.dto;

import java.io.Serializable;

public class EmpNameDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String empName;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "EmpNameDto [empName=" + empName + "]";
	}
	
	
}
