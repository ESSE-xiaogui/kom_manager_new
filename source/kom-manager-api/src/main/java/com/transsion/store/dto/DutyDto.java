package com.transsion.store.dto;

import java.io.Serializable;

public class DutyDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	  *	
	  */
	private Long id;

	/**
	  *	
	  */
	private Integer dutyCode;

	/**
	  *	
	  */
	private String dutyName;

	/**
	  *	
	  */
	private Integer companyId;
	
	private String companyName;

	/**
	  *	1表示激活状态，被激活有效的数据可以用于新增业务，2表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	private Integer isInactive;

	/**
	  *	
	  */
	private String remark;

	/**
	  *	
	  */
	private String createdBy;

	/**
	  *	
	  */
	private String createdTime;

	/**
	  *	
	  */
	private String updatedBy;

	/**
	  *	
	  */
	private String updatedTime;

	/**
	  *	
	  */
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDutyCode() {
		return dutyCode;
	}

	public void setDutyCode(Integer dutyCode) {
		this.dutyCode = dutyCode;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(Integer isInactive) {
		this.isInactive = isInactive;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "DutyDto [id=" + id + ", dutyCode=" + dutyCode + ", dutyName=" + dutyName + ", companyId=" + companyId
						+ ", companyName=" + companyName + ", isInactive=" + isInactive + ", remark=" + remark
						+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", updatedBy=" + updatedBy
						+ ", updatedTime=" + updatedTime + ", version=" + version + "]";
	}

}
