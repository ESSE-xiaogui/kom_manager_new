package com.transsion.store.test.manager;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ReportShopOtcRate;
import com.transsion.store.manager.ReportShopOtcRateManager;
import com.transsion.store.service.ReportShopOtcRateService;
import com.transsion.store.test.base.GenericTestCase;

public class TestReportShopOtcRateManager extends GenericTestCase {
	private ReportShopOtcRateManager reportShopOtcRateManager;
	
	private ReportShopOtcRateService reportShopOtcRateService;
	
	@Before
    protected void setUp() throws Exception {
		super.setUp();
		reportShopOtcRateManager = this.getBean("reportShopOtcRateManager");
		reportShopOtcRateService = this.getBean("reportShopOtcRateService");
    }
	
	@Test
	public void  testListPaginationByProperty() throws ServiceException {
		Pagination<ReportShopOtcRate> pagination = new Pagination<ReportShopOtcRate>();
		pagination.setPaginationFlag(true);
        pagination.setPageNo(1);
        ReportShopOtcRate reportShopOtcRate = new ReportShopOtcRate();
//        Pagination<ReportShopOtcRate> list = reportShopOtcRateService.listPaginationByProperty(pagination, reportShopOtcRate);
//        System.out.println(list.getTotal());
        
        
//        Pagination<ReportShopOtcRate> list1 = reportShopOtcRateService.listPgReportShopOtcRateByCity(pagination, reportShopOtcRate);
//        System.out.println(list1.getTotal());
	}
	
	@Test
	public void  testQueryReportSaleDailyListByProperty() throws ServiceException {
		 ReportShopOtcRate reportShopOtcRate = new ReportShopOtcRate();
//		 reportShopOtcRateManager.queryReportShopOtcRateList(reportShopOtcRate);
		 
		 reportShopOtcRateManager.queryReportShopOtcRateListByCity(reportShopOtcRate);
	}
}
