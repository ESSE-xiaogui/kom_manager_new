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
	
	private Long country;


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
	private java.math.BigDecimal exchangerate;

	/**
	  *	
	  */
	private java.math.BigDecimal exchangerate2;

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
	private java.lang.Long createdBy;

	/**
	  *	
	  */
	private java.lang.String createdTime;

	/**
	  *	系统保留字段，记录数据最后更新用户，用于审计，无业务含义
	  */
	private Long updatedBy;

	/**
	  *	系统保留字段，记录数据最后时间，用于审计，无业务含义
	  */
	private String updatedTime;

	/**
	  *	系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
	  */
	private Integer version;

	/**
	  *	
	  */
	public Long getId()
	{
		return id;
	}
	
	/**
	  *	
	  */
	public void setId(Long id)
	{
		this.id = id;
	}
	
	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	public Long getCompanyId()
	{
		return companyId;
	}
	
	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	public void setCompanyId(Long companyId)
	{
		this.companyId = companyId;
	}
	
	public Long getCountry() {
		return country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}

	
	/**
	  *	
	  */
	public Integer getFindex()
	{
		return findex;
	}
	
	/**
	  *	
	  */
	public void setFindex(Integer findex)
	{
		this.findex = findex;
	}
	
	/**
	  *	参数的实际值，可能有多种数据类型，但同一按照字符串的方式保存
	  */
	public String getWerks()
	{
		return werks;
	}
	
	/**
	  *	参数的实际值，可能有多种数据类型，但同一按照字符串的方式保存
	  */
	public void setWerks(String werks)
	{
		this.werks = werks;
	}
	
	/**
	  *	参数的中文名称
	  */
	public String getCurrencyName()
	{
		return currencyName;
	}
	
	/**
	  *	参数的中文名称
	  */
	public void setCurrencyName(String currencyName)
	{
		this.currencyName = currencyName;
	}
	
	/**
	  *	
	  */
	public java.math.BigDecimal getExchangerate() 
	{
		return exchangerate;
	}
	
	/**
	  *	
	  */
	public void setExchangerate(java.math.BigDecimal exchangerate) 
	{
		this.exchangerate = exchangerate;
	}
	
	/**
	  *	
	  */
	public java.math.BigDecimal getExchangerate2() 
	{
		return exchangerate2;
	}
	
	/**
	  *	
	  */
	public void setExchangerate2(java.math.BigDecimal exchangerate2) 
	{
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

	/**
	  *	0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	public Integer getIsInactive()
	{
		return isInactive;
	}
	
	/**
	  *	0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	public void setIsInactive(Integer isInactive)
	{
		this.isInactive = isInactive;
	}
	
	public java.lang.Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(java.lang.Long createdBy) {
		this.createdBy = createdBy;
	}

	public java.lang.String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(java.lang.String createdTime) {
		this.createdTime = createdTime;
	}

	/**
	  *	系统保留字段，记录数据最后更新用户，用于审计，无业务含义
	  */
	public Long getUpdatedBy()
	{
		return updatedBy;
	}
	
	/**
	  *	系统保留字段，记录数据最后更新用户，用于审计，无业务含义
	  */
	public void setUpdatedBy(Long updatedBy)
	{
		this.updatedBy = updatedBy;
	}
	
	/**
	  *	系统保留字段，记录数据最后时间，用于审计，无业务含义
	  */
	public String getUpdatedTime()
	{
		return updatedTime;
	}
	
	/**
	  *	系统保留字段，记录数据最后时间，用于审计，无业务含义
	  */
	public void setUpdatedTime(String updatedTime)
	{
		this.updatedTime = updatedTime;
	}
	
	/**
	  *	系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
	  */
	public Integer getVersion()
	{
		return version;
	}
	
	/**
	  *	系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义
	  */
	public void setVersion(Integer version)
	{
		this.version = version;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", companyId=" + companyId + ", country=" + country + ", findex=" + findex
						+ ", werks=" + werks + ", currencyName=" + currencyName + ", exchangerate=" + exchangerate
						+ ", exchangerate2=" + exchangerate2 + ", beginTime=" + beginTime + ", endTime=" + endTime
						+ ", isInactive=" + isInactive + ", createdBy=" + createdBy + ", createdTime=" + createdTime
						+ ", updatedBy=" + updatedBy + ", updatedTime=" + updatedTime + ", version=" + version + "]";
	}

	
}

