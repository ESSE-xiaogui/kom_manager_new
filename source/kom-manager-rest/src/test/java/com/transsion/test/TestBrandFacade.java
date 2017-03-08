package com.transsion.test;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.DateHelper;
import com.transsion.store.bo.Brand;
import com.transsion.store.facade.BrandFacade;
import com.transsion.test.base.GenericTestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzh on 17-3-6.
 */
public class TestBrandFacade extends GenericTestCase {

    private BrandFacade facade;

    @Before
    protected void setUp() throws Exception {
        facade = this.getBean("brandFacade");
    }

    @Test
    public void testBatchSaveOrUpdate(String[] s) throws ServiceException {

            Brand brand = new Brand();

            brand.setId(104L);
            brand.setBrandCode("NOK12");
            brand.setBrandName("12123");
            brand.setCreatedBy("sfsdf22");
            brand.setIsSelf(1);
            brand.setIsInactive(0);
            brand.setCreatedTime(DateHelper.nowString(DateHelper.TIME_PATTERN_DEFAULT));

            Brand brand1 = new Brand();

//            brand1.setId(1062L);
            brand1.setBrandCode("NOKQQ122");
            brand1.setBrandName("qw12");
            brand1.setCreatedBy("QQQ2");
            brand1.setIsSelf(1);
            brand1.setIsInactive(0);
            brand1.setCreatedTime(DateHelper.nowString(DateHelper.TIME_PATTERN_DEFAULT));

            List<Brand> list = new ArrayList<>();

            list.add(brand);
            list.add(brand1);

            facade.batchSaveOrUpdate(list);
    }
}
