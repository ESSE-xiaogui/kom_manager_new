package com.transsion.store.dto;

import java.util.List;

import com.transsion.store.bo.Attribute;
import com.transsion.store.bo.Materiel;
import com.transsion.store.bo.Region;
import com.transsion.store.bo.ShopBiz;
import com.transsion.store.bo.ShopGrade;

/*
 * ShopDefinitionDto ShopDefinition info
 */
public class ShopDefinitionDto {
	
	private List<Region> countryList;
	
	private List<Region> cityList;
	
	private List<Materiel> materielList;
	
	private List<ShopBiz> shopBizList;
	
	private List<ShopGrade> shopGradeList;
	
	private List<Attribute> relationshipList;
	
	private List<Attribute> bizCategoryList;
	
	private List<Attribute> bizTypeList;

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

	public List<ShopBiz> getShopBizList() {
		return shopBizList;
	}

	public void setShopBizList(List<ShopBiz> shopBizList) {
		this.shopBizList = shopBizList;
	}

	public List<ShopGrade> getShopGradeList() {
		return shopGradeList;
	}

	public void setShopGradeList(List<ShopGrade> shopGradeList) {
		this.shopGradeList = shopGradeList;
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

	public List<Attribute> getBizTypeList() {
		return bizTypeList;
	}

	public void setBizTypeList(List<Attribute> bizTypeList) {
		this.bizTypeList = bizTypeList;
	}

	@Override
	public String toString() {
		return "ShopDefinitionDto [countryList=" + countryList + ", cityList=" + cityList + ", materielList="
						+ materielList + ", shopBizList=" + shopBizList + ", shopGradeList=" + shopGradeList
						+ ", relationshipList=" + relationshipList + ", bizCategoryList=" + bizCategoryList
						+ ", bizTypeList=" + bizTypeList + "]";
	}



}