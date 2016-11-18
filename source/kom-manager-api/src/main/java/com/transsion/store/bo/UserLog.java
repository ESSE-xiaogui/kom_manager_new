/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:41
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class UserLog extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	日志ID
	  */
	private java.lang.Long logId;

	/**
	  *	客户ID
	  */
	private java.lang.Long userId;

	/**
	  *	处理人
	  */
	private java.lang.String userName;

	/**
	  *	操作环节
	  */
	private java.lang.String logNode;

	/**
	  *	登录时间
	  */
	private java.lang.String logDate;

	/**
	  *	备注
	  */
	private java.lang.String remark;

	/**
	  *	日志ID
	  */
	public java.lang.Long getLogId() 
	{
		return logId;
	}
	
	/**
	  *	日志ID
	  */
	public void setLogId(java.lang.Long logId) 
	{
		this.logId = logId;
	}
	
	/**
	  *	客户ID
	  */
	public java.lang.Long getUserId() 
	{
		return userId;
	}
	
	/**
	  *	客户ID
	  */
	public void setUserId(java.lang.Long userId) 
	{
		this.userId = userId;
	}
	
	/**
	  *	处理人
	  */
	public java.lang.String getUserName() 
	{
		return userName;
	}
	
	/**
	  *	处理人
	  */
	public void setUserName(java.lang.String userName) 
	{
		this.userName = userName;
	}
	
	/**
	  *	操作环节
	  */
	public java.lang.String getLogNode() 
	{
		return logNode;
	}
	
	/**
	  *	操作环节
	  */
	public void setLogNode(java.lang.String logNode) 
	{
		this.logNode = logNode;
	}
	
	/**
	  *	登录时间
	  */
	public java.lang.String getLogDate() 
	{
		return logDate;
	}
	
	/**
	  *	登录时间
	  */
	public void setLogDate(java.lang.String logDate) 
	{
		this.logDate = logDate;
	}
	
	/**
	  *	备注
	  */
	public java.lang.String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	备注
	  */
	public void setRemark(java.lang.String remark) 
	{
		this.remark = remark;
	}
	
	public String toString()
	{
		return "UserLog [" + 
					"logId=" + logId + 
					", userId=" + userId + 
					", userName=" + userName + 
					", logNode=" + logNode + 
					", logDate=" + logDate + 
					", remark=" + remark + 
				"]";
	}
}

