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
 * @author guihua.zhang 
 * update time on 2017-2-23
 * */
public class VisitScoreSettingDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	打分项设置ID
	  */
	private Long id;

	/**
	  *	事业部ID
	  */
	private Long companyId;
	
	/**
	 * 事业部品牌
	 * */
	private String companyName;

	/**
	  *	类型ID
	  */
	private Long type;
	
	/**
	 * 类型名称
	 * */
	private String typeName;

	/**
	  *	英文描述
	  */
	private String descEn;

	/**
	  *	中文描述
	  */
	private String descCn;

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
	  *	修改人
	  */
	private String updateBy;

	/**
	  *	修改时间
	  */
	private String updateTime;

	/**
	  *	版本
	  */
	private Integer version;

	/**
	  *	打分项设置ID
	  */
	public Long getId() 
	{
		return id;
	}
	
	/**
	  *	打分项设置ID
	  */
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	/**
	  *	事业部ID
	  */
	public Long getCompanyId() 
	{
		return companyId;
	}
	
	/**
	  *	事业部ID
	  */
	public void setCompanyId(Long companyId) 
	{
		this.companyId = companyId;
	}
		
	/**
	 * 事业部品牌名称
	 * */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 事业部品牌名称
	 * */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 业务类型名称
	 * */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * 业务类型名称
	 * */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	  *	类型ID
	  */
	public Long getType() 
	{
		return type;
	}
	
	/**
	  *	类型ID
	  */
	public void setType(Long type) 
	{
		this.type = type;
	}
	
	/**
	  *	英文描述
	  */
	public String getDescEn() 
	{
		return descEn;
	}
	
	/**
	  *	英文描述
	  */
	public void setDescEn(String descEn) 
	{
		this.descEn = descEn;
	}
	
	/**
	  *	中文描述
	  */
	public String getDescCn() 
	{
		return descCn;
	}
	
	/**
	  *	中文描述
	  */
	public void setDescCn(String descCn) 
	{
		this.descCn = descCn;
	}
	
	/**
	  *	备注
	  */
	public String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	备注
	  */
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}
	
	/**
	  *	创建人
	  */
	public String getCreateBy() 
	{
		return createBy;
	}
	
	/**
	  *	创建人
	  */
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}
	
	/**
	  *	创建时间
	  */
	public String getCreateTime() 
	{
		return createTime;
	}
	
	/**
	  *	创建时间
	  */
	public void setCreateTime(String createTime) 
	{
		this.createTime = createTime;
	}
	
	/**
	  *	修改人
	  */
	public String getUpdateBy() 
	{
		return updateBy;
	}
	
	/**
	  *	修改人
	  */
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}
	
	/**
	  *	修改时间
	  */
	public String getUpdateTime() 
	{
		return updateTime;
	}
	
	/**
	  *	修改时间
	  */
	public void setUpdateTime(String updateTime) 
	{
		this.updateTime = updateTime;
	}
	
	/**
	  *	版本
	  */
	public Integer getVersion() 
	{
		return version;
	}
	
	/**
	  *	版本
	  */
	public void setVersion(Integer version) 
	{
		this.version = version;
	}
	
	public String toString()
	{
		return "VisitScoreSetting [" + 
					"id=" + id + 
					", companyId=" + companyId + 
					", type=" + type + 
					", descEn=" + descEn + 
					", descCn=" + descCn + 
					", remark=" + remark + 
					", createBy=" + createBy + 
					", createTime=" + createTime + 
					", updateBy=" + updateBy + 
					", updateTime=" + updateTime + 
					", version=" + version + 
				"]";
	}
}

