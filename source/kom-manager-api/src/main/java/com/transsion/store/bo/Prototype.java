/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-1 16:30:39
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class Prototype extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	private java.lang.Long companyId;

	/**
	  *	
	  */
	private java.lang.Long shopId;

	/**
	  *	
	  */
	private java.lang.Long brandId;

	/**
	  *	
	  */
	private java.lang.String brandCode;

	/**
	  *	
	  */
	private java.lang.Long modelId;

	/**
	  *	机型代码
	  */
	private java.lang.String modelCode;

	/**
	  *	
	  */
	private java.lang.String imeiNo;

	/**
	  *	
	  */
	private java.lang.String imeiList;

	/**
	  *	
	  */
	private java.lang.String imgPrototypeUrl;

	/**
	  *	
	  */
	private java.lang.String imgShopUrl;

	/**
	  *	
	  */
	private java.lang.String imgImeiUrl;

	/**
	  *	1,publish; 2,unpublish
	  */
	private java.lang.Integer status;

	/**
	  *	
	  */
	private java.lang.String publishBy;

	/**
	  *	
	  */
	private java.lang.String publishTime;

	/**
	  *	
	  */
	private java.lang.String unpublishBy;

	/**
	  *	
	  */
	private java.lang.String unpublishTime;

	/**
	  *	
	  */
	private java.lang.String unpublishCause;

	/**
	  *	备注-512
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
	public java.lang.Long getId() 
	{
		return id;
	}
	
	/**
	  *	
	  */
	public void setId(java.lang.Long id) 
	{
		this.id = id;
	}
	
	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	public java.lang.Long getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	指使用系统的公司，即事业部或经销商对应的公司
	  */
	public void setCompanyId(java.lang.Long companyId) 
	{
		this.companyId = companyId;
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
	public java.lang.Long getBrandId() 
	{
		return brandId;
	}
	
	/**
	  *	
	  */
	public void setBrandId(java.lang.Long brandId) 
	{
		this.brandId = brandId;
	}
	
	/**
	  *	
	  */
	public java.lang.String getBrandCode() 
	{
		return brandCode;
	}
	
	/**
	  *	
	  */
	public void setBrandCode(java.lang.String brandCode) 
	{
		this.brandCode = brandCode;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getModelId() 
	{
		return modelId;
	}
	
	/**
	  *	
	  */
	public void setModelId(java.lang.Long modelId) 
	{
		this.modelId = modelId;
	}
	
	/**
	  *	机型代码
	  */
	public java.lang.String getModelCode() 
	{
		return modelCode;
	}
	
	/**
	  *	机型代码
	  */
	public void setModelCode(java.lang.String modelCode) 
	{
		this.modelCode = modelCode;
	}
	
	/**
	  *	
	  */
	public java.lang.String getImeiNo() 
	{
		return imeiNo;
	}
	
	/**
	  *	
	  */
	public void setImeiNo(java.lang.String imeiNo) 
	{
		this.imeiNo = imeiNo;
	}
	
	/**
	  *	
	  */
	public java.lang.String getImeiList() 
	{
		return imeiList;
	}
	
	/**
	  *	
	  */
	public void setImeiList(java.lang.String imeiList) 
	{
		this.imeiList = imeiList;
	}
	
	/**
	  *	
	  */
	public java.lang.String getImgPrototypeUrl() 
	{
		return imgPrototypeUrl;
	}
	
	/**
	  *	
	  */
	public void setImgPrototypeUrl(java.lang.String imgPrototypeUrl) 
	{
		this.imgPrototypeUrl = imgPrototypeUrl;
	}
	
	/**
	  *	
	  */
	public java.lang.String getImgShopUrl() 
	{
		return imgShopUrl;
	}
	
	/**
	  *	
	  */
	public void setImgShopUrl(java.lang.String imgShopUrl) 
	{
		this.imgShopUrl = imgShopUrl;
	}
	
	/**
	  *	
	  */
	public java.lang.String getImgImeiUrl() 
	{
		return imgImeiUrl;
	}
	
	/**
	  *	
	  */
	public void setImgImeiUrl(java.lang.String imgImeiUrl) 
	{
		this.imgImeiUrl = imgImeiUrl;
	}
	
	/**
	  *	1,publish; 2,unpublish
	  */
	public java.lang.Integer getStatus() 
	{
		return status;
	}
	
	/**
	  *	1,publish; 2,unpublish
	  */
	public void setStatus(java.lang.Integer status) 
	{
		this.status = status;
	}
	
	/**
	  *	
	  */
	public java.lang.String getPublishBy() 
	{
		return publishBy;
	}
	
	/**
	  *	
	  */
	public void setPublishBy(java.lang.String publishBy) 
	{
		this.publishBy = publishBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getPublishTime() 
	{
		return publishTime;
	}
	
	/**
	  *	
	  */
	public void setPublishTime(java.lang.String publishTime) 
	{
		this.publishTime = publishTime;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUnpublishBy() 
	{
		return unpublishBy;
	}
	
	/**
	  *	
	  */
	public void setUnpublishBy(java.lang.String unpublishBy) 
	{
		this.unpublishBy = unpublishBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUnpublishTime() 
	{
		return unpublishTime;
	}
	
	/**
	  *	
	  */
	public void setUnpublishTime(java.lang.String unpublishTime) 
	{
		this.unpublishTime = unpublishTime;
	}
	
	/**
	  *	
	  */
	public java.lang.String getUnpublishCause() 
	{
		return unpublishCause;
	}
	
	/**
	  *	
	  */
	public void setUnpublishCause(java.lang.String unpublishCause) 
	{
		this.unpublishCause = unpublishCause;
	}
	
	/**
	  *	备注-512
	  */
	public java.lang.String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	备注-512
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
		return "Prototype [" + 
					"id=" + id + 
					", companyId=" + companyId + 
					", shopId=" + shopId + 
					", brandId=" + brandId + 
					", brandCode=" + brandCode + 
					", modelId=" + modelId + 
					", modelCode=" + modelCode + 
					", imeiNo=" + imeiNo + 
					", imeiList=" + imeiList + 
					", imgPrototypeUrl=" + imgPrototypeUrl + 
					", imgShopUrl=" + imgShopUrl + 
					", imgImeiUrl=" + imgImeiUrl + 
					", status=" + status + 
					", publishBy=" + publishBy + 
					", publishTime=" + publishTime + 
					", unpublishBy=" + unpublishBy + 
					", unpublishTime=" + unpublishTime + 
					", unpublishCause=" + unpublishCause + 
					", remark=" + remark + 
					", createBy=" + createBy + 
					", createTime=" + createTime + 
					", updateBy=" + updateBy + 
					", updateTime=" + updateTime + 
					", version=" + version + 
				"]";
	}
}

