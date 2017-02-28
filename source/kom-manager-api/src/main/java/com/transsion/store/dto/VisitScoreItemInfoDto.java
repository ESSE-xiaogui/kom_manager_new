/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 14:48:56
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.dto;

import java.io.Serializable;


public class VisitScoreItemInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private java.lang.Long id;

	/**
	  *	
	  */
	private java.lang.Long visitId;

	/**
	  *	
	  */
	private java.lang.Long scoreSettingId;
	
	
	private java.lang.String descEn;
	/**
	  *	
	  */
	private java.math.BigDecimal score;

	/**
	  *	
	  */
	private java.lang.String remark;


	/**
	  *	
	  */
	public java.lang.Long getId() 
	{
		return id;
	}
	
	/**
	  *	
	  */
	public void setId(java.lang.Long id) 
	{
		this.id = id;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getVisitId() 
	{
		return visitId;
	}
	
	/**
	  *	
	  */
	public void setVisitId(java.lang.Long visitId) 
	{
		this.visitId = visitId;
	}
	
	/**
	  *	
	  */
	public java.lang.Long getScoreSettingId() 
	{
		return scoreSettingId;
	}
	
	/**
	  *	
	  */
	public void setScoreSettingId(java.lang.Long scoreSettingId) 
	{
		this.scoreSettingId = scoreSettingId;
	}
	
	/**
	  *	
	  */
	public java.math.BigDecimal getScore() 
	{
		return score;
	}
	
	/**
	  *	
	  */
	public void setScore(java.math.BigDecimal score) 
	{
		this.score = score;
	}
	
	/**
	  *	
	  */
	public java.lang.String getRemark() 
	{
		return remark;
	}
	
	/**
	  *	
	  */
	public void setRemark(java.lang.String remark) 
	{
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "VisitScoreItem [id=" + id + ", visitId=" + visitId + ", scoreSettingId=" + scoreSettingId + ", score="
				+ score + ", remark=" + remark + "]";
	}
	
}

