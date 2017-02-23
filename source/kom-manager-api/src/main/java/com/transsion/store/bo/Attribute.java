package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class Attribute extends Model {

	private static final long serialVersionUID = 1L;

	public enum Type {
		
		SHOP_RELATIONSHIP(1), 
		SHOP_CATEGORY(2),
		MODEL_PRICE(3), 
		SHOP_BIZ(4),
		SHOP_PCS(5);
		
		private final int value;

		private Type(int value) {
			this.value = value;
		}

		public int getVal() {
			return value;
		}
	};
	
	

	private java.lang.Long id;

	private java.lang.Long companyId;

	private java.lang.Integer type;

	private java.lang.Integer sqe;

	private java.lang.String nameEN;

	private java.lang.String nameCN;

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

	public java.lang.String getNameEN() {
		return nameEN;
	}

	public void setNameEN(java.lang.String nameEN) {
		this.nameEN = nameEN;
	}

	public java.lang.String getNameCN() {
		return nameCN;
	}

	public void setNameCN(java.lang.String nameCN) {
		this.nameCN = nameCN;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Attribute [id=" + id + ", companyId=" + companyId + ", type=" + type + ", sqe=" + sqe + ", nameEN="
				+ nameEN + ", nameCN=" + nameCN + ", remark=" + remark + "]";
	}

}
