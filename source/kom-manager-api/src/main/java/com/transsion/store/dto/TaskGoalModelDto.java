package com.transsion.store.dto;

import java.io.Serializable;
import java.util.Map;

public class TaskGoalModelDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String HEADER_COMPANY_CODE = "事业部";
	public static final String HEADER_GOAL_MONTH = "年/月";
	public static final String HEADER_USER_CODE = "用户名";
	public static final String HEADER_SHOP_CODE = "门店编码";
	public static final String HEADER_MODEL_CODE = "重点机型";
	public static final String HEADER_SALE_TARGET = "销量目标";
	
	public static String[]  IMPORT_HEADERS= {HEADER_COMPANY_CODE,HEADER_GOAL_MONTH,HEADER_USER_CODE,HEADER_SHOP_CODE,HEADER_MODEL_CODE,HEADER_SALE_TARGET};
	
	//Excel中字段
	private String companyCode;
	private String goalMonth;
	private String userCode;
	private String shopCode;
	private String modelCode;
	private String saleTarget;
	
	//额外字段
	private Long companyId;
	private Long modelId;
	private Long shopId;
	
	//task表
	private String context;
	
	public void copyFormMap(Map<String, Object> importMap)
	{
		companyCode = (String) importMap.get(HEADER_COMPANY_CODE);
		goalMonth = (String) importMap.get(HEADER_GOAL_MONTH);
		userCode = (String) importMap.get(HEADER_USER_CODE);
		shopCode = (String) importMap.get(HEADER_SHOP_CODE);
		modelCode = (String) importMap.get(HEADER_MODEL_CODE);
		saleTarget = (String)importMap.get(HEADER_SALE_TARGET); 
	}


	public String getCompanyCode() {
		return companyCode;
	}


	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}


	public String getGoalMonth() {
		return goalMonth;
	}


	public void setGoalMonth(String goalMonth) {
		this.goalMonth = goalMonth;
	}


	public String getUserCode() {
		return userCode;
	}


	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public String getShopCode() {
		return shopCode;
	}


	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}


	public String getModelCode() {
		return modelCode;
	}


	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getSaleTarget() {
		return saleTarget;
	}


	public void setSaleTarget(String saleTarget) {
		this.saleTarget = saleTarget;
	}


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	public Long getModelId() {
		return modelId;
	}


	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}


	public Long getShopId() {
		return shopId;
	}


	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}


	public void setContext(String context) {
		this.context = context;
	}


	public String getContext(){
		context = HEADER_COMPANY_CODE +":" +companyCode + "\r" + HEADER_GOAL_MONTH+":"
						+ goalMonth + "\r" + HEADER_USER_CODE+":" + userCode + "\r"
						+ HEADER_SHOP_CODE+":"+ shopCode+ "\r" +HEADER_MODEL_CODE+":"+modelCode+"\r"+
						HEADER_SALE_TARGET+":"+saleTarget;
		return context;
	}


}
