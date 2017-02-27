package com.transsion.store.dto;

import java.io.Serializable;
import java.util.List;

import com.transsion.store.bo.Shop;
import com.transsion.store.bo.ShopMateriel;

/*
	  *	dto use for creating shop by app 
 */
public class ShopDetailDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Shop shop;
	
	private ShopExtensionDto shopExtensionDto;
	
	public ShopExtensionDto getShopExtensionDto() {
		return shopExtensionDto;
	}

	public void setShopExtensionDto(ShopExtensionDto shopExtensionDto) {
		this.shopExtensionDto = shopExtensionDto;
	}

	private List<ShopMateriel> shopMaterielDtoList;

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}


	public List<ShopMateriel> getShopMaterielDtoList() {
		return shopMaterielDtoList;
	}

	public void setShopMaterielDtoList(List<ShopMateriel> shopMaterielDtoList) {
		this.shopMaterielDtoList = shopMaterielDtoList;
	}
}
