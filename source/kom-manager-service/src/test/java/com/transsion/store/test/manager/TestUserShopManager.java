package com.transsion.store.test.manager;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.UserShopDto;
import com.transsion.store.manager.UserShopManager;
import com.transsion.store.test.base.GenericTestCase;

public class TestUserShopManager extends GenericTestCase{

	private UserShopManager userShopManager;
	
    private UserContext userContext;

    @Before
    protected void setUp() throws Exception {
    	super.setUp();
    	userShopManager = this.getBean("userShopManager");
    	userContext = this.getUserContext("CM0110", "123456");
    }

    //查询用户店铺信息和店铺巡店的最后时间 注:如果用户店铺为巡店的 最后巡店时间为NULL
    @Test
    public void testSaveUserShop() throws ServiceException {
    	UserShopDto usDto = new UserShopDto();
    	Long shopId = 4499L;
    	List<Long> shopIds = new ArrayList<Long>();
    	shopIds.add(shopId);
    	usDto.setShopId(shopIds);
    	userShopManager.saveUserShop(userContext.getToken(),usDto);
    }
}
