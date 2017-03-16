package com.transsion.store.test.manager;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ReportSaleDaily;
import com.transsion.store.manager.ReportShopOtcRateManager;
import com.transsion.store.test.base.GenericTestCase;

public class TestReportShopOtcRateManager extends GenericTestCase {
	private ReportShopOtcRateManager reportShopOtcRateManager;
	
	@Before
    protected void setUp() throws Exception {
		super.setUp();
		reportShopOtcRateManager = this.getBean("reportShopOtcRateManager");
    }
	
	@Test
	public void  testListPaginationByProperty() throws ServiceException {
		Pagination<ReportSaleDaily> pagination = new Pagination<ReportSaleDaily>();
		pagination.setPaginationFlag(true);
        pagination.setPageNo(1);
        ReportSaleDaily reportSaleDaily = new ReportSaleDaily();
        reportSaleDaily.setStartDate("2016-01-02");
        reportSaleDaily.setEndDate("2017-12-02");
	}
	
	
	@Test
	public void  testQueryReportSaleDailyListByProperty() throws ServiceException {
        ReportSaleDaily reportSaleDaily = new ReportSaleDaily();
        reportSaleDaily.setStartDate("2016-01-02");
        reportSaleDaily.setEndDate("2017-12-02");
        
	}
}
