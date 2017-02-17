package com.transsion.store.dto;

import java.io.Serializable;

import com.transsion.store.bo.Shop;
import com.transsion.store.bo.ShopExtension;

/*
	  *	dto use for creating shop by web 
 */
public class ShopInfoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Shop shop;
	
	private ShopExtension shopExtension;
	
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public ShopExtension getShopExtension() {
		return shopExtension;
	}

	public void setShopExtension(ShopExtension shopExtension) {
		this.shopExtension = shopExtension;
	}
	
	
}
