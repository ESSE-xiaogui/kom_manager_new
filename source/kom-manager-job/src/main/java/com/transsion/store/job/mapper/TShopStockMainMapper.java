
package com.transsion.store.job.mapper;

import java.util.List;
import java.util.Map;

import com.tecno.scm.af.vo.TShopStockDetail;
import com.tecno.scm.af.vo.TShopStockMain;

public interface TShopStockMainMapper {

	public void saveStockMain(TShopStockMain stockMain);
	
	public void saveStockDetail(TShopStockDetail stockDetail);
	
	public String getSysDocSeqByStock(int companyId); 
	
	public List<TShopStockMain> queryAllStockMainData(Map<String, Object> map);
	
	public List<TShopStockDetail> queryAllStockDetailData(Map<String, Object> map);
}
