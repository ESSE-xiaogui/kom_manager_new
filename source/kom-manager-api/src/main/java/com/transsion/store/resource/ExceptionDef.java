package com.transsion.store.resource;

public enum ExceptionDef {

	USER_ERROR(100, "USER_ERROR"),
	USER_ERROR_LOGIN(101, "USER_ERROR_LOGIN"),

	SALE_ERROR(200, "SALE_ERROR"),
	
	STOCK_ERROR(300, "STOCK_ERROR"),
	
	BASIC_ERROR(400, "BASIC_ERROR"),
	
	BRAND_ERROR(500, "BRAND_ERROR"),
	
	MODEL_ERROR(600, "MODEL_ERROR"),
	
	SHOP_ERROR(700, "SHOP_ERROR"),
	
	REGION_ERROR(800, "REGION_ERROR");
	
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
