/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-1 16:31:41
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class PrototypeCounting extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.Long companyId;

	/**
	  *	
	  */
	private java.lang.Long shopId;

	/**
	  *	
	  */
	private java.lang.Long prototypeId;

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
	  *	1,undo; 2,done; 3,expired
	  */
	private java.lang.Integer status;

	/**
	  *	
	  */
	private java.lang.String countingBy;

	/**
	  *	
	  */
	private java.lang.String countingTime;

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
	  *	
	  */
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
	public java.lang.Long getPrototypeId() 
	{
		return prototypeId;
	}
	
	/**
	  *	
	  */
	public void setPrototypeId(java.lang.Long prototypeId) 
	{
		this.prototypeId = prototypeId;
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
	  *	1,undo; 2,done; 3,expired
	  */
	public java.lang.Integer getStatus() 
	{
		return status;
	}
	
	/**
	  *	1,undo; 2,done; 3,expired
	  */
	public void setStatus(java.lang.Integer status) 
	{
		this.status = status;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCountingBy() 
	{
		return countingBy;
	}
	
	/**
	  *	
	  */
	public void setCountingBy(java.lang.String countingBy) 
	{
		this.countingBy = countingBy;
	}
	
	/**
	  *	
	  */
	public java.lang.String getCountingTime() 
	{
		return countingTime;
	}
	
	/**
	  *	
	  */
	public void setCountingTime(java.lang.String countingTime) 
	{
		this.countingTime = countingTime;
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
		return "PrototypeCounting [" + 
					"id=" + id + 
					", companyId=" + companyId + 
					", shopId=" + shopId + 
					", prototypeId=" + prototypeId + 
					", imgPrototypeUrl=" + imgPrototypeUrl + 
					", imgShopUrl=" + imgShopUrl + 
					", imgImeiUrl=" + imgImeiUrl + 
					", status=" + status + 
					", countingBy=" + countingBy + 
					", countingTime=" + countingTime + 
					", remark=" + remark + 
					", createBy=" + createBy + 
					", createTime=" + createTime + 
					", updateBy=" + updateBy + 
					", updateTime=" + updateTime + 
					", version=" + version + 
				"]";
	}
}

