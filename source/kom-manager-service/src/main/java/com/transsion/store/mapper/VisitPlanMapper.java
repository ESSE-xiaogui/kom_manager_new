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
package com.transsion.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.VisitPlan;
import com.transsion.store.dto.VisitInfoDto;
import com.transsion.store.dto.VisitPlanParamDto;

public interface VisitPlanMapper extends GenericIBatisMapper<VisitPlan, java.lang.Long> {

    public List<VisitPlan> listPaginationByProperty(Pagination<VisitPlan> pagination, @Param("visitPlan")VisitPlan visitPlan, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    
	public List<VisitInfoDto> queryPlanedVisitList(VisitInfoDto visitInfoDto) throws DataAccessFailureException;
	
	public List<VisitInfoDto> queryWeekPlanCount(VisitInfoDto visitInfoDto) throws DataAccessFailureException;
	
	//查询一周巡店计划数
	public int findWeekQtry(VisitPlanParamDto visitPlanParamDto);
}
