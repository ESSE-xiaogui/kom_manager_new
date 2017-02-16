/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:39
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

/**
 * @author guihua.zhang
 * */
public class ShopBiz extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	门店类型编码
	  */
	private Long id;
	
	/**
	  *	事业部ID
	  */
	private Long companyId;
	
	/**
	 * 门店类型:专卖点 品牌店
	 * */
	private Integer shopType;
	
	/**
	 * 门店面积
	 * */
	private String shopArea;

	/**
	  *	业务类型
	  */
	private String bizName;

	/**
	 * 品牌
	 * */
	private String brandCode;
	
	/**
	 * 类型名称(CN)
	 * */
	private String chinaName;
	
	/**
	 * 类型名称(EN)
	 * */
	private String englishName;
	
	/**
	 * 是否启用 1启用 2停用
	 * */
	private Integer isInactive;

	/**
	  *	备注
	  */
	private String remark;

	/**
	  *	创建人
	  */
	private String createBy;

	/**
	  *	创建时间
	  */
	private String createDate;

	/**
	  *	更新人
	  */
	private String updateBy;

	/**
	  *	更新时间
	  */
	private String updateDate;

	/**
	  *	版本
	  */
	private Integer version;

	/**
	  *	门店类型编码
	  */
	public Long getId() {
		return id;
	}

	/**
	  *	门店类型编码
	  */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	  *	事业部ID
	  */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	  *	事业部ID
	  */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * 门店类型:专卖点 品牌店
	 * */
	public Integer getShopType() {
		return shopType;
	}

	/**
	 * 门店类型:专卖点 品牌店
	 * */
	public void setShopType(Integer shopType) {
		this.shopType = shopType;
	}

	/**
	 * 门店面积
	 * */
	public String getShopArea() {
		return shopArea;
	}

	/**
	 * 门店面积
	 * */
	public void setShopArea(String shopArea) {
		this.shopArea = shopArea;
	}

	/**
	  *	业务类型
	  */
	public String getBizName() {
		return bizName;
	}

	/**
	  *	业务类型
	  */
	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	/**
	 * 品牌
	 * */
	public String getBrandCode() {
		return brandCode;
	}

	/**
	 * 品牌
	 * */
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	/**
	 * 类型名称(CN)
	 * */
	public String getChinaName() {
		return chinaName;
	}

	/**
	 * 类型名称(CN)
	 * */
	public void setChinaName(String chinaName) {
		this.chinaName = chinaName;
	}

	/**
	 * 类型名称(EN)
	 * */
	public String getEnglishName() {
		return englishName;
	}

	/**
	 * 类型名称(EN)
	 * */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	/**
	 * 是否启用 1启用 2停用
	 * */
	public Integer getIsInactive() {
		return isInactive;
	}

	/**
	 * 是否启用 1启用 2停用
	 * */
	public void setIsInactive(Integer isInactive) {
		this.isInactive = isInactive;
	}

	/**
	  *	备注
	  */
	public String getRemark() {
		return remark;
	}

	/**
	  *	备注
	  */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	  *	创建人
	  */
	public String getCreateBy() {
		return createBy;
	}

	/**
	  *	创建人
	  */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	  *	创建时间
	  */
	public String getCreateDate() {
		return createDate;
	}

	/**
	  *	创建时间
	  */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	  *	更新人
	  */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	  *	更新人
	  */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	  *	更新时间
	  */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	  *	更新时间
	  */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	  *	版本
	  */
	public Integer getVersion() {
		return version;
	}

	/**
	  *	版本
	  */
	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ShopBiz [id=" + id + ", companyId=" + companyId + ", shopType=" + shopType + ", shopArea=" + shopArea
						+ ", bizName=" + bizName + ", brandCode=" + brandCode + ", chinaName=" + chinaName
						+ ", englishName=" + englishName + ", isInactive=" + isInactive + ", remark=" + remark
						+ ", createBy=" + createBy + ", createDate=" + createDate + ", updateBy=" + updateBy
						+ ", updateDate=" + updateDate + ", version=" + version + "]";
	}

}

