package com.transsion.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.StockCurrent;
import com.transsion.store.dto.StockDto;

public interface StockCurrentMapper extends GenericIBatisMapper<StockCurrent, java.lang.Long> {
	
	 public List<StockCurrent> listPaginationByProperty(Pagination<StockCurrent> pagination, @Param("stockCurrent")StockCurrent stockCurrent, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
	
	public List<StockDto> findCurrentStockByProp(@Param("userId") Integer userId, @Param("dealerId")Integer dealerId);
	
	public List<StockCurrent> queryCurrentStockFromTShopStockDetail(String createTime);
}
