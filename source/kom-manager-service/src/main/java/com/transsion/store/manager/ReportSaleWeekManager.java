package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ReportSaleWeek;
import com.transsion.store.dto.AreaDto;
import com.transsion.store.dto.ReportSaleWeek4CityDto;
import com.transsion.store.mapper.ReportSaleWeekMapper;
import com.transsion.store.utils.CalendarUtils;
import com.transsion.store.utils.ExcelUtils;

@Service("reportSaleWeekManager")
public class ReportSaleWeekManager {
	
	@Autowired
	private ReportSaleWeekMapper reportSaleWeekMapper;
	
	@Autowired
	private AreaManager areaManager;
	
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

		Integer year;
		Integer week;

		Calendar calendar = Calendar.getInstance();

		//当年份或月份为空时，默认为当前年或当前时间所在的周数
		if(reportSaleWeek == null || reportSaleWeek.getYear() == null)
			year = CalendarUtils.getYear();
		else year = reportSaleWeek.getYear();

		if(reportSaleWeek == null || reportSaleWeek.getWeek() == null)
			week = CalendarUtils.getWeekOfYear(calendar.getTime());
		else week = reportSaleWeek.getWeek();

		List<Integer> dates = getDates(year, week);

		Integer start = getDate4YearWeek(year, week, 7);
		Integer end = getDate4YearWeek(year, week, 0);

		List<ReportSaleWeek4CityDto> list = reportSaleWeekMapper.listPaginationCityWeekDataByRange(pagination, reportSaleWeek, dates, start, end, pagination.getOrderBy());

		pagination.setResultList(list);

		return pagination;
	}

	/**
	 * 获取销量店铺周报表
	 * @param pagination
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ReportSaleWeek> listPaginationShopWeekData(Pagination<ReportSaleWeek> pagination, ReportSaleWeek reportSaleWeek) throws ServiceException {

		List<ReportSaleWeek> list = reportSaleWeekMapper.listPaginationShopWeekData(pagination, reportSaleWeek, pagination.getOrderBy());

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
	
	public Pagination<ReportSaleWeek4CityDto> listPaginationModelWeekDataByRange(Pagination<ReportSaleWeek4CityDto> pagination, ReportSaleWeek reportSaleWeek) throws ServiceException {

		Integer year;
		Integer week;

		Calendar calendar = Calendar.getInstance();

		//当年份或月份为空时，默认为当前年或当前时间所在的周数
		if(reportSaleWeek == null || reportSaleWeek.getYear() == null)
			year = CalendarUtils.getYear();
		else year = reportSaleWeek.getYear();

		if(reportSaleWeek == null || reportSaleWeek.getWeek() == null)
			week = CalendarUtils.getWeekOfYear(calendar.getTime());
		else week = reportSaleWeek.getWeek();

		List<Integer> dates = getDates(year, week);

		Integer start = getDate4YearWeek(year, week, 7);
		Integer end = getDate4YearWeek(year, week, 0);

		List<ReportSaleWeek4CityDto> list = reportSaleWeekMapper.listPaginationModelWeekDataByRange(pagination, reportSaleWeek, dates, start, end, pagination.getOrderBy());

		pagination.setResultList(list);

		return pagination;
	}
	
	public byte[] getReportModelWeekListByExcel(ReportSaleWeek reportSaleWeek) throws ServiceException {
		Integer year;
		Integer week;

		Calendar calendar = Calendar.getInstance();

		//当年份或月份为空时，默认为当前年或当前时间所在的周数
		if(reportSaleWeek == null || reportSaleWeek.getYear() == null)
			year = CalendarUtils.getYear();
		else year = reportSaleWeek.getYear();

		if(reportSaleWeek == null || reportSaleWeek.getWeek() == null)
			week = CalendarUtils.getWeekOfYear(calendar.getTime());
		else week = reportSaleWeek.getWeek();

		List<Integer> dates = getDates(year, week);

		Integer start = getDate4YearWeek(year, week, 7);
		Integer end = getDate4YearWeek(year, week, 0);
		
		List<Integer> weeks = getWeeksBefore(week);

		List<String> headerList = new ArrayList<String>();
		headerList.add("序号");
		headerList.add("事业部");
		headerList.add("品牌");
		headerList.add("重点机型");
		
		for(int i=0;i<weeks.size();i++){
			headerList.add("Week"+weeks.get(i));
		}
		
		String[] headers = (String[])headerList.toArray(new String[0]);
		List<ReportSaleWeek4CityDto> list = reportSaleWeekMapper.listPaginationModelWeekDataByRange(null, reportSaleWeek, dates, start, end, null);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i = 1;
		for(ReportSaleWeek4CityDto reportSaleWeek4CityDto :list){
			int qty1 = reportSaleWeek4CityDto.getSaleQty0();
			int qty2 = reportSaleWeek4CityDto.getSaleQty1();
			int qty3 = reportSaleWeek4CityDto.getSaleQty2();
			int qty4 = reportSaleWeek4CityDto.getSaleQty3();
			int qty5 = reportSaleWeek4CityDto.getSaleQty4();
			int qty6 =reportSaleWeek4CityDto.getSaleQty5();
            int qty7 =reportSaleWeek4CityDto.getSaleQty6();
            int qty8 =reportSaleWeek4CityDto.getSaleQty7();
			dataset.add(
					new Object[]{
							i++,
							reportSaleWeek4CityDto.getCompanyName(),
							reportSaleWeek4CityDto.getBrandCode(),
							reportSaleWeek4CityDto.getModelCode(),
							qty1,
							qty2,
							qty3,
							qty4,
							qty5,
							qty6,
							qty7,
							qty8,
							
				});
		}
		String title = "重点机型销量周报报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	public byte[] getReportSaleWeekCityByExcel(ReportSaleWeek reportSaleWeek) throws ServiceException{
		Integer year;
		Integer week;

		Calendar calendar = Calendar.getInstance();

		//当年份或月份为空时，默认为当前年或当前时间所在的周数
		if(reportSaleWeek == null || reportSaleWeek.getYear() == null)
			year = CalendarUtils.getYear();
		else year = reportSaleWeek.getYear();

		if(reportSaleWeek == null || reportSaleWeek.getWeek() == null)
			week = CalendarUtils.getWeekOfYear(calendar.getTime());
		else week = reportSaleWeek.getWeek();

		List<Integer> dates = getDates(year, week);

		Integer start = getDate4YearWeek(year, week, 7);
		Integer end = getDate4YearWeek(year, week, 0);
						
		Map<Long, AreaDto> areaMap = areaManager.queryAreaMap(reportSaleWeek.getCompanyId(), 0l);
		
		List<Integer> weeks = getWeeksBefore(week);
		String[] levelHeaders= {"一级区域","二级区域","三级区域","四级区域","五级区域"};
		
		List<ReportSaleWeek4CityDto> list = reportSaleWeekMapper.listPaginationCityWeekDataByRange(null, reportSaleWeek, dates, start, end, null);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i = 1;
		int length = 0;
		for(ReportSaleWeek4CityDto reportSaleWeek4CityDto :list){
			List<AreaDto> areaDtoList = areaManager.queryAreaPath(reportSaleWeek4CityDto.getAreaId(), areaMap);
			int size = areaDtoList.size();
			if(size>length){
				length = size;
			}
			Object[] objs = new Object[size+15];
			objs[0] = i++;
			objs[1] = reportSaleWeek4CityDto.getCompanyName();
			objs[2] = reportSaleWeek4CityDto.getBrandCode();
			for(int j=0;j<size;j++){
				objs[j+3] = areaDtoList.get(j).getAreaName();
			}
			int count = size+3;
			objs[count] = reportSaleWeek4CityDto.getCountryName();
			objs[++count] = reportSaleWeek4CityDto.getCityName();
			objs[++count] = reportSaleWeek4CityDto.getTotalShop();
			int qty1 = reportSaleWeek4CityDto.getSaleQty0();
			int qty2 = reportSaleWeek4CityDto.getSaleQty1();
			int qty3 = reportSaleWeek4CityDto.getSaleQty2();
			int qty4 = reportSaleWeek4CityDto.getSaleQty3();
			int qty5 = reportSaleWeek4CityDto.getSaleQty4();
			int qty6 =reportSaleWeek4CityDto.getSaleQty5();
            int qty7 =reportSaleWeek4CityDto.getSaleQty6();
            int qty8 =reportSaleWeek4CityDto.getSaleQty7();
            double avg = (qty1+qty2+qty3+qty4+qty5+qty6+qty7+qty8)/8;
            objs[++count] = qty1;
            objs[++count] = qty2;
            objs[++count] = qty3;
            objs[++count] = qty4;
            objs[++count] = qty5;
            objs[++count] = qty6;
            objs[++count] = qty7;
            objs[++count] = qty8;
            objs[++count] = avg;
			dataset.add(objs);
		}
		
		List<String> headerList = new ArrayList<String>();
		headerList.add("序号");
		headerList.add("事业部");
		headerList.add("品牌");
		for(int k=0; k< length; k++)
		{
			headerList.add(levelHeaders[k]);
		}
		headerList.add("国家");
		headerList.add("城市");
		headerList.add("门店总数");
		for(int j=0;j<weeks.size();j++){
			headerList.add("Week"+weeks.get(j));
		}
		headerList.add("P8W Ave");
		String[] headers = (String[])headerList.toArray(new String[0]);
		String title = "城市周销量报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	public Pagination<ReportSaleWeek4CityDto> listPaginationSRWeekDataByRange(Pagination<ReportSaleWeek4CityDto> pagination, ReportSaleWeek reportSaleWeek) throws ServiceException {

		Integer year;
		Integer week;

		Calendar calendar = Calendar.getInstance();

		//当年份或月份为空时，默认为当前年或当前时间所在的周数
		if(reportSaleWeek == null || reportSaleWeek.getYear() == null)
			year = CalendarUtils.getYear();
		else year = reportSaleWeek.getYear();

		if(reportSaleWeek == null || reportSaleWeek.getWeek() == null)
			week = CalendarUtils.getWeekOfYear(calendar.getTime());
		else week = reportSaleWeek.getWeek();

		List<Integer> dates = getDates(year, week);

		Integer start = getDate4YearWeek(year, week, 7);
		Integer end = getDate4YearWeek(year, week, 0);

		List<ReportSaleWeek4CityDto> list = reportSaleWeekMapper.listPaginationSRWeekDataByRange(pagination, reportSaleWeek, dates, start, end, pagination.getOrderBy());

		pagination.setResultList(list);

		return pagination;
	}
	
	public byte[] getReportSRWeekListByExcel(ReportSaleWeek reportSaleWeek) throws ServiceException {
		String[] headers = {"序号","事业部","品牌","销售区域","国家","城市","用户名", "员工姓名", "职位", "门店数"};
		List<ReportSaleWeek> list = reportSaleWeekMapper.queryListByProperty(reportSaleWeek);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i = 1;
		for(ReportSaleWeek report :list){
			dataset.add(
					new Object[]{
							i++,
							report.getCompanyName(),
							report.getBrandCode(),
							report.getAreaName(),
							report.getCountryName(),
							report.getCityName(),
							report.getUserCode(),
							report.getEmpName(),
							report.getTotalShop()
				});
		}
		String title = "销量库存周报报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	public Pagination<ReportSaleWeek4CityDto> listPaginationSaleModelByRange(Pagination<ReportSaleWeek4CityDto> pagination, ReportSaleWeek reportSaleWeek) throws ServiceException {

		Integer year;
		Integer week;

		Calendar calendar = Calendar.getInstance();

		//当年份或月份为空时，默认为当前年或当前时间所在的周数
		if(reportSaleWeek == null || reportSaleWeek.getYear() == null)
			year = CalendarUtils.getYear();
		else year = reportSaleWeek.getYear();

		if(reportSaleWeek == null || reportSaleWeek.getWeek() == null)
			week = CalendarUtils.getWeekOfYear(calendar.getTime());
		else week = reportSaleWeek.getWeek();

		List<Integer> dates = getDates(year, week);

		Integer start = getDate4YearWeek(year, week, 7);
		Integer end = getDate4YearWeek(year, week, 0);
		
		
		List<ReportSaleWeek4CityDto> list = reportSaleWeekMapper.listPaginationSaleModelByRange(pagination, reportSaleWeek, dates, start, end, pagination.getOrderBy());

		pagination.setResultList(list);

		return pagination;
	}
	
	public byte[] getReportSaleModelByExcel(ReportSaleWeek reportSaleWeek) throws ServiceException{
		Integer year;
		Integer week;

		Calendar calendar = Calendar.getInstance();

		//当年份或月份为空时，默认为当前年或当前时间所在的周数
		if(reportSaleWeek == null || reportSaleWeek.getYear() == null)
			year = CalendarUtils.getYear();
		else year = reportSaleWeek.getYear();

		if(reportSaleWeek == null || reportSaleWeek.getWeek() == null)
			week = CalendarUtils.getWeekOfYear(calendar.getTime());
		else week = reportSaleWeek.getWeek();

		List<Integer> dates = getDates(year, week);

		Integer start = getDate4YearWeek(year, week, 7);
		Integer end = getDate4YearWeek(year, week, 0);
		
		List<Integer> weeks = getWeeksBefore(week);

		List<String> headerList = new ArrayList<String>();
		headerList.add("序号");
		headerList.add("事业部");
		headerList.add("品牌");
		headerList.add("重点机型");
		
		for(int i=0;i<weeks.size();i++){
			headerList.add("Week"+weeks.get(i));
		}
		
		String[] headers = (String[])headerList.toArray(new String[0]);
		List<ReportSaleWeek4CityDto> list = reportSaleWeekMapper.listPaginationSaleModelByRange(null, reportSaleWeek, dates, start, end, null);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i = 1;
		for(ReportSaleWeek4CityDto reportSaleWeek4CityDto :list){
			int qty1 = reportSaleWeek4CityDto.getSaleQty0();
			int qty2 = reportSaleWeek4CityDto.getSaleQty1();
			int qty3 = reportSaleWeek4CityDto.getSaleQty2();
			int qty4 = reportSaleWeek4CityDto.getSaleQty3();
			int qty5 = reportSaleWeek4CityDto.getSaleQty4();
			int qty6 =reportSaleWeek4CityDto.getSaleQty5();
            int qty7 =reportSaleWeek4CityDto.getSaleQty6();
            int qty8 =reportSaleWeek4CityDto.getSaleQty7();
			dataset.add(
					new Object[]{
							i++,
							reportSaleWeek4CityDto.getCompanyName(),
							reportSaleWeek4CityDto.getBrandCode(),
							reportSaleWeek4CityDto.getModelCode(),
							qty1,
							qty2,
							qty3,
							qty4,
							qty5,
							qty6,
							qty7,
							qty8,
							
				});
		}
		String title = "重点机型销量走势报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
}
