/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 10:24:47
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
import com.transsion.store.bo.Visit;
import com.transsion.store.dto.MaterialInfoDto;
import com.transsion.store.dto.ModelInfoDto;
import com.transsion.store.dto.VisitCompetitorInfoDto;
import com.transsion.store.dto.VisitDto;
import com.transsion.store.dto.VisitHistorySummaryDto;
import com.transsion.store.dto.VisitInfoDto;
import com.transsion.store.dto.VisitMaterielDetailDto;
import com.transsion.store.dto.VisitModelDetailDto;
import com.transsion.store.dto.VisitPlanParamDto;
import com.transsion.store.dto.VisitSaleDetailDto;
import com.transsion.store.dto.VisitScoreInfoDto;
import com.transsion.store.dto.VisitShopDetailDto;
import com.transsion.store.dto.VisitShopDto;
import com.transsion.store.dto.VisitShopInfoDto;

public interface VisitMapper extends GenericIBatisMapper<Visit, java.lang.Long> {

    public List<Visit> listPaginationByProperty(Pagination<Visit> pagination, @Param("visit")Visit visit, @Param("orderBy") Map<String, String> orderBy, @Param("companyId")Long companyId) throws DataAccessFailureException;
    
    public List<VisitInfoDto> queryUnplanedVisitList(VisitInfoDto visitInfoDto) throws DataAccessFailureException;
    
    public void saveVisitDto(VisitDto visitDto) throws DataAccessFailureException;
    
    public VisitShopInfoDto queryVisitShopInfo(VisitShopInfoDto visitShopInfoDto) throws DataAccessFailureException;
    
    //查询前八周的巡店历史记录
    public List<VisitHistorySummaryDto> queryVisitSummaryHistory(VisitPlanParamDto visitPlanParamDto)throws DataAccessFailureException;
    
    public VisitShopDto queryVisitByVisitId(Long id) throws DataAccessFailureException;
    
    public VisitShopDetailDto queryVisitScoreInfoByVisitId(Long visitId) throws DataAccessFailureException;
    
    public List<VisitScoreInfoDto> queryVisitScoreItemInfoByVisitId(Long visitId) throws DataAccessFailureException;
    
    public String queryIssueByVisitId(Long visitId) throws DataAccessFailureException;
    public List<VisitModelDetailDto> queryVisitHistoryModelListByVisitId(Long visitId) throws DataAccessFailureException;
    public List<VisitSaleDetailDto> queryVisitHistorySaleListByVisitId(Long visitId) throws DataAccessFailureException;
    public List<VisitCompetitorInfoDto> queryVisitHistoryCompetitorListByVisitId(Long visitId) throws DataAccessFailureException;
    public List<VisitMaterielDetailDto> queryVisitHistoryMaterielListByVisitId(Long visitId) throws DataAccessFailureException;

	public List<Visit> listVisitShopSaleByProperty(@Param("visit")Visit visit)throws DataAccessFailureException;

	public List<Visit> listShopHistoryByProperty(@Param("visit")Visit visit)throws DataAccessFailureException;
	
	public Integer querySalePbQtyByVisitId(Long visitId);
	
	//查询当前登录人巡店下最新一次的上柜机型
	public List<ModelInfoDto> findLastDateModel(@Param("visitor")String visitor,@Param("companyId")Long companyId) throws DataAccessFailureException;

	//查询当前登录人巡店下最新一次的物料
	public List<MaterialInfoDto> findLastDateMaterial(@Param("visitor")String visitor,@Param("companyId")Long companyId) throws DataAccessFailureException;

}
