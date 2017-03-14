package com.transsion.store.test.manager;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitModelSettingListDto;
import com.transsion.store.manager.VisitModeSettingManager;
import com.transsion.store.test.base.GenericTestCase;

/**
 * @author guihua.zhang on 2017-03-14
 * */
public class TestVisitModelSettingManager extends GenericTestCase{
	
	private VisitModeSettingManager visitModeSettingManager;
	
	private UserContext userContext;
	
	@Before
    protected void setUp() throws Exception {
    	super.setUp();
    	visitModeSettingManager = this.getBean("visitModeSettingManager");
    	userContext = this.getUserContext("NG0238", "123456");
    }
    //根据城市ID和当月时间查询所有重点机型
    @Test
    public void testFindVisitModel() throws ServiceException{
    	Long cityId=51L;
    	String currentDate="2017-02-01";
    	List<VisitModelSettingListDto> list = visitModeSettingManager.findVisitModel(userContext.getToken(), cityId, currentDate);
    	System.out.println(list);
    }

}
