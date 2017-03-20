package com.transsion.store.test.manager;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitPlanDto;
import com.transsion.store.manager.VisitPlanManager;
import com.transsion.store.test.base.GenericTestCase;

/**
 * @author guihua.zhang on 2017-03-20
 * */
public class TestVisitPlanManager extends GenericTestCase {

	private VisitPlanManager visitPlanManager;

	private UserContext userContext;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		visitPlanManager = this.getBean("visitPlanManager");
		userContext = this.getUserContext("CM0110", "123456");
	}

	// 保存巡店计划接口
	@Test
	public void testSavePlan() throws ServiceException {
		List<VisitPlanDto> params = new ArrayList<VisitPlanDto>();
		VisitPlanDto v1 = new VisitPlanDto();
		v1.setPlanDate("2017-03-20");
		v1.setShopId(2388L);
		params.add(v1);
		VisitPlanDto v2 = new VisitPlanDto();
		v2.setPlanDate("2017-03-21");
		v2.setShopId(4486L);
		params.add(v2);
		VisitPlanDto v3 = new VisitPlanDto();
		v3.setPlanDate("2017-03-22");
		v3.setShopId(4486L);
		params.add(v3);
		int result = visitPlanManager.savePlan(userContext.getToken(), params);
		System.out.println(result);
	}

}
