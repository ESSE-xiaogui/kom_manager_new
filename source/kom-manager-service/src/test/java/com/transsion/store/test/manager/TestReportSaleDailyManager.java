package com.transsion.store.test.manager;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ReportSaleDaily;
import com.transsion.store.manager.ReportSaleDailyManager;
import com.transsion.store.test.base.GenericTestCase;

public class TestReportSaleDailyManager extends GenericTestCase {
	private ReportSaleDailyManager reportSaleDailyManager;
	
	@Before
    protected void setUp() throws Exception {
		super.setUp();
		reportSaleDailyManager = this.getBean("reportSaleDailyManager");
    }
	
	@Test
	public void  testListPaginationByProperty() throws ServiceException {
		Pagination<ReportSaleDaily> pagination = new Pagination<ReportSaleDaily>();
		pagination.setPaginationFlag(true);
        pagination.setPageNo(1);
        ReportSaleDaily reportSaleDaily = new ReportSaleDaily();
        reportSaleDaily.setStartDate("2016-01-02");
        reportSaleDaily.setEndDate("2017-12-02");
        
        // TOP 门店分页查询
        Pagination<ReportSaleDaily> list = reportSaleDailyManager.listPaginationByShop(pagination, reportSaleDaily);
        System.out.println(list.getTotal());
        
        // TOP 促销员分页查询
        Pagination<ReportSaleDaily> list1 = reportSaleDailyManager.listPaginationBySale(pagination, reportSaleDaily);
        System.out.println(list1.getTotal());
        
        // TOP 机型分页查询
        Pagination<ReportSaleDaily> list2 = reportSaleDailyManager.listPaginationByModel(pagination, reportSaleDaily);
        System.out.println(list2.getTotal());
	}
	
	
	@Test
	public void  testQueryReportSaleDailyListByProperty() throws ServiceException {
        ReportSaleDaily reportSaleDaily = new ReportSaleDaily();
        reportSaleDaily.setStartDate("2016-01-02");
        reportSaleDaily.setEndDate("2017-12-02");
        
        // TOP 门店报表导出
        reportSaleDailyManager.queryReportSaleDailyListByShop(reportSaleDaily);
        
        // TOP 促销员报表导出
        reportSaleDailyManager.queryReportSaleDailyListBySale(reportSaleDaily);
        
        // TOP 机型报表导出
        reportSaleDailyManager.queryReportSaleDailyListByModel(reportSaleDaily);
	}
}
