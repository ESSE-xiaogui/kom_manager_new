package com.transsion.store.dto;


import java.util.Map;

public class TaskSaleDto {
	
	public static final String HEADER_SALES_DATE = "Sales date";
	public static final String HEADER_SHOP_CODE = "Shop code";
	public static final String HEADER_USER_ID = "User ID";
	public static final String HEADER_IMEI_NO = "IMEI code";
	public static final String HEADER_PRICE = "Price";
	
	public static String[]  IMPORT_HEADERS= {HEADER_SALES_DATE,HEADER_SHOP_CODE,HEADER_USER_ID,HEADER_IMEI_NO,HEADER_PRICE};
	
	private String saleDate;
	private String shopCode;
	private String userCode;
	private String imeiNo;
	private String price;
	private String context;
	
	public void copyFormMap(Map<String, Object> importMap)
	{
		 saleDate = (String) importMap.get(HEADER_SALES_DATE);
		 shopCode = (String) importMap.get(HEADER_SHOP_CODE);
		 userCode = (String) importMap.get(HEADER_USER_ID);
		 imeiNo = (String) importMap.get(HEADER_IMEI_NO);
		 price = (String) importMap.get(HEADER_PRICE);
	}

	public String getSaleDate() {
		return saleDate;
	}


	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}


	public String getShopCode() {
		return shopCode;
	}


	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}


	public String getUserCode() {
		return userCode;
	}


	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public String getImeiNo() {
		return imeiNo;
	}


	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setContext(String context) {
		this.context = context;
	}
	
	public String getContext(){
		context = HEADER_SALES_DATE + ":" + saleDate + "\r" + HEADER_SHOP_CODE + ":"
						+ shopCode + "\r" + HEADER_USER_ID + ":" + userCode + "\r"
					  + HEADER_IMEI_NO + ":" + imeiNo + "\r" + HEADER_PRICE + ":" + price;
		return context;
	}
}
