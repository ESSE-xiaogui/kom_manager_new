package com.transsion.store.test.manager;

import com.transsion.store.mapper.ReportSaleDailyMapper;
import com.transsion.store.service.ReportSaleDailyService;
import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ReportSaleDaily;
import com.transsion.store.dto.ReportSaleDailyDto;
import com.transsion.store.manager.ReportSaleDailyManager;
import com.transsion.store.test.base.GenericTestCase;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestReportSaleDailyManager extends GenericTestCase {
	private ReportSaleDailyManager reportSaleDailyManager;
    private ReportSaleDailyService reportSaleDailyService;

    @Before
    protected void setUp() throws Exception {
		super.setUp();
		reportSaleDailyManager = this.getBean("reportSaleDailyManager");
        reportSaleDailyService = this.getBean("reportSaleDailyService");
    }
	
	@Test
	public void  testListPaginationByProperty() throws ServiceException {
//		Pagination<ReportSaleDaily> pagination = new Pagination<ReportSaleDaily>();
//		pagination.setPaginationFlag(true);
//        pagination.setPageNo(1);
//        ReportSaleDaily reportSaleDaily = new ReportSaleDaily();
//        reportSaleDaily.setStartDate("2016-01-02");
//        reportSaleDaily.setEndDate("2017-12-02");
//        
//        // TOP 门店分页查询
//        Pagination<ReportSaleDaily> list = reportSaleDailyManager.listPaginationByShop(pagination, reportSaleDaily);
//        System.out.println(list.getTotal());
//        
//        // TOP 促销员分页查询
//        Pagination<ReportSaleDaily> list1 = reportSaleDailyManager.listPaginationBySale(pagination, reportSaleDaily);
//        System.out.println(list1.getTotal());
//        
//        // TOP 机型分页查询
//        Pagination<ReportSaleDaily> list2 = reportSaleDailyManager.listPaginationByModel(pagination, reportSaleDaily);
//        System.out.println(list2.getTotal());
        
        // 重点机型销量统计分页查询
        Pagination<ReportSaleDailyDto> pagination = new Pagination<ReportSaleDailyDto>();
		pagination.setPaginationFlag(true);
        pagination.setPageNo(1);
        ReportSaleDailyDto reportSaleDailyDto = new ReportSaleDailyDto();
        Pagination<ReportSaleDailyDto> list3 = reportSaleDailyService.listPgSaleModelData(pagination, reportSaleDailyDto);
        System.out.println(list3.getTotal());
	}
	
	
//	@Test
//	public void  testQueryReportSaleDailyListByProperty() throws ServiceException {
//        ReportSaleDaily reportSaleDaily = new ReportSaleDaily();
//        reportSaleDaily.setStartDate("2016-01-02");
//        reportSaleDaily.setEndDate("2017-12-02");
//        
//        // TOP 门店报表导出
//        reportSaleDailyManager.queryReportSaleDailyListByShop(reportSaleDaily);
//        
//        // TOP 促销员报表导出
//        reportSaleDailyManager.queryReportSaleDailyListBySale(reportSaleDaily);
//        
//        // TOP 机型报表导出
//        reportSaleDailyManager.queryReportSaleDailyListByModel(reportSaleDaily);
//	}

    /**
     * @return
     * @throws ServiceException
     */
//    @Test
//    public void testFindShops4City() throws ServiceException {
//
//        Map<String, Integer> resultMap = reportSaleDailyService.findShops4City();
//
//        System.out.println(resultMap);
//    }
}
