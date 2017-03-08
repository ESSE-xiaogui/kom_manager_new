package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.task.facade.SalesReportTaskFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by liuzh on 17-3-8.
 */
@Controller
@Path("reportTask")
public class ReportTaskController extends AbstractController {

    @Autowired
    private SalesReportTaskFacade salesReportTaskFacade;

    /**
     * 执行日销售与库存统计和周销售与库存统计汇总任务
     * 以上次执行日期为起始时间
     * @throws ServiceException
     */
    @GET
    @Path("/execute")
    @Produces({MediaType.APPLICATION_JSON})
    public void executeStatisticsData() throws ServiceException {
        salesReportTaskFacade.executeStatisticsData();
    }
}
