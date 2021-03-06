/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 17:33:10
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

import com.transsion.store.bo.Sale;
import com.transsion.store.dto.SaleDailyDto;
import com.transsion.store.dto.SalesDto;
import com.transsion.store.dto.StatShopModelSaleDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;

import org.apache.ibatis.annotations.Param;

public interface SaleMapper extends GenericIBatisMapper<Sale, java.lang.Long> {

    public List<Sale> listPaginationByProperty(Pagination<Sale> pagination, @Param("sale")Sale sale, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    public List<SaleDailyDto> listPaginationByPropertys(Pagination<SaleDailyDto> pagination, @Param("saleDailyDto")SaleDailyDto saleDailyDto, @Param("orderBy1") Map<String, String> orderBy1) throws DataAccessFailureException;
    public SalesDto findSaleQty(@Param("userId")Integer userId,@Param("startDate")String startDate, @Param("endDate")String endDate);
    public List<SalesDto> findPromoterSales(@Param("startDate")String startDate, @Param("endDate")String endDate, @Param("model") String model, @Param("userId") Integer userId);
	public List<SaleDailyDto> listSaleByProperty(@Param("saleDailyDto")SaleDailyDto saleDailyDto)throws DataAccessFailureException;
//	public long calcShopSaleQty(@Param("shopId")long shopId, @Param("startDate")String startDate, @Param("endDate")String endDate) throws DataAccessFailureException;
	
	public List<Sale> calcShopSaleQty(@Param("shopIdList")List<Long> shopIdList, @Param("startDate")String startDate, @Param("endDate")String endDate) throws DataAccessFailureException;
	
	public List<StatShopModelSaleDto> calcShopModelSaleQty(@Param("shopId")long shopId, @Param("modelCodeList")List<String> modelCodeList, @Param("startDate")String startDate,
			@Param("endDate")String endDate) throws DataAccessFailureException;
}
