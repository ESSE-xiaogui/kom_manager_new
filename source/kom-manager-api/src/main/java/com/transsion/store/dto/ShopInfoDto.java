package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

import com.transsion.store.bo.Shop;
import com.transsion.store.bo.ShopExtension;
import com.transsion.store.bo.ShopMateriel;

/*
	  *	dto use for creating shop by app 
 */
public class ShopInfoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Shop shop;
	
	private ShopExtension shopExtension;
	
	private List<ShopMateriel> shopMaterielDtoList;

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

	public List<ShopMateriel> getShopMaterielDtoList() {
		return shopMaterielDtoList;
	}

	public void setShopMaterielDtoList(List<ShopMateriel> shopMaterielDtoList) {
		this.shopMaterielDtoList = shopMaterielDtoList;
	}
	
	
}
