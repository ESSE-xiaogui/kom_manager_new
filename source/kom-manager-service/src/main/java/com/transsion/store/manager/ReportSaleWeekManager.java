package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import com.shangkang.core.bo.Pagination;
import com.transsion.store.dto.ReportSaleWeek4CityDto;
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

	/**
	 * 获取销量城市周报表
	 * @param pagination
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ReportSaleWeek4CityDto> listPaginationCityWeekDataByRange(Pagination<ReportSaleWeek4CityDto> pagination, ReportSaleWeek reportSaleWeek) throws ServiceException {

		Integer year = reportSaleWeek.getYear();
		Integer week = reportSaleWeek.getWeek();

		List<Integer> dates = getDates(reportSaleWeek.getYear(), reportSaleWeek.getWeek());

		Integer start = getDate4YearWeek(year, week, 7);
		Integer end = getDate4YearWeek(year, week, 0);

		List<ReportSaleWeek4CityDto> list = reportSaleWeekMapper.listPaginationCityWeekDataByRange(pagination, reportSaleWeek, dates, start, end, pagination.getOrderBy());

		pagination.setResultList(list);

		return pagination;
	}

	/**
	 * 根据输入年份和周数获取前8周日期和周（包括当前周），如果前9周则可将7改为8
	 * @param year
	 * @param week
	 * @return
	 */
	private List<Integer> getDates(Integer year, Integer week) {
		List<Integer> dates = new ArrayList<>();

		for(int i = 7; i >= 0; i--) {
			dates.add(getDate4YearWeek(year, week, i));
		}

		return dates;
	}

	/**
	 * 根据年份和周数及周期将年份及周数转换成yyyyww格式后再转成Integer,n为周数的第前n周
	 * @param year
	 * @param week
	 * @param n
	 * @return
	 */
	private Integer getDate4YearWeek(Integer year, Integer week, int n) {
		int tmp = (week - n > 0) ? (week - n) : (week - n + 52);
		year = (week - n > 0) ? year : (year - 1);
		return Integer.parseInt(new StringBuilder().append(year).append(String.format("%02d", tmp)).toString());
	}

	/**
	 * 根据输入周获取前8周列表
	 * @param week
	 * @return
	 */
	public List<Integer> getWeeksBefore(Integer week) throws ServiceException{
		List<Integer> weeks = new ArrayList<>();
		int tmp;
		for(int i = 7; i >= 0; i--) {
			tmp = (week - i > 0) ? (week - i) : (week - i + 52);
			weeks.add(tmp);
		}

		return weeks;
	}

}
