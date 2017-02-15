package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class ShopMateriel extends Model{
	
	private static final long serialVersionUID = 1L;

	private java.lang.Long id;

	private java.lang.Long shopId;

	private Long materielId;
	
	private int qty;
	
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getShopId() {
		return shopId;
	}

	public void setShopId(java.lang.Long shopId) {
		this.shopId = shopId;
	}

	public Long getMaterielId() {
		return materielId;
	}

	public void setMaterielId(Long materielId) {
		this.materielId = materielId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}


}
