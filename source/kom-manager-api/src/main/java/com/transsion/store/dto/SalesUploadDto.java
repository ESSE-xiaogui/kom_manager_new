package com.transsion.store.dto;

/**
 * @author guihua.zhang on 2016/08/03
 * */
public class SalesUploadDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String imei;
	/**
	 * 日期
	 * */
	private String day;
	/**
	 * 状态
	 * 0：imei未处理 1：imei成功 2：imei重复 3：imei非法 4:品牌为空5:品牌为TECNO时候，IMEI为空6:前端传入重复IMEI 7:cache imei处理中
	 * */
	private Integer status = 0;
	
	private Integer dealerId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * 状态
	 * 0：imei未处理 1：imei成功 2：imei重复 3：imei非法 4:品牌为空 5:品牌为TECNO时候，IMEI为空6:前端传入重复IMEI
	 * */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 状态
	 * 0：imei未处理 1：imei成功 2：imei重复 3：imei非法 4:品牌为空 5:品牌为TECNO时候，IMEI为空6:前端传入重复IMEI
	 * */
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getDealerId() {
		return dealerId;
	}
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}
	
	@Override
	public String toString() {
		return "SalesUploadDto [id=" + id + ", imei=" + imei + ", day=" + day + ", status=" + status + ", dealerId="
				+ dealerId + "]";
	}
}
