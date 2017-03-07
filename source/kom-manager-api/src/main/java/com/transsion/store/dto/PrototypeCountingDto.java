package com.transsion.store.dto;

import java.io.Serializable;

public class PrototypeCountingDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5443543464575767494L;

	private Long id;					
	private Long prototypeId;			// prototypeId
	private Long brandId;				// 品牌ID
	private String companyCode;			//事业部
	private String brandName;			// 品牌名称
	private Long shopId;				// 店铺ID
	private String shopCode;			// 店铺编码
	private String shopName;			// 店铺名称
	private Long modelId;				// 型号ID
	private Long regionId;				//国家区域ID
	private Long regionType;            //
	private Long companyId;				//事业部ID
	private String modelCode;			// 型号代码
	private String modelName;			// 机型名称
	private String countingTime;		//计划盘点日期
	private String countingBy;			//计划盘点人
	private String countingTimeStart;
	private String countingTimeEnd;
	private String createBy; 			//上传用户
	private String createTime;			//上传时间
	private String createTimeStart;
	private String createTimeEnd;
	private String empName;	 			//员工姓名
	private String countryName;			// 国家
	private String cityName;			// 城市
	private String imeiNo;				// IMEI码
	private String imeiList;			// IMEIlist
	private String imgPrototypeUrl;		// 样机图片
	private String imgShopUrl;			// 店铺图片
	private String imgImeiUrl;			// imei图片
	private Integer status;				// 盘点状态
	private String remark;				// 备注
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPrototypeId() {
		return prototypeId;
	}
	public void setPrototypeId(Long prototypeId) {
		this.prototypeId = prototypeId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Long getModelId() {
		return modelId;
	}
	public void setModelId(Long modelId) {
		this.modelId = modelId;
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
	public String getCountingTime() {
		return countingTime;
	}
	public void setCountingTime(String countingTime) {
		this.countingTime = countingTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateTimeStart() {
		return createTimeStart;
	}
	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}
	public String getCreateTimeEnd() {
		return createTimeEnd;
	}
	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
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
	
	public String getCountingBy() {
		return countingBy;
	}
	public void setCountingBy(String countingBy) {
		this.countingBy = countingBy;
	}
	public String getCountingTimeStart() {
		return countingTimeStart;
	}
	public void setCountingTimeStart(String countingTimeStart) {
		this.countingTimeStart = countingTimeStart;
	}
	public String getCountingTimeEnd() {
		return countingTimeEnd;
	}
	public void setCountingTimeEnd(String countingTimeEnd) {
		this.countingTimeEnd = countingTimeEnd;
	}
	
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	public Long getRegionType() {
		return regionType;
	}
	public void setRegionType(Long regionType) {
		this.regionType = regionType;
	}
	@Override
	public String toString() {
		return "PrototypeCountingDto [id=" + id + ", prototypeId=" + prototypeId + ", brandId=" + brandId
						+ ", companyCode=" + companyCode + ", brandName=" + brandName + ", shopId=" + shopId
						+ ", shopCode=" + shopCode + ", shopName=" + shopName + ", modelId=" + modelId + ", regionId="
						+ regionId + ", regionType=" + regionType + ", companyId=" + companyId + ", modelCode="
						+ modelCode + ", modelName=" + modelName + ", countingTime=" + countingTime + ", countingBy="
						+ countingBy + ", countingTimeStart=" + countingTimeStart + ", countingTimeEnd="
						+ countingTimeEnd + ", createBy=" + createBy + ", createTime=" + createTime
						+ ", createTimeStart=" + createTimeStart + ", createTimeEnd=" + createTimeEnd + ", empName="
						+ empName + ", countryName=" + countryName + ", cityName=" + cityName + ", imeiNo=" + imeiNo
						+ ", imeiList=" + imeiList + ", imgPrototypeUrl=" + imgPrototypeUrl + ", imgShopUrl="
						+ imgShopUrl + ", imgImeiUrl=" + imgImeiUrl + ", status=" + status + ", remark=" + remark + "]";
	}


	
}
