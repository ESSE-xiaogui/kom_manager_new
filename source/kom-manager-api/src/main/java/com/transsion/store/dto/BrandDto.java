package com.transsion.store.dto;

import java.io.Serializable;

/**
 * @author guihua.zhang
 * */
public class BrandDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long brandId;
	
	/**
	  *	品牌名称
	  */
	private String brandName;
	
	/**
	 * 是否自有品牌  注：1不是 2是
	 * */
	private Integer isSelf;
	
	/**
	  *	1启用 2禁用
	  */
	private Integer isInactive;

	/**
	  *	品牌名称
	  */
	public String getBrandName() {
		return brandName;
	}

	/**
	  *	品牌名称
	  */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * 是否自有品牌  注：1不是 2是
	 * */
	public Integer getIsSelf() {
		return isSelf;
	}

	/**
	 * 是否自有品牌  注：1不是 2是
	 * */
	public void setIsSelf(Integer isSelf) {
		this.isSelf = isSelf;
	}

	/**
	  *	1启用 2禁用
	  */
	public Integer getIsInactive() {
		return isInactive;
	}

	/**
	  *	1启用 2禁用
	  */
	public void setIsInactive(Integer isInactive) {
		this.isInactive = isInactive;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	@Override
	public String toString() {
		return "BrandDto [brandId=" + brandId + ", brandName=" + brandName + ", isSelf=" + isSelf + ", isInactive="
						+ isInactive + "]";
	}


}
