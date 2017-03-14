package com.transsion.store.bo;

import java.math.BigDecimal;

import com.shangkang.core.bo.Model;

public class StockCurrent extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2032714110157021965L;
	
	private long id;
	private Integer dealerId;
	private String fdate;
	private Integer userId;
	private String brandCode;
	private String modelMatCode;
	private BigDecimal fQty;
	private Integer createBy;
	private String createTime;
	private Integer updateBy;
	private String updateTime;
	private Integer isDelete;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getDealerId() {
		return dealerId;
	}
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getModelMatCode() {
		return modelMatCode;
	}
	public void setModelMatCode(String modelMatCode) {
		this.modelMatCode = modelMatCode;
	}
	public BigDecimal getfQty() {
		return fQty;
	}
	public void setfQty(BigDecimal fQty) {
		this.fQty = fQty;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	@Override
	public String toString() {
		return "TCurrentStock [id=" + id + ", dealerId=" + dealerId + ", fdate=" + fdate + ", userId=" + userId
				+ ", brandCode=" + brandCode + ", modelMatCode=" + modelMatCode + ", fQty=" + fQty + ", createBy="
				+ createBy + ", createTime=" + createTime + ", updateBy=" + updateBy + ", updateTime=" + updateTime
				+ ", isDelete=" + isDelete + "]";
	}
}
