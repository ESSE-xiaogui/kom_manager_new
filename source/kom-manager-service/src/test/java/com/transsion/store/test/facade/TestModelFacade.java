package com.transsion.store.test.facade;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.ModelInfoDto;
import com.transsion.store.facade.ModelFacade;
import com.transsion.store.test.base.GenericTestCase;

public class TestModelFacade  extends GenericTestCase{

	private ModelFacade modelFacade;
	
	private UserContext userContext;
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		modelFacade = this.getBean("modelFacade");
		userContext = this.getUserContext("NG0238", "123456");
	}
	@Test
	public void testFindModelList() throws ServiceException {
		List<ModelInfoDto> list = modelFacade.findModelList(userContext.getToken());
			System.out.println(list);
	}
}
