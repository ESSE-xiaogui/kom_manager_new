package com.transsion.store.dto;

import java.io.Serializable;

public class PrototypeDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;					// prototypeId

	private Long brandId;				// 品牌ID
	private String brandCode;			// 品牌代码
	private String brandName;			// 品牌名称
	
	private Long shopId;				// 店铺ID
	private String shopName;			// 店铺名称
	
	private Long modelId;				// 型号ID
	private String modelCode;			// 型号代码
	private String modelName;			// 型号名称
	private String imeiNo;				// IMEI码
	private String imeiList;			// IMEIlist
	private String imgPrototypeUrl;		// 样机图片
	private String imgShopUrl;			// 店铺图片
	private String imgImeiUrl;			// imei图片
	
	private Integer status;				// 样机状态
	private String remark;				// 备注
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelCode() {
		return modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getImeiNo() {
		return imeiNo;
	}
	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}
	public String getImeiList() {
		return imeiList;
	}
	public void setImeiList(String imeiList) {
		this.imeiList = imeiList;
	}
	public String getImgPrototypeUrl() {
		return imgPrototypeUrl;
	}
	public void setImgPrototypeUrl(String imgPrototypeUrl) {
		this.imgPrototypeUrl = imgPrototypeUrl;
	}
	public String getImgShopUrl() {
		return imgShopUrl;
	}
	public void setImgShopUrl(String imgShopUrl) {
		this.imgShopUrl = imgShopUrl;
	}
	public String getImgImeiUrl() {
		return imgImeiUrl;
	}
	public void setImgImeiUrl(String imgImeiUrl) {
		this.imgImeiUrl = imgImeiUrl;
	}
	
	public Long getModelId() {
		return modelId;
	}
	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
