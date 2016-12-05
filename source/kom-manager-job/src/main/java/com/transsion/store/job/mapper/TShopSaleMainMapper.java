
package com.transsion.store.job.mapper;
import java.util.List;
import java.util.Map;

import com.tecno.scm.sale.vo.TShopSaleItem;
import com.tecno.scm.sale.vo.TShopSales;

public interface TShopSaleMainMapper {
	public void saveSaleMain(TShopSales stockMain);
	public void saveStaleDetail(TShopSaleItem stockDetail);
	public String getSysDocSeqBySales(int companyId); 
	
	public List<TShopSales> queryAllSaleData(Map<String, Object> map);
	
	public List<TShopSaleItem> queryAllSaleItemData(Map<String, Object> map);
	
}
