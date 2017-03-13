package com.transsion.store.dto;

import java.io.Serializable;

import com.transsion.store.bo.ShopDamage;

public class ShopDamageInfoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long damageId;
	private Long shopId;
	private Long materielId;
	private String damageTime;
	private String description;
	private String imgFirstUrl;
	private String imgSecondUrl;
	private String imgThirdUrl;
	private String remark;
	private String createBy;
	private String createTime;
	private String updateBy;
	private String updateTime;
	private Integer version;
	
	private String shopName;
	private String nameEn;
	
	public Long getDamageId() {
		return damageId;
	}
	public void setDamageId(Long damageId) {
		this.damageId = damageId;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Long getMaterielId() {
		return materielId;
	}
	public void setMaterielId(Long materielId) {
		this.materielId = materielId;
	}
	public String getDamageTime() {
		return damageTime;
	}
	public void setDamageTime(String damageTime) {
		this.damageTime = damageTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgFirstUrl() {
		return imgFirstUrl;
	}
	public void setImgFirstUrl(String imgFirstUrl) {
		this.imgFirstUrl = imgFirstUrl;
	}
	public String getImgSecondUrl() {
		return imgSecondUrl;
	}
	public void setImgSecondUrl(String imgSecondUrl) {
		this.imgSecondUrl = imgSecondUrl;
	}
	public String getImgThirdUrl() {
		return imgThirdUrl;
	}
	public void setImgThirdUrl(String imgThirdUrl) {
		this.imgThirdUrl = imgThirdUrl;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	
	public ShopDamage toModel() {
		ShopDamage shopDamage = new ShopDamage();
		shopDamage.setDamageId(this.getDamageId());
		shopDamage.setShopId(this.getShopId());
		shopDamage.setMaterielId(this.getMaterielId());
		shopDamage.setDamageTime(this.getDamageTime());
		shopDamage.setDescription(this.getDescription());
		shopDamage.setImgFirstUrl(this.getImgFirstUrl());
		shopDamage.setImgSecondUrl(this.getImgSecondUrl());
		shopDamage.setImgThirdUrl(this.getImgThirdUrl());
		shopDamage.setRemark(this.getRemark());
		shopDamage.setCreateBy(this.getCreateBy());
		shopDamage.setCreateTime(this.getCreateTime());
		shopDamage.setUpdateBy(this.getUpdateBy());
		shopDamage.setUpdateTime(this.getUpdateTime());
		shopDamage.setVersion(this.getVersion());
		return shopDamage;
	}
	
	@Override
	public String toString() {
		return "ShopDamageInfoDto [damageId=" + damageId + ", shopId=" + shopId + ", materielId=" + materielId
				+ ", damageTime=" + damageTime + ", description=" + description + ", imgFirstUrl=" + imgFirstUrl
				+ ", imgSecondUrl=" + imgSecondUrl + ", imgThirdUrl=" + imgThirdUrl + ", remark=" + remark
				+ ", createBy=" + createBy + ", createTime=" + createTime + ", updateBy=" + updateBy + ", updateTime="
				+ updateTime + ", version=" + version + ", shopName=" + shopName + ", nameEn=" + nameEn
				+ "]";
	}
}
