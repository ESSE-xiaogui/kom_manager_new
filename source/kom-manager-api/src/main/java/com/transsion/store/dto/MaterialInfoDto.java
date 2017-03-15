package com.transsion.store.dto;

import java.io.Serializable;
/**
 * @author guihua.zhang on 2017-03-13
 * */
public class MaterialInfoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 物料Id
	 * */
	private Long materialId;
	
	/**
	 * 物料名称
	 * */
	private String materialName;
	
	/**
	 * true:选中 false:未选中
	 * */
	private boolean isSelected;

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((materialId == null) ? 0 : materialId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		
		if(getClass() != obj.getClass())
			return false;
		MaterialInfoDto other = (MaterialInfoDto)obj;
		if(materialId == null || materialId == 0){
			if(other.getMaterialId() != null){
				return false;
			}
		}else if(!materialId.equals(other.getMaterialId()))
				return false;
			
			return true;
	}

	@Override
	public String toString() {
		return "MaterialInfoDto [materialId=" + materialId + ", materialName=" + materialName + ", isSelected="
						+ isSelected + "]";
	}

}
