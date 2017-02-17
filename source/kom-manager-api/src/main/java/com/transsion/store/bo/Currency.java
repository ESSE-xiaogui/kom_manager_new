/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-5-27 15:55:54
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import java.math.BigDecimal;

import com.shangkang.core.bo.Model;

public class Currency extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private Long id;

	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	private Long companyId;
	
	private Long regionId;


	/**
	  *	
	  */
	private Integer findex;

	/**
	  *	参数的实际值，可能有多种数据类型，但同一按照字符串的方式保存
	  */
	private String werks;

	/**
	  *	参数的中文名称
	  */
	private String currencyName;

	/**
	  *	
	  */
	private BigDecimal exchangerate;

	/**
	  *	
	  */
	private BigDecimal exchangerate2;

	/**
	  *	
	  */
	private String beginTime;

	/**
	  *	
	  */
	private String endTime;

	/**
	  *	0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	private Integer isInactive;
	
	/**
	  *	
	  */
	private String createdBy;

	/**
	  *	
	  */
	private String createdTime;

	/**
	  *	系统保留字段，记录数据最后更新用户，用于审计，无业务含义
	  */
	private String updatedBy;

	/**
	  *	系统保留字段，记录数据最后时间，用于审计，无业务含义
	  */
	private String updatedTime;

	/**
	  *	系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
	  */
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public Integer getFindex() {
		return findex;
	}

	public void setFindex(Integer findex) {
		this.findex = findex;
	}

	public String getWerks() {
		return werks;
	}

	public void setWerks(String werks) {
		this.werks = werks;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public BigDecimal getExchangerate() {
		return exchangerate;
	}

	public void setExchangerate(BigDecimal exchangerate) {
		this.exchangerate = exchangerate;
	}

	public BigDecimal getExchangerate2() {
		return exchangerate2;
	}

	public void setExchangerate2(BigDecimal exchangerate2) {
		this.exchangerate2 = exchangerate2;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(Integer isInactive) {
		this.isInactive = isInactive;
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
		return "Currency [id=" + id + ", companyId=" + companyId + ", regionId=" + regionId + ", findex=" + findex
						+ ", werks=" + werks + ", currencyName=" + currencyName + ", exchangerate=" + exchangerate
						+ ", exchangerate2=" + exchangerate2 + ", beginTime=" + beginTime + ", endTime=" + endTime
						+ ", isInactive=" + isInactive + ", createdBy=" + createdBy + ", createdTime=" + createdTime
						+ ", updatedBy=" + updatedBy + ", updatedTime=" + updatedTime + ", version=" + version + "]";
	}



	
}

