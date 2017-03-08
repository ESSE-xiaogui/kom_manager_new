/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-7 11:42:41
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
import com.transsion.store.bo.ReportSaleDaily;
import com.transsion.store.dto.ReportSaleDailyDto;

public interface ReportSaleDailyMapper extends GenericIBatisMapper<ReportSaleDaily, java.lang.Long> {

    public List<ReportSaleDailyDto> listPaginationByProperty(Pagination<ReportSaleDailyDto> pagination, @Param("reportSaleDailyDto")ReportSaleDailyDto reportSaleDailyDto, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;

    public List<ReportSaleDaily> findUnStatisticsDataByDate(String date) throws DataAccessFailureException;
}
