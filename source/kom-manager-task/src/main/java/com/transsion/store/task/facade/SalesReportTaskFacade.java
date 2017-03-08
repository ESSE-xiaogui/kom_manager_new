package com.transsion.store.task.facade;

import com.shangkang.core.exception.ServiceException;

/**
 * Created by liuzh on 17-3-8.
 */
public interface SalesReportTaskFacade {
    /**
     * 执行日销售与库存统计和周销售与库存统计汇总任务
     * 以上次执行日期为起始时间
     * @throws ServiceException
     */
    void executeStatisticsData() throws ServiceException;
}
