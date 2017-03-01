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
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class VisitPlan extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	巡店计划ID
	  */
	private Long id;
	
	/**
	 * 巡店ID
	 * */
	private Long visitId;

	/**
	  *	巡店计划日期
	  */
	private String planDate;

	/**
	  *	实际巡店日期
	  */
	private String visitDate;
	
	/**
	 * 巡店者
	 * */
	private String planner;

	/**
	  *	事业部ID
	  */
	private Long companyId;
	

	/**
	  *	店铺ID
	  */
	private Long shopId;

	/**
	  *	1.未巡 2.已巡 3.过期未巡
	  */
	private Integer status;

	/**
	  *	备注
	  */
	private String remark;

	/**
	  *	创建人
	  */
	private String createBy;

	/**
	  *	创建时间
	  */
	private String createTime;

	/**
	  *	更新人
	  */
	private String updateBy;

	/**
	  *	更新时间
	  */
	private String updateTime;

	/**
	  *	版本
	  */
	private Integer version;

	/**
	  *	
	  */
	public Long getId() 
	{
		return id;
	}
	
	/**
	  *	
	  */
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	/**
	 * 巡店ID
	 * */
	public Long getVisitId() {
		return visitId;
	}

	/**
	 * 巡店ID
	 * */
	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	/**
	  *	
	  */
	public String getPlanDate() 
	{
		return planDate;
	}
	
	/**
	  *	
	  */
	public void setPlanDate(String planDate) 
	{
		this.planDate = planDate;
	}
	
	/**
	  *	
	  */
	public String getVisitDate() 
	{
		return visitDate;
	}
	
	/**
	  *	
	  */
	public void setVisitDate(String visitDate) 
	{
		this.visitDate = visitDate;
	}
	
	public String getPlanner() {
		return planner;
	}

	public void setPlanner(String planner) {
		this.planner = planner;
	}

	/**
	  *	
	  */
	public Long getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	
	  */
	public void setCompanyId(Long companyId) 
	{
		this.companyId = companyId;
	}
	
	/**
	  *	
	  */
	public Long getShopId() 
	{
		return shopId;
	}
	
	/**
	  *	
	  */
	public void setShopId(Long shopId) 
	{
		this.shopId = shopId;
	}
	
	/**
	  *	1,undo; 2,done
	  */
	public Integer getStatus() 
	{
		return status;
	}
	
	/**
	  *	1,undo; 2,done
	  */
	public void setStatus(Integer status) 
	{
		this.status = status;
	}
	
	/**
	  *	
	  */
	public String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	
	  */
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}
	
	/**
	  *	
	  */
	public String getCreateBy() 
	{
		return createBy;
	}
	
	/**
	  *	
	  */
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}
	
	/**
	  *	
	  */
	public String getCreateTime() 
	{
		return createTime;
	}
	
	/**
	  *	
	  */
	public void setCreateTime(String createTime) 
	{
		this.createTime = createTime;
	}
	
	/**
	  *	
	  */
	public String getUpdateBy() 
	{
		return updateBy;
	}
	
	/**
	  *	
	  */
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}
	
	/**
	  *	
	  */
	public String getUpdateTime() 
	{
		return updateTime;
	}
	
	/**
	  *	
	  */
	public void setUpdateTime(String updateTime) 
	{
		this.updateTime = updateTime;
	}
	
	/**
	  *	
	  */
	public Integer getVersion() 
	{
		return version;
	}
	
	/**
	  *	
	  */
	public void setVersion(Integer version) 
	{
		this.version = version;
	}

	@Override
	public String toString() {
		return "VisitPlan [id=" + id + ", visitId=" + visitId + ", planDate=" + planDate + ", visitDate=" + visitDate
						+ ", planner=" + planner + ", companyId=" + companyId + ", shopId=" + shopId + ", status="
						+ status + ", remark=" + remark + ", createBy=" + createBy + ", createTime=" + createTime
						+ ", updateBy=" + updateBy + ", updateTime=" + updateTime + ", version=" + version + "]";
	}

}

