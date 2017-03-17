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
    
    // TOP 门店查询(分页)
    public List<ReportSaleDaily> listPaginationByShop(Pagination<ReportSaleDaily> pagination, @Param("reportSaleDaily")ReportSaleDaily reportSaleDaily, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    // TOP 门店查询(导出)
    public List<ReportSaleDaily> queryReportSaleDailyListByShop(ReportSaleDaily reportSaleDaily) throws DataAccessFailureException;
    
    // TOP 促销员查询(分页)
    public List<ReportSaleDaily> listPaginationBySale(Pagination<ReportSaleDaily> pagination, @Param("reportSaleDaily")ReportSaleDaily reportSaleDaily, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    // TOP 促销员查询(导出)
    public List<ReportSaleDaily> queryReportSaleDailyListBySale(ReportSaleDaily reportSaleDaily) throws DataAccessFailureException;
    
    // TOP 机型查询(分页)
    public List<ReportSaleDaily> listPaginationByModel(Pagination<ReportSaleDaily> pagination, @Param("reportSaleDaily")ReportSaleDaily reportSaleDaily, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    // TOP 机型查询(导出)
    public List<ReportSaleDaily> queryReportSaleDailyListByModel(ReportSaleDaily reportSaleDaily) throws DataAccessFailureException;

    /**
     * 以companyId-cityId组合为Key按城市分组查出城市下总店铺数，如(1-2:20)
     * @return
     * @throws DataAccessFailureException
     */
    public List<Map> findShops4City() throws DataAccessFailureException;
    
    // 重点机型销量统计(分页查询)
    public List<ReportSaleDailyDto> listPaginationSaleModelData(Pagination<ReportSaleDailyDto> pagination, @Param("reportSaleDailyDto")ReportSaleDailyDto reportSaleDailyDto, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    // 重点机型销量统计(导出)
    public List<ReportSaleDailyDto> querySaleModelListByProperty(@Param("reportSaleDailyDto")ReportSaleDailyDto reportSaleDailyDto);
}
