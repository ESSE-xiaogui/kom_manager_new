package com.transsion.store.dto;

import java.io.Serializable;

public class BrandDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	  *	品牌名称
	  */
	private String brandName;
	
	/**
	 * 是否自有品牌  注：0是  1不是
	 * */
	private Integer isSelf;
	
	/**
	  *	0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中
	  */
	private Integer isInactive;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getIsSelf() {
		return isSelf;
	}

	public void setIsSelf(Integer isSelf) {
		this.isSelf = isSelf;
	}

	public Integer getIsInactive() {
		return isInactive;
	}

	public void setIsInactive(Integer isInactive) {
		this.isInactive = isInactive;
	}

	@Override
	public String toString() {
		return "BrandDto [brandName=" + brandName + ", isSelf=" + isSelf + ", isInactive=" + isInactive + "]";
	}
}
