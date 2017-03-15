package com.transsion.store.test.manager;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.MaterialInfoDto;
import com.transsion.store.manager.MaterielManager;
import com.transsion.store.test.base.GenericTestCase;
/**
 * @author guihua.zhang on 2017-03-15
 * */
public class TestMaterielManager extends GenericTestCase{
	
		private MaterielManager materielManager;
		
	    private UserContext userContext;

	    @Before
	    protected void setUp() throws Exception {
	    	super.setUp();
	    	materielManager = this.getBean("materielManager");
	    	userContext = this.getUserContext("NG0238", "123456");
	    }

	    //查询机型和已绑定的机型
	    @Test
	    public void testfindMateriel() throws ServiceException {
	    	List<MaterialInfoDto> list = materielManager.findMateriel(userContext.getToken());
	    	System.out.println(list);
	    }
}
