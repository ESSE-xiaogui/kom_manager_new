package com.transsion.store.test.manager;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.SalesDto;
import com.transsion.store.manager.SalesManager;
import com.transsion.store.test.base.GenericTestCase;

/**
 * @author guihua.zhang on 2017-03-20
 * */
public class TestSaleManager extends GenericTestCase{
	
	private SalesManager salesMannager;
	
    private UserContext userContext;

    @Before
    protected void setUp() throws Exception {
    	super.setUp();
    	salesMannager = this.getBean("salesMannager");
    	userContext = this.getUserContext("NG0238", "123456");
    }
    
    @Test
    public void testFindSales() throws ServiceException{
    	String startDate = "2017-03-01";
    	String endDate = "2017-03-20";
    	String model = "";
    	List<SalesDto> result = salesMannager.findPromoterSales(userContext.getToken(), startDate, endDate,model);
    	System.out.println(result);
    }
}
