package com.transsion.store.resource;

public enum ExceptionDef {

	USER_ERROR(100, "USER_ERROR"),
	USER_ERROR_LOGIN(101, "USER_ERROR_LOGIN");

	private int value;
	private String desc;

	private ExceptionDef(int value, String desc) {
		this.setValue(value);
		this.setDesc(desc);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "[" + this.value + "]" + this.desc;
	}

}
