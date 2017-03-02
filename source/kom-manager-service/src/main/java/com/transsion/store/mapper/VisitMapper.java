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

import com.transsion.store.bo.Visit;
import com.transsion.store.dto.VisitDto;
import com.transsion.store.dto.VisitHistorySummaryDto;
import com.transsion.store.dto.VisitInfoDto;
import com.transsion.store.dto.VisitPlanParamDto;
import com.transsion.store.dto.VisitShopInfoDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface VisitMapper extends GenericIBatisMapper<Visit, java.lang.Long> {

    public List<Visit> listPaginationByProperty(Pagination<Visit> pagination, @Param("visit")Visit visit, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    
    public List<VisitInfoDto> queryUnplanedVisitList(VisitInfoDto visitInfoDto) throws DataAccessFailureException;
    
    public void saveVisitDto(VisitDto visitDto) throws DataAccessFailureException;
    
    public VisitShopInfoDto queryVisitShopInfo(VisitShopInfoDto visitShopInfoDto) throws DataAccessFailureException;
    
    //查询前八周的巡店历史记录
    public List<VisitHistorySummaryDto> queryVisitSummaryHistory(VisitPlanParamDto visitPlanParamDto)throws DataAccessFailureException;
}
