/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-14 13:59:40
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class AreaShop extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long areaShopId;

	/**
	  *	
	  */
	private java.lang.Long companyId;

	/**
	  *	
	  */
	private java.lang.Long areaId;

	/**
	  *	
	  */
	private java.lang.Long shopId;

	/**
	  *	1:å¯ç”¨ 2ï¼šåœç”¨
	  */
	private java.lang.Integer isInactive;

	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®åˆ›å»ºç”¨æˆ·ï¼Œç”¨äºŽå®¡è®¡ï¼Œæ— ä¸šåŠ¡å«ä¹‰
	  */
	private java.lang.String createdBy;

	/**
	  *	ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®åˆ›å»ºæ—¶é—´ï¼Œç”¨äºŽç³»ç»Ÿå®¡è®¡ï¼Œæ— å®žé™…ä¸šåŠ¡å«ä¹‰
	  */
	private java.lang.String createdTime;

	/**
	  *	ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®æœ€åŽæ›´æ–°ç”¨æˆ·ï¼Œç”¨äºŽå®¡è®¡ï¼Œæ— ä¸šåŠ¡å«ä¹‰
	  */
	private java.lang.String updatedBy;

	/**
	  *	ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®æœ€åŽæ—¶é—´ï¼Œç”¨äºŽå®¡è®¡ï¼Œæ— ä¸šåŠ¡å«ä¹‰
	  */
	private java.lang.String updatedTime;


	public java.lang.Long getAreaShopId() {
		return areaShopId;
	}

	public void setAreaShopId(java.lang.Long areaShopId) {
		this.areaShopId = areaShopId;
	}

	public java.lang.Long getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	
	  */
	public void setCompanyId(java.lang.Long companyId) 
	{
		this.companyId = companyId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getAreaId() 
	{
		return areaId;
	}
	
	/**
	  *	
	  */
	public void setAreaId(java.lang.Long areaId) 
	{
		this.areaId = areaId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getShopId() 
	{
		return shopId;
	}
	
	/**
	  *	
	  */
	public void setShopId(java.lang.Long shopId) 
	{
		this.shopId = shopId;
	}
	
	/**
	  *	1:å¯ç”¨ 2ï¼šåœç”¨
	  */
	public java.lang.Integer getIsInactive() 
	{
		return isInactive;
	}
	
	/**
	  *	1:å¯ç”¨ 2ï¼šåœç”¨
	  */
	public void setIsInactive(java.lang.Integer isInactive) 
	{
		this.isInactive = isInactive;
	}
	
	/**
	  *	
	  */
	public java.lang.String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	
	  */
	public void setRemark(java.lang.String remark) 
	{
		this.remark = remark;
	}
	
	/**
	  *	ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®åˆ›å»ºç”¨æˆ·ï¼Œç”¨äºŽå®¡è®¡ï¼Œæ— ä¸šåŠ¡å«ä¹‰
	  */
	public java.lang.String getCreatedBy() 
	{
		return createdBy;
	}
	
	/**
	  *	ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®åˆ›å»ºç”¨æˆ·ï¼Œç”¨äºŽå®¡è®¡ï¼Œæ— ä¸šåŠ¡å«ä¹‰
	  */
	public void setCreatedBy(java.lang.String createdBy) 
	{
		this.createdBy = createdBy;
	}
	
	/**
	  *	ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®åˆ›å»ºæ—¶é—´ï¼Œç”¨äºŽç³»ç»Ÿå®¡è®¡ï¼Œæ— å®žé™…ä¸šåŠ¡å«ä¹‰
	  */
	public java.lang.String getCreatedTime() 
	{
		return createdTime;
	}
	
	/**
	  *	ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®åˆ›å»ºæ—¶é—´ï¼Œç”¨äºŽç³»ç»Ÿå®¡è®¡ï¼Œæ— å®žé™…ä¸šåŠ¡å«ä¹‰
	  */
	public void setCreatedTime(java.lang.String createdTime) 
	{
		this.createdTime = createdTime;
	}
	
	/**
	  *	ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®æœ€åŽæ›´æ–°ç”¨æˆ·ï¼Œç”¨äºŽå®¡è®¡ï¼Œæ— ä¸šåŠ¡å«ä¹‰
	  */
	public java.lang.String getUpdatedBy() 
	{
		return updatedBy;
	}
	
	/**
	  *	ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®æœ€åŽæ›´æ–°ç”¨æˆ·ï¼Œç”¨äºŽå®¡è®¡ï¼Œæ— ä¸šåŠ¡å«ä¹‰
	  */
	public void setUpdatedBy(java.lang.String updatedBy) 
	{
		this.updatedBy = updatedBy;
	}
	
	/**
	  *	ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®æœ€åŽæ—¶é—´ï¼Œç”¨äºŽå®¡è®¡ï¼Œæ— ä¸šåŠ¡å«ä¹‰
	  */
	public java.lang.String getUpdatedTime() 
	{
		return updatedTime;
	}
	
	/**
	  *	ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®æœ€åŽæ—¶é—´ï¼Œç”¨äºŽå®¡è®¡ï¼Œæ— ä¸šåŠ¡å«ä¹‰
	  */
	public void setUpdatedTime(java.lang.String updatedTime) 
	{
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "AreaShop [areaShopId=" + areaShopId + ", companyId=" + companyId + ", areaId=" + areaId + ", shopId="
						+ shopId + ", isInactive=" + isInactive + ", remark=" + remark + ", createdBy=" + createdBy
						+ ", createdTime=" + createdTime + ", updatedBy=" + updatedBy + ", updatedTime=" + updatedTime
						+ "]";
	}
	

}

