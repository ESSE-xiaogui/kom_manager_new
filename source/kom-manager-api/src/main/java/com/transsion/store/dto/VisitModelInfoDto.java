package com.transsion.store.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author guihua.zhang on 2017-03-01
 * 重点机型详情
 * */
public class VisitModelInfoDto  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	  *	重点机型Id
	  */
	private Long modelId;

	/**
	 * 重点机型编码
	 * */
	private String modelCode;
	
	/**
	 * 重点机型名称
	 * */
	private String modelName;

	/**
	  *	当前销量数量
	  */
	private int currentSaleQty;
	
	/**
	  *	目标销售数量
	  */
	private int targetSaleQty;
	
	
	/**
	 * avg sale per four weeks/平均每四周销售
	 */
	private BigDecimal saleAvg;

	/**
	  *	重点机型Id
	  */
	public Long getModelId() {
		return modelId;
	}

	/**
	  *	重点机型Id
	  */
	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	/**
	 * 重点机型编码
	 * */
	public String getModelCode() {
		return modelCode;
	}

	/**
	 * 重点机型编码
	 * */
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	/**
	 * 重点机型名称
	 * */
	public String getModelName() {
		return modelName;
	}

	/**
	 * 重点机型名称
	 * */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	  *	当前销量数量
	  */
	public int getCurrentSaleQty() {
		return currentSaleQty;
	}

	/**
	  *	当前销量数量
	  */
	public void setCurrentSaleQty(int currentSaleQty) {
		this.currentSaleQty = currentSaleQty;
	}

	/**
	  *	目标销售数量
	  */
	public int getTargetSaleQty() {
		return targetSaleQty;
	}

	/**
	  *	目标销售数量
	  */
	public void setTargetSaleQty(int targetSaleQty) {
		this.targetSaleQty = targetSaleQty;
	}

	/**
	 * avg sale per four weeks/平均每四周销售
	 */
	public BigDecimal getSaleAvg() {
		return saleAvg;
	}

	/**
	 * avg sale per four weeks/平均每四周销售
	 */
	public void setSaleAvg(BigDecimal saleAvg) {
		this.saleAvg = saleAvg;
	}

	@Override
	public String toString() {
		return "VisitModelInfoDto [modelId=" + modelId + ", modelCode=" + modelCode + ", modelName=" + modelName
						+ ", currentSaleQty=" + currentSaleQty + ", targetSaleQty=" + targetSaleQty + ", saleAvg="
						+ saleAvg + "]";
	}
	
}
