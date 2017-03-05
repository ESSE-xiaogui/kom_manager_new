package com.transsion.store.dto;

import java.io.Serializable;

public class PrototypeDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;					// prototypeId

	private Long brandId;				// 品牌ID
	private String brandCode;			// 品牌代码
	private String brandName;			// 品牌名称
	private Long shopId;				// 店铺ID
	private String shopCode;			// 店铺编码
	private String shopName;			// 店铺名称
	private Long modelId;				// 型号ID
	private String modelCode;			// 型号代码
	private String modelName;			// 型号名称
	private String countryName;			// 国家
	private String cityName;			// 城市
	private String imeiNo;				// IMEI码
	private String imeiList;			// IMEIlist
	private String imgPrototypeUrl;		// 样机图片
	private String imgShopUrl;			// 店铺图片
	private String imgImeiUrl;			// imei图片
	private Integer status;				// 样机状态
	private String remark;				// 备注
	private String unpublishCause;		// 下架原因
	private String countingTime;		// 计划盘点时间
	
	private String publishBy;			// 上架人CODE
	private String publishTime;			// 上架时间
	private String beginPublishTime;	// 上架开始时间
	private String endPublishTime;		// 上架结束时间
	
	private String unpublishBy;			// 下架人CODE
	private String unpublishTime;		// 下架时间
	private String beginUnpublishTime;	// 下架开始时间
	private String endUnpublishTime;	// 下架结束时间
	private Long companyId;				// 事业部ID
	private String companyName;			// 事业部名称
	
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
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
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
	
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
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
	
	public String getUnpublishCause() {
		return unpublishCause;
	}
	public void setUnpublishCause(String unpublishCause) {
		this.unpublishCause = unpublishCause;
	}
	
	public String getCountingTime() {
		return countingTime;
	}
	public void setCountingTime(String countingTime) {
		this.countingTime = countingTime;
	}
	public String getPublishBy() {
		return publishBy;
	}
	public void setPublishBy(String publishBy) {
		this.publishBy = publishBy;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getBeginPublishTime() {
		return beginPublishTime;
	}
	public void setBeginPublishTime(String beginPublishTime) {
		this.beginPublishTime = beginPublishTime;
	}
	public String getEndPublishTime() {
		return endPublishTime;
	}
	public void setEndPublishTime(String endPublishTime) {
		this.endPublishTime = endPublishTime;
	}
	public String getUnpublishBy() {
		return unpublishBy;
	}
	public void setUnpublishBy(String unpublishBy) {
		this.unpublishBy = unpublishBy;
	}
	public String getUnpublishTime() {
		return unpublishTime;
	}
	public void setUnpublishTime(String unpublishTime) {
		this.unpublishTime = unpublishTime;
	}
	public String getBeginUnpublishTime() {
		return beginUnpublishTime;
	}
	public void setBeginUnpublishTime(String beginUnpublishTime) {
		this.beginUnpublishTime = beginUnpublishTime;
	}
	public String getEndUnpublishTime() {
		return endUnpublishTime;
	}
	public void setEndUnpublishTime(String endUnpublishTime) {
		this.endUnpublishTime = endUnpublishTime;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}