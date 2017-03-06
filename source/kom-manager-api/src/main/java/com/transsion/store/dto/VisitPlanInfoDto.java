/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 10:24:48
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.dto;

import java.io.Serializable;
/**
 * @author guihua.zhang on 2017-03-01
 * 巡店计划详情
 * */
public class VisitPlanInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 店铺Id 编辑店铺详情时需要传入店铺Id
	 * */
	private Long shopId;

	/**
	  *	readonly 店铺名称
	  */
	private String shopName;
	
	
	/**
	  *	readonly 等级名称
	  */
	private String gradeName;
	
	/**
	 * 城市名称
	 * */
	private String cityName;

	/**
	 * 判断店铺当天是有巡店计划  1.店铺是当前人绑定 2.店铺未巡
	 *  默认是与queryPlanInfo接口兼容
	 */
	private boolean isTheDayPlanned = true;
	/**
	  *	readonly 周计划巡店数
	  */
	private int weekPlansQty;
	
	/**
	 * 店铺Id
	 * */
	public Long getShopId() {
		return shopId;
	}
	
	/**
	 * 店铺Id
	 * */
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	/**
	  *	readonly 店铺名称
	  */
	public String getShopName() {
		return shopName;
	}

	/**
	  *	readonly 店铺名称
	  */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	  *	readonly 等级名称
	  */
	public String getGradeName() {
		return gradeName;
	}

	/**
	  *	readonly 等级名称
	  */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
	/**
	 * 城市名称
	 * */
	public String getCityName() {
		return cityName;
	}

	/**
	 * 城市名称
	 * */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * 判断店铺当天是有巡店计划  1.店铺是当前人绑定 2.店铺未巡
	 *  默认是与queryPlanInfo接口兼容
	 */
	public boolean isTheDayPlanned() {
		return isTheDayPlanned;
	}

	/**
	 * 判断店铺当天是有巡店计划  1.店铺是当前人绑定 2.店铺未巡
	 *  默认是与queryPlanInfo接口兼容
	 */
	public void setTheDayPlanned(boolean isTheDayPlanned) {
		this.isTheDayPlanned = isTheDayPlanned;
	}

	/**
	  *	readonly 周计划巡店数
	  */
	public int getWeekPlansQty() {
		return weekPlansQty;
	}

	/**
	  *	readonly 周计划巡店数
	  */
	public void setWeekPlansQty(int weekPlansQty) {
		this.weekPlansQty = weekPlansQty;
	}

	@Override
	public String toString() {
		return "VisitPlanInfoDto [shopId=" + shopId + ", shopName=" + shopName + ", gradeName=" + gradeName
						+ ", cityName=" + cityName + ", isTheDayPlanned=" + isTheDayPlanned + ", weekPlansQty="
						+ weekPlansQty + "]";
	}

}
