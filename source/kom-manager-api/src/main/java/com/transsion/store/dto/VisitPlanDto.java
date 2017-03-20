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
import java.util.List;

/**
 * @author guihua.zhang on 2017-02-28
 * */
public class VisitPlanDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/***
	 * 巡店计划ID
	 * 如果此巡店计划是需要删除的,必输
	 * */
	private Long id;

	/**
	  *	计划巡店日期
	  * 必输字段
	  */
	private String planDate;
	
	/**
	 * 计划巡店者
	 * 如果当前登录人需要将此巡店计划分给某人时输入某人登录用户名
	 * */
	private String planner;
	
	/**
	  *	要巡店的shopId列表
	  * 必输字段
	  */
	private List<Long> shopIds;

	/***
	 * 巡店计划ID
	 * 如果此巡店计划是需要删除的,必输
	 * */
	public Long getId() {
		return id;
	}

	/***
	 * 巡店计划ID
	 * 如果此巡店计划是需要删除的,必输
	 * */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	  *	计划巡店日期
	  * 必输字段
	  */
	public String getPlanDate() {
		return planDate;
	}

	/**
	  *	计划巡店日期
	  * 必输字段
	  */
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	/**
	 * 计划巡店者
	 * 如果当前登录人需要将此巡店计划分给某人时输入某人登录用户名
	 * */
	public String getPlanner() {
		return planner;
	}

	/**
	 * 计划巡店者
	 * 如果当前登录人需要将此巡店计划分给某人时输入某人登录用户名
	 * */
	public void setPlanner(String planner) {
		this.planner = planner;
	}

	public List<Long> getShopIds() {
		return shopIds;
	}

	public void setShopIds(List<Long> shopIds) {
		this.shopIds = shopIds;
	}

}
