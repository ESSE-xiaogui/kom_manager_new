package com.transsion.store.bo;

public class ModelPrice extends com.shangkang.core.bo.Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;
	
	private String tableType;
	
	private String priceScale;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	public String getPriceScale() {
		return priceScale;
	}

	public void setPriceScale(String priceScale) {
		this.priceScale = priceScale;
	}

	@Override
	public String toString() {
		return "ModelPrice [id=" + id + ", tableType=" + tableType + ", priceScale=" + priceScale + "]";
	}

}
