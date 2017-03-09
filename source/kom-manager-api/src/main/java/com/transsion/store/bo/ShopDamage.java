/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-9 15:06:14
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class ShopDamage extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long damageId;

	/**
	  *	
	  */
	private java.lang.Long shopId;

	/**
	  *	
	  */
	private java.lang.Long materielId;

	/**
	  *	
	  */
	private java.lang.String damageTime;

	/**
	  *	
	  */
	private java.lang.String description;

	/**
	  *	损坏照片
	  */
	private java.lang.String imgFirstUrl;

	/**
	  *	
	  */
	private java.lang.String imgSecondUrl;

	/**
	  *	
	  */
	private java.lang.String imgThirdUrl;

	/**
	  *	
	  */
	private java.lang.String remark;

	/**
	  *	
	  */
	private java.lang.String createBy;

	/**
	  *	
	  */
	private java.lang.String createTime;

	/**
	  *	
	  */
	private java.lang.String updateBy;

	/**
	  *	
	  */
	private java.lang.String updateTime;

	/**
	  *	
	  */
	private java.lang.Integer version;

	/**
	  *	
	  */
	public java.lang.Long getDamageId() 
	{
		return damageId;
	}
	
	/**
	  *	
	  */
	public void setDamageId(java.lang.Long damageId) 
	{
		this.damageId = damageId;
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
	  *	
	  */
	public java.lang.Long getMaterielId() 
	{
		return materielId;
	}
	
	/**
	  *	
	  */
	public void setMaterielId(java.lang.Long materielId) 
	{
		this.materielId = materielId;
	}
	
	/**
	  *	
	  */
	public java.lang.String getDamageTime() 
	{
		return damageTime;
	}
	
	/**
	  *	
	  */
	public void setDamageTime(java.lang.String damageTime) 
	{
		this.damageTime = damageTime;
	}
	
	/**
	  *	
	  */
	public java.lang.String getDescription() 
	{
		return description;
	}
	
	/**
	  *	
	  */
	public void setDescription(java.lang.String description) 
	{
		this.description = description;
	}
	
	/**
	  *	损坏照片
	  */
	public java.lang.String getImgFirstUrl() 
	{
		return imgFirstUrl;
	}
	
	/**
	  *	损坏照片
	  */
	public void setImgFirstUrl(java.lang.String imgFirstUrl) 
	{
		this.imgFirstUrl = imgFirstUrl;
	}
	
	/**
	  *	
	  */
	public java.lang.String getImgSecondUrl() 
	{
		return imgSecondUrl;
	}
	
	/**
	  *	
	  */
	public void setImgSecondUrl(java.lang.String imgSecondUrl) 
	{
		this.imgSecondUrl = imgSecondUrl;
	}
	
	/**
	  *	
	  */
	public java.lang.String getImgThirdUrl() 
	{
		return imgThirdUrl;
	}
	
	/**
	  *	
	  */
	public void setImgThirdUrl(java.lang.String imgThirdUrl) 
	{
		this.imgThirdUrl = imgThirdUrl;
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
	  *	
	  */
	public java.lang.String getCreateBy() 
	{
		return createBy;
	}
	
	/**
	  *	
	  */
	public void setCreateBy(java.lang.String createBy) 
	{
		this.createBy = createBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCreateTime() 
	{
		return createTime;
	}
	
	/**
	  *	
	  */
	public void setCreateTime(java.lang.String createTime) 
	{
		this.createTime = createTime;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUpdateBy() 
	{
		return updateBy;
	}
	
	/**
	  *	
	  */
	public void setUpdateBy(java.lang.String updateBy) 
	{
		this.updateBy = updateBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUpdateTime() 
	{
		return updateTime;
	}
	
	/**
	  *	
	  */
	public void setUpdateTime(java.lang.String updateTime) 
	{
		this.updateTime = updateTime;
	}
	
	/**
	  *	
	  */
	public java.lang.Integer getVersion() 
	{
		return version;
	}
	
	/**
	  *	
	  */
	public void setVersion(java.lang.Integer version) 
	{
		this.version = version;
	}
	
	public String toString()
	{
		return "ShopDamage [" + 
					"damageId=" + damageId + 
					", shopId=" + shopId + 
					", materielId=" + materielId + 
					", damageTime=" + damageTime + 
					", description=" + description + 
					", imgFirstUrl=" + imgFirstUrl + 
					", imgSecondUrl=" + imgSecondUrl + 
					", imgThirdUrl=" + imgThirdUrl + 
					", remark=" + remark + 
					", createBy=" + createBy + 
					", createTime=" + createTime + 
					", updateBy=" + updateBy + 
					", updateTime=" + updateTime + 
					", version=" + version + 
				"]";
	}
}

