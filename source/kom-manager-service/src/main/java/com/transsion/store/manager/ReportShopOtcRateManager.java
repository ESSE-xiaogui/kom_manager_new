package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ReportShopOtcRate;
import com.transsion.store.mapper.ReportShopOtcRateMapper;
import com.transsion.store.utils.ExcelUtils;

@Service("reportShopOtcRateManager")
public class ReportShopOtcRateManager {
	
	@Autowired
	private ReportShopOtcRateMapper reportShopOtcRateMapper;
	
	public byte[] queryReportShopOtcRateList(ReportShopOtcRate reportShopOtcRate) throws ServiceException {
		String[] headers = {"序号","事业部","品牌","年/月","国家","省份", "城市", "用户名","员工姓名","门店总数","机型名称","上柜门店数", "覆盖率"};
		List<ReportShopOtcRate> list = reportShopOtcRateMapper.queryReportShopOtcRateList(reportShopOtcRate);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i = 1;
		for(ReportShopOtcRate report :list){
			dataset.add(
					new Object[]{
							i++,
							report.getCompanyName(),
							report.getBrandCode(),
							report.getVisitDate(),
							report.getCountryName(),
							report.getRegionName(),
							report.getCityName(),
							report.getUserCode(),
							report.getEmpName(),
							report.getTotalShop(),
							report.getModelCode(),
							report.getVisitShop(),
							report.getOtcRate()
				});
		}
		String title = "TOP门店报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	public byte[] queryReportShopOtcRateListByCity(ReportShopOtcRate reportShopOtcRate) throws ServiceException {
		String[] headers = {"序号","事业部","品牌","年/月","国家","省份", "城市", "用户名","员工姓名","门店总数","机型名称","上柜门店数", "覆盖率"};
		List<ReportShopOtcRate> list = reportShopOtcRateMapper.queryReportShopOtcRateListByCity(reportShopOtcRate);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i = 1;
		for(ReportShopOtcRate report :list){
			dataset.add(
					new Object[]{
							i++,
							null,
							null,
							report.getVisitDate(),
							report.getCountryName(),
							report.getRegionName(),
							report.getCityName(),
							report.getUserCode(),
							report.getEmpName(),
							report.getTotalShop(),
							report.getModelCode(),
							report.getVisitShop(),
							report.getOtcRate()
				});
		}
		String title = "TOP门店报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
}
