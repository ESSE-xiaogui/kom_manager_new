package com.transsion.store.test.manager;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ReportSaleWeek;
import com.transsion.store.dto.ReportSaleWeek4CityDto;
import com.transsion.store.manager.ReportSaleWeekManager;
import com.transsion.store.mapper.ReportSaleWeekMapper;
import com.transsion.store.service.ReportSaleWeekService;
import com.transsion.store.test.base.GenericTestCase;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzh on 17-3-9.
 */
public class TestSaleWeekManager extends GenericTestCase {

    private ReportSaleWeekManager reportSaleWeekManager;

    private ReportSaleWeekService reportSaleWeekService;

    @Before
    protected void setUp() throws Exception {
        reportSaleWeekManager = this.getBean("reportSaleWeekManager");
        reportSaleWeekService = this.getBean("reportSaleWeekService");
    }

    @Test
    public void testListPage() throws ServiceException {
        Pagination<ReportSaleWeek> pagination = new Pagination<>();
        pagination.setPaginationFlag(true);
        pagination.setPageNo(1);

        ReportSaleWeek reportSaleWeek = new ReportSaleWeek();

        reportSaleWeekService.listPaginationByProperty(pagination, reportSaleWeek);
    }

    @Test
    public void testListPaginationCityWeekDataByRange() throws ServiceException {
        ReportSaleWeek reportSaleWeek = new ReportSaleWeek();
        Map<String, String> orderBy = new HashMap<>();

        orderBy.put("saleQty0", "desc");

        reportSaleWeek.setYear(2017);
        reportSaleWeek.setWeek(2);

        reportSaleWeek.setCompanyId(1L);
        Pagination<ReportSaleWeek4CityDto> pagination = new Pagination<>();

        pagination.setPaginationFlag(true);
        pagination.setPageNo(1);
        pagination.setOrderBy(orderBy);

        pagination = reportSaleWeekManager.listPaginationCityWeekDataByRange(pagination, reportSaleWeek);

        System.out.println(pagination.getResultList().size());
        System.out.println(pagination.getTotalPage());
        System.out.println(pagination);
    }
}
