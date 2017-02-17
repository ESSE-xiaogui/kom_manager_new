package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class Configuration extends Model {

	private static final long serialVersionUID = 1L;

	private java.lang.Long id;

	private java.lang.String name;

	private java.lang.String value;

	private java.lang.String remark;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getValue() {
		return value;
	}

	public void setValue(java.lang.String value) {
		this.value = value;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Configuration [id=" + id + ", name=" + name + ", value=" + value + ", remark=" + remark + "]";
	}

}
