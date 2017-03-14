package com.transsion.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.TStockCurrent;
import com.transsion.store.dto.StockDto;

public interface TStockCurrentMapper extends GenericIBatisMapper<TStockCurrent, java.lang.Long> {
	public List<TStockCurrent> queryByProperty(TStockCurrent tStockCurrent);
	
	public int updateByProp(TStockCurrent tStockCurrent);
	
	public void saveTCurrentStockList(List<TStockCurrent> list);
	
	public List<StockDto> findCurrentStockByProp(@Param("userId") Integer userId, @Param("dealerId")Integer dealerId);
	
	public List<TStockCurrent> queryCurrentStockFromTShopStockDetail(String createTime);
}
