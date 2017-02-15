package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class Attribute extends Model {

	private static final long serialVersionUID = 1L;
	
	public enum Type{SHOP_RELATIONSHIP,SHOP_CATEGORY,SHOP_PCS};

	private java.lang.Long id;

	private java.lang.Long companyId;

	private java.lang.Integer type;

	private java.lang.Integer sqe;

	private java.lang.String engName;

	private java.lang.String cnName;

	private java.lang.String remark;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Long companyId) {
		this.companyId = companyId;
	}

	public java.lang.Integer getType() {
		return type;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getSqe() {
		return sqe;
	}

	public void setSqe(java.lang.Integer sqe) {
		this.sqe = sqe;
	}

	public java.lang.String getEngName() {
		return engName;
	}

	public void setEngName(java.lang.String engName) {
		this.engName = engName;
	}

	public java.lang.String getCnName() {
		return cnName;
	}

	public void setCnName(java.lang.String cnName) {
		this.cnName = cnName;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Attribute [id=" + id + ", companyId=" + companyId + ", type=" + type + ", sqe=" + sqe + ", engName="
				+ engName + ", cnName=" + cnName + ", remark=" + remark + "]";
	}

}
