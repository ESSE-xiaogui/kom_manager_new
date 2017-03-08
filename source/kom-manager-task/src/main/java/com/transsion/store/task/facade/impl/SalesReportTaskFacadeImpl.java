package com.transsion.store.task.facade.impl;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.task.facade.SalesReportTaskFacade;
import com.transsion.store.task.manager.SalesReportTaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liuzh on 17-3-8.
 */
@Component("salesReportTaskFacade")
public class SalesReportTaskFacadeImpl implements SalesReportTaskFacade {

    @Autowired
    private SalesReportTaskManager salesReportTaskManager;

    /**
     * 执行日销售与库存统计和周销售与库存统计汇总任务
     * 以上次执行日期为起始时间
     * @throws ServiceException
     */
    @Override
    public void executeStatisticsData() throws ServiceException {
        salesReportTaskManager.executeStatisticsData();
    }
}
