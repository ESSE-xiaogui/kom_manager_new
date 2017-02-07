/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 17:33:12
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

import com.transsion.store.bo.Stock;
import com.transsion.store.dto.StockDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface StockMapper extends GenericIBatisMapper<Stock, java.lang.Long> {

    public List<Stock> listPaginationByProperty(Pagination<Stock> pagination, @Param("stock")Stock stock, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    public List<StockDto> findPromoterStock(@Param("startDate")String startDate,@Param("endDate")String endDate, @Param("model") String model,@Param("userId") Integer userId);

	public List<StockDto> findPromoterCurrentStock(@Param("userId") Integer userId)throws DataAccessFailureException;
	
	public List<StockDto> findStocksByProp(@Param("shopId")Integer shopId,@Param("startDate")String startDate,@Param("endDate")String endDate, @Param("model") String model,@Param("userId") Integer userId)throws DataAccessFailureException;
	public List<StockDto> findCurrentStockByProp(@Param("userId") Integer userId, @Param("shopId")Integer shopId)throws DataAccessFailureException;

}
