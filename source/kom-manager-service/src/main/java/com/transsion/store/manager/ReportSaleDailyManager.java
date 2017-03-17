package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ReportSaleDaily;
import com.transsion.store.dto.ReportSaleDailyDto;
import com.transsion.store.mapper.ReportSaleDailyMapper;
import com.transsion.store.utils.ExcelUtils;

@Service("reportSaleDailyManager")
public class ReportSaleDailyManager {
	
	@Autowired
	private ReportSaleDailyMapper reportSaleDailyMapper;
	
	/**
	 * TOP 门店分页查询
	 * @param pagination
	 * @param reportSaleDaily
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ReportSaleDaily> listPaginationByShop(Pagination<ReportSaleDaily> pagination, ReportSaleDaily reportSaleDaily) throws ServiceException {
		List<ReportSaleDaily> list = reportSaleDailyMapper.listPaginationByShop(pagination, reportSaleDaily, pagination.getOrderBy());

		pagination.setResultList(list);

		return pagination;
	}
	
	/**
	 * TOP 门店查询(导出)
	 * @param reportSaleDaily
	 * @return
	 * @throws ServiceException
	 */
	public byte[] queryReportSaleDailyListByShop(ReportSaleDaily reportSaleDaily) throws ServiceException {
		String[] headers = {"排名","事业部","品牌","区域名称","国家","城市","门店编码","门店名称","门店等级", "销量"};
		List<ReportSaleDaily> list = reportSaleDailyMapper.queryReportSaleDailyListByShop(reportSaleDaily);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i = 1;
		for(ReportSaleDaily report :list){
			dataset.add(
					new Object[]{
							i++,
							report.getCompanyName(),
							report.getBrandCode(),
							report.getAreaName(),
							report.getCountryName(),
							report.getCityName(),
							report.getShopCode(),
							report.getShopName(),
							report.getGradeName(),
							report.getSaleQty()
				});
		}
		String title = "TOP门店报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	/**
	 * TOP 促销员分页查询
	 * @param pagination
	 * @param reportSaleDaily
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ReportSaleDaily> listPaginationBySale(Pagination<ReportSaleDaily> pagination, ReportSaleDaily reportSaleDaily) throws ServiceException {
		List<ReportSaleDaily> list = reportSaleDailyMapper.listPaginationBySale(pagination, reportSaleDaily, pagination.getOrderBy());

		pagination.setResultList(list);

		return pagination;
	}
	
	/**
	 * TOP 促销员查询导出
	 * @param reportSaleDaily
	 * @return
	 * @throws ServiceException
	 */
	public byte[] queryReportSaleDailyListBySale(ReportSaleDaily reportSaleDaily) throws ServiceException {
		String[] headers = {"排名","事业部","品牌","区域名称","国家","用户名","员工姓名","职位", "销量"};
		List<ReportSaleDaily> list = reportSaleDailyMapper.queryReportSaleDailyListBySale(reportSaleDaily);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i = 1;
		for(ReportSaleDaily report :list){
			dataset.add(
					new Object[]{
							i++,
							report.getCompanyName(),
							report.getBrandCode(),
							report.getAreaName(),
							report.getCountryName(),
							report.getUserCode(),
							report.getEmpName(),
							null,
							report.getSaleQty()
				});
		}
		String title = "TOP促销员报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	/**
	 * TOP 机型分页查询
	 * @param pagination
	 * @param reportSaleDaily
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ReportSaleDaily> listPaginationByModel(Pagination<ReportSaleDaily> pagination, ReportSaleDaily reportSaleDaily) throws ServiceException {
		List<ReportSaleDaily> list = reportSaleDailyMapper.listPaginationByModel(pagination, reportSaleDaily, pagination.getOrderBy());

		pagination.setResultList(list);

		return pagination;
	}
	
	/**
	 * TOP 机型查询导出
	 * @param reportSaleDaily
	 * @return
	 * @throws ServiceException
	 */
	public byte[] queryReportSaleDailyListByModel(ReportSaleDaily reportSaleDaily) throws ServiceException {
		String[] headers = {"排名","事业部","品牌","区域名称","机型名称","销量"};
		List<ReportSaleDaily> list = reportSaleDailyMapper.queryReportSaleDailyListByModel(reportSaleDaily);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i = 1;
		for(ReportSaleDaily report :list){
			dataset.add(
					new Object[]{
							i++,
							report.getCompanyName(),
							report.getBrandCode(),
							report.getAreaName(),
							report.getModelCode(),
							report.getSaleQty()
				});
		}
		String title = "TOP机型报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	public byte[] getReportSaleModelListByExcel(ReportSaleDailyDto reportSaleDailyDto) throws ServiceException {
		String[] headers = {"排名","事业部","品牌","区域名称","国家","城市","重点机型","销量"};
		List<ReportSaleDailyDto> list = reportSaleDailyMapper.querySaleModelListByProperty(reportSaleDailyDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i = 1;
		for(ReportSaleDailyDto report :list){
			dataset.add(
					new Object[]{
							i++,
							report.getCompanyName(),
							report.getBrandCode(),
							report.getAreaName(),
							report.getCountryName(),
							report.getCityName(),
							report.getBrandCode(),
							report.getSaleQty()
				});
		}
		String title = "重点机型销量统计报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
}
