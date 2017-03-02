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

import javax.ws.rs.Path;

import com.transsion.store.bo.VisitScore;
import com.transsion.store.dto.VisitPlanDetailInfoDto;
import com.transsion.store.dto.VisitScoreDetailInfoDto;
import com.transsion.store.dto.VisitScoreDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface VisitScoreMapper extends GenericIBatisMapper<VisitScore, java.lang.Long> {

    public List<VisitPlanDetailInfoDto> listPaginationByProperty(Pagination<VisitPlanDetailInfoDto> pagination, @Param("visitPlanDetailInfoDto")VisitPlanDetailInfoDto visitPlanDetailInfoDto, @Param("orderBy") Map<String, String> orderBy,@Param("companyId")Long companyId) throws DataAccessFailureException;
    
    public VisitScoreDto queryVisitScoreByVisitId(Long visitId) throws DataAccessFailureException;

	public List<VisitScoreDetailInfoDto> listVisitScoreByProperty(@Param("visitScoreDetailInfoDto")VisitScoreDetailInfoDto visitScoreDetailInfoDto)throws DataAccessFailureException;
}
