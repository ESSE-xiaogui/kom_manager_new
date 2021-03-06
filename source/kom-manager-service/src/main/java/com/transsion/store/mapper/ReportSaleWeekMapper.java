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
import com.transsion.store.bo.ReportSaleWeek;
import com.transsion.store.dto.ReportSaleWeek4CityDto;

public interface ReportSaleWeekMapper extends GenericIBatisMapper<ReportSaleWeek, java.lang.Long> {

    public List<ReportSaleWeek> listPaginationByProperty(Pagination<ReportSaleWeek> pagination, @Param("reportSaleWeek")ReportSaleWeek reportSaleWeek, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;

    public List<ReportSaleWeek> findUnStatisticsDataByDate(String date) throws DataAccessFailureException;
    
    public List<ReportSaleWeek> queryListByProperty(@Param("reportSaleWeek")ReportSaleWeek reportSaleWeek);

    public List<ReportSaleWeek4CityDto> listPaginationCityWeekDataByRange(Pagination<ReportSaleWeek4CityDto> pagination, @Param("reportSaleWeek")ReportSaleWeek reportSaleWeek, @Param("dates")List<Integer> dates, @Param("start")Integer start, @Param("end")Integer end, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;

    public List<ReportSaleWeek> listPaginationShopWeekData(Pagination<ReportSaleWeek> pagination, @Param("reportSaleWeek")ReportSaleWeek reportSaleWeek, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    
    public List<ReportSaleWeek4CityDto> listPaginationModelWeekDataByRange(Pagination<ReportSaleWeek4CityDto> pagination, @Param("reportSaleWeek")ReportSaleWeek reportSaleWeek, @Param("dates")List<Integer> dates, @Param("start")Integer start, @Param("end")Integer end, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    
    public List<ReportSaleWeek4CityDto> queryListByModel(@Param("reportSaleWeek")ReportSaleWeek reportSaleWeek);
    
    public List<ReportSaleWeek4CityDto> listPaginationSRWeekDataByRange(Pagination<ReportSaleWeek4CityDto> pagination, @Param("reportSaleWeek")ReportSaleWeek reportSaleWeek, @Param("dates")List<Integer> dates, @Param("start")Integer start, @Param("end")Integer end, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    public List<ReportSaleWeek> querySRWeekListByProperty(@Param("reportSaleWeek")ReportSaleWeek reportSaleWeek);
    
   
    // 重点机型销量走势(分页查询、导出)
    public List<ReportSaleWeek4CityDto> listPaginationSaleModelByRange(Pagination<ReportSaleWeek4CityDto> pagination, @Param("reportSaleWeek")ReportSaleWeek reportSaleWeek, @Param("dates")List<Integer> dates, @Param("start")Integer start, @Param("end")Integer end, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
}
