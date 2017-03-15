package com.transsion.store.test.manager;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.ShopUserDto;
import com.transsion.store.manager.ShopManager;
import com.transsion.store.test.base.GenericTestCase;

/**
 * @author guihua.zhang on 2017-03-15
 * */
public class TestShopManager extends GenericTestCase{
	
	 	private ShopManager shopManager;
		
	    private UserContext userContext;

	    @Before
	    protected void setUp() throws Exception {
	    	super.setUp();
	    	shopManager = this.getBean("shopManager");
	    	userContext = this.getUserContext("NG0238", "123456");
	    }

	    //查询用户店铺信息和店铺巡店的最后时间 注:如果用户店铺为巡店的 最后巡店时间为NULL
	    @Test
	    public void testFindShopByUserId() throws ServiceException {
	    	List<ShopUserDto> list = shopManager.findShopByUserId(userContext.getToken());
	    	System.out.println(list);
	    }
}
