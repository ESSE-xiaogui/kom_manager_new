/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-16 11:36:58
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

import java.util.EnumMap;

public class FileTemplate extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public enum BizType {
		//Sale
		S("S", "销量模板"),

		//汇率
		C("C", "汇率模板"),

		//帐号
		A("A", "帐号模板"),

		//门店目标销量
		G("G", "门店销量目标"),

		//促销员销量目标
		P("P", "促销员销量目标"),

		//门店
		T("T", "门店模板"),
		
		//巡店员销量目标
		X("X","巡店员销量目标"),
		
		//重点机型销量目标
		M("M","重点机型销量目标");

		private String key;
		private String value;

		private BizType(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	/**
	  *	主键
	  */
	private Integer id;

	/**
	  *	业务类型
	  */
	private String bizType;

	/**
	  *	模板名称
	  */
	private String templateName;

	/**
	  *	文件名称（ID)
	  */
	private String fileId;

	/**
	  *	文件后缀
	  */
	private String fileSuffix;

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
	private String updatedBy;

	/**
	  *	修改时间
	  */
	private String updatedTime;

	/**
	  *	主键
	  */
	public Integer getId()
	{
		return id;
	}
	
	/**
	  *	主键
	  */
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	/**
	  *	业务类型
	  */
	public String getBizType()
	{
		return bizType;
	}
	
	/**
	  *	业务类型
	  */
	public void setBizType(String bizType)
	{
		this.bizType = bizType;
	}
	
	/**
	  *	模板名称
	  */
	public String getTemplateName()
	{
		return templateName;
	}
	
	/**
	  *	模板名称
	  */
	public void setTemplateName(String templateName)
	{
		this.templateName = templateName;
	}
	
	/**
	  *	文件名称（ID)
	  */
	public String getFileId()
	{
		return fileId;
	}
	
	/**
	  *	文件名称（ID)
	  */
	public void setFileId(String fileId)
	{
		this.fileId = fileId;
	}
	
	/**
	  *	文件后缀
	  */
	public String getFileSuffix()
	{
		return fileSuffix;
	}
	
	/**
	  *	文件后缀
	  */
	public void setFileSuffix(String fileSuffix)
	{
		this.fileSuffix = fileSuffix;
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
	public String getUpdatedBy()
	{
		return updatedBy;
	}
	
	/**
	  *	修改人
	  */
	public void setUpdatedBy(String updatedBy)
	{
		this.updatedBy = updatedBy;
	}
	
	/**
	  *	修改时间
	  */
	public String getUpdatedTime()
	{
		return updatedTime;
	}
	
	/**
	  *	修改时间
	  */
	public void setUpdatedTime(String updatedTime)
	{
		this.updatedTime = updatedTime;
	}
	
	public String toString()
	{
		return "FileTemplate [" + 
					"id=" + id + 
					", bizType=" + bizType + 
					", templateName=" + templateName + 
					", fileId=" + fileId + 
					", fileSuffix=" + fileSuffix + 
					", remark=" + remark + 
					", createBy=" + createBy + 
					", createTime=" + createTime + 
					", updatedBy=" + updatedBy + 
					", updatedTime=" + updatedTime + 
				"]";
	}
}

