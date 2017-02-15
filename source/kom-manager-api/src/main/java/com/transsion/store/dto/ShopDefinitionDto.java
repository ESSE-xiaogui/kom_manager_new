package com.transsion.store.dto;

import java.util.List;

import com.transsion.store.bo.Attribute;
import com.transsion.store.bo.Materiel;
import com.transsion.store.bo.Region;

/*
 * ShopDefinitionDto ShopDefinition info
 */
public class ShopDefinitionDto {
	
	private List<Region> countryList;
	
	private List<Region> cityList;
	
	private List<Materiel> materielList;
	
	private List<Attribute> relationshipList;
	
	private List<Attribute> bizCategoryList;

	public List<Region> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Region> countryList) {
		this.countryList = countryList;
	}

	public List<Region> getCityList() {
		return cityList;
	}

	public void setCityList(List<Region> cityList) {
		this.cityList = cityList;
	}

	public List<Materiel> getMaterielList() {
		return materielList;
	}

	public void setMaterielList(List<Materiel> materielList) {
		this.materielList = materielList;
	}

	public List<Attribute> getRelationshipList() {
		return relationshipList;
	}

	public void setRelationshipList(List<Attribute> relationshipList) {
		this.relationshipList = relationshipList;
	}

	public List<Attribute> getBizCategoryList() {
		return bizCategoryList;
	}

	public void setBizCategoryList(List<Attribute> bizCategoryList) {
		this.bizCategoryList = bizCategoryList;
	}
	
	
	
}