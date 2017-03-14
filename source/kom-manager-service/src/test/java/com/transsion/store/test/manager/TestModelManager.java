package com.transsion.store.test.manager;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.ModelInfoDto;
import com.transsion.store.manager.ModelManager;
import com.transsion.store.test.base.GenericTestCase;

/**
 * @author guihua.zhang on 2017-03-14
 * */
public class TestModelManager extends GenericTestCase{

    private ModelManager modelManager;
	
    private UserContext userContext;

    @Before
    protected void setUp() throws Exception {
    	super.setUp();
    	modelManager = this.getBean("modelManager");
    	userContext = this.getUserContext("NG0238", "123456");
    }

    //查询机型和已绑定的机型
    @Test
    public void testFindModelList() throws ServiceException {
    	List<ModelInfoDto> list = modelManager.findModelList(userContext.getToken());
    	System.out.println(list);
    }

}
