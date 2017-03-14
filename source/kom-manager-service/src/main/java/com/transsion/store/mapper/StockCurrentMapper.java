package com.transsion.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.StockCurrent;
import com.transsion.store.dto.StockDto;

public interface StockCurrentMapper extends GenericIBatisMapper<StockCurrent, java.lang.Long> {
	public List<StockCurrent> queryByProperty(StockCurrent tStockCurrent);
	
	public int updateByProp(StockCurrent stockCurrent);
	
	public void saveTCurrentStockList(List<StockCurrent> list);
	
	public List<StockDto> findCurrentStockByProp(@Param("userId") Integer userId, @Param("dealerId")Integer dealerId);
	
	public List<StockCurrent> queryCurrentStockFromTShopStockDetail(String createTime);
}
