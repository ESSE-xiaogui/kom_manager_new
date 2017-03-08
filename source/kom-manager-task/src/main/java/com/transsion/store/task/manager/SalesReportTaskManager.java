package com.transsion.store.task.manager;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Configuration;
import com.transsion.store.bo.ReportSaleDaily;
import com.transsion.store.bo.ReportSaleWeek;
import com.transsion.store.mapper.ReportSaleDailyMapper;
import com.transsion.store.mapper.ReportSaleWeekMapper;
import com.transsion.store.mapper.SystemDateMapper;
import com.transsion.store.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzh on 17-3-8.
 */
@Service("salesReportTaskManager")
public class SalesReportTaskManager {

    @Autowired
    private SystemDateMapper systemDateMapper;

    @Autowired
    private ConfigurationService configurationService;

    @Autowired
    private ReportSaleDailyMapper reportSaleDailyMapper;

    @Autowired
    private ReportSaleWeekMapper reportSaleWeekMapper;

    private final static String SYSTEM_USER = "system";

    private final static String STATISTICS_DAILY_DATE = "STATISTICS_DAILY_DATE";

    /**
     * 执行日销售与库存统计和周销售与库存统计汇总任务
     * 以上次执行日期为起始时间
     * @throws ServiceException
     */
    public void executeStatisticsData() throws ServiceException {
        String systemDate = systemDateMapper.getCurrentDate();

        Configuration configuration = new Configuration();

        configuration.setName(STATISTICS_DAILY_DATE);

        List<Configuration> configurations = configurationService.listByProperty(configuration);

        String lastExecutedDate = null;

        if(!UtilHelper.isEmpty(configurations)) {
            configuration = configurations.get(0);
            lastExecutedDate = configuration.getValue();
        }

        if(UtilHelper.isEmpty(lastExecutedDate))
            lastExecutedDate = systemDate;

        executeStatisticsDailyData(systemDate, lastExecutedDate);
        executeStatisticsWeekData(systemDate, lastExecutedDate);

        configuration.setValue(systemDate);
        configurationService.saveOrUpdate(configuration);
    }

    private void executeStatisticsDailyData(String systemDate, String lastExecutedDate) throws ServiceException {
        List<ReportSaleDaily> reportSaleDailies = reportSaleDailyMapper.findUnStatisticsDataByDate(lastExecutedDate);
        ReportSaleDaily daily;
        List<ReportSaleDaily> rs = new ArrayList<>();

        for (ReportSaleDaily reportSaleDaily: reportSaleDailies) {
            daily = new ReportSaleDaily();

            daily.setCompanyId(reportSaleDaily.getCompanyId());
            daily.setShopId(reportSaleDaily.getShopId());
            daily.setUserCode(reportSaleDaily.getUserCode());
            daily.setSaleDate(reportSaleDaily.getSaleDate());
            daily.setBrandCode(reportSaleDaily.getBrandCode());
            daily.setModelCode(reportSaleDaily.getModelCode());

            List<ReportSaleDaily> dailies = reportSaleDailyMapper.listByProperty(daily);
            if (!UtilHelper.isEmpty(dailies)) {
                daily = dailies.get(0);

                daily.setSaleQty((daily.getSaleQty() == null ? 0 : daily.getSaleQty()) + (reportSaleDaily.getSaleQty() == null ? 0 : reportSaleDaily.getSaleQty()));
                daily.setStockQty((daily.getStockQty() == null ? 0 : daily.getStockQty()) + (reportSaleDaily.getStockQty() == null ? 0 : reportSaleDaily.getStockQty()));
                daily.setUpdatedBy(SYSTEM_USER);
                daily.setUpdateTime(systemDate);

                rs.add(daily);
            } else {
                reportSaleDaily.setCreatedBy(SYSTEM_USER);
                reportSaleDaily.setUpdatedBy(SYSTEM_USER);
                reportSaleDaily.setCreateTime(systemDate);
                reportSaleDaily.setUpdateTime(systemDate);

                rs.add(reportSaleDaily);
            }
        }

        reportSaleDailyMapper.batchSaveOrUpdate(rs);
    }

    private void executeStatisticsWeekData(String systemDate, String lastExecutedDate) throws ServiceException {
        List<ReportSaleWeek> reportSaleWeeks = reportSaleWeekMapper.findUnStatisticsDataByDate(lastExecutedDate);
        ReportSaleWeek week;
        List<ReportSaleWeek> rs = new ArrayList<>();

        for (ReportSaleWeek reportSaleWeek: reportSaleWeeks) {
            week = new ReportSaleWeek();

            week.setCompanyId(reportSaleWeek.getCompanyId());
            week.setShopId(reportSaleWeek.getShopId());
            week.setUserCode(reportSaleWeek.getUserCode());
            week.setBrandCode(reportSaleWeek.getBrandCode());
            week.setModelCode(reportSaleWeek.getModelCode());
            week.setYear(reportSaleWeek.getYear());
            week.setWeek(reportSaleWeek.getWeek());

            List<ReportSaleWeek> weeks = reportSaleWeekMapper.listByProperty(week);
            if (!UtilHelper.isEmpty(weeks)) {
                week = weeks.get(0);

                week.setSaleQty((week.getSaleQty() == null ? 0 : week.getSaleQty()) + (reportSaleWeek.getSaleQty() == null ? 0 : reportSaleWeek.getSaleQty()));
                week.setStockQty((week.getStockQty() == null ? 0 : week.getStockQty()) + (reportSaleWeek.getStockQty() == null ? 0 : reportSaleWeek.getStockQty()));
                week.setUpdatedBy(SYSTEM_USER);
                week.setUpdateTime(systemDate);

                rs.add(week);
            } else {
                reportSaleWeek.setCreatedBy(SYSTEM_USER);
                reportSaleWeek.setUpdatedBy(SYSTEM_USER);
                reportSaleWeek.setCreateTime(systemDate);
                reportSaleWeek.setUpdateTime(systemDate);

                rs.add(reportSaleWeek);
            }
        }

        reportSaleWeekMapper.batchSaveOrUpdate(rs);
    }
}
