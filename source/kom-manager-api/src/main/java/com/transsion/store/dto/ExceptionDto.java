package com.transsion.store.dto;

import java.io.Serializable;

import com.transsion.store.exception.ExceptionDef;

public class ExceptionDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;

	private String name;

	public ExceptionDto() {
	}

	public ExceptionDto(ExceptionDef excepDef) {
		this.code = excepDef.getCode();
		this.name=excepDef.getName();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ExceptionDto [code=" + code + ", name=" + name + "]";
	}

}
