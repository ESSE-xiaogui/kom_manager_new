package com.transsion.store.dto;

import java.io.Serializable;

public class VisitMaterielDetailDto implements Serializable {
	private static final long serialVersionUID = -7947771634101512619L;
	
	private String nameEn;
	private String type;
	
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "VisitMaterielDetailDto [nameEn=" + nameEn + ", type=" + type + "]";
	}
	
}
