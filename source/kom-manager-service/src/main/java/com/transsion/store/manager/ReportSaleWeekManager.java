package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ReportSaleWeek;
import com.transsion.store.mapper.ReportSaleWeekMapper;
import com.transsion.store.utils.ExcelUtils;

@Service("reportSaleWeekManager")
public class ReportSaleWeekManager {
	
	@Autowired
	private ReportSaleWeekMapper reportSaleWeekMapper;
	
	public byte[] getReportSaleWeekListByExcel(ReportSaleWeek reportSaleWeek) throws ServiceException {
		String[] headers = {"序号","事业部","品牌","周","大区","国家","区域","省份","城市","门店编码","门店名称","用户名", "员工姓名", "销量", "库存"};
		List<ReportSaleWeek> list = reportSaleWeekMapper.queryListByProperty(reportSaleWeek);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i = 1;
		for(ReportSaleWeek report :list){
			dataset.add(
					new Object[]{
							i++,
							report.getCompanyName(),
							report.getBrandCode(),
							report.getWeek(),
							null,
							report.getCountryName(),
							null,
							null,
							report.getCityName(),
							report.getShopCode(),
							report.getShopName(),
							report.getUserCode(),
							report.getEmpName(),
							report.getSaleQty(),
							report.getStockQty()
				});
		}
		String title = "销量库存周报报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
}
