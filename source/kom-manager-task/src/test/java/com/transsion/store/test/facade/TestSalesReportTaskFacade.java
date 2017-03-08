package com.transsion.store.test.facade;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.task.facade.SalesReportTaskFacade;
import com.transsion.store.test.base.GenericTestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by liuzh on 17-3-8.
 */
public class TestSalesReportTaskFacade extends GenericTestCase{

    private SalesReportTaskFacade salesReportTaskFacade;

    @Before
    protected void setUp() throws Exception {
        salesReportTaskFacade = getBean("salesReportTaskFacade");
    }

    @Test
    public void testExecuteStatisticsData() throws ServiceException {
        salesReportTaskFacade.executeStatisticsData();
    }
}
