package com.transsion.store.test.facade;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.FileTemplate;
import com.transsion.store.facade.FileTemplateFacade;
import com.transsion.store.test.base.GenericTestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by liuzh on 17-3-8.
 */
public class TestFileTemplateFacade extends GenericTestCase{

    private FileTemplateFacade fileTemplateFacade;

    @Before
    protected void setUp() throws Exception {
        fileTemplateFacade = this.getBean("fileTemplateFacade");
    }

    @Test
    public void testList() throws ServiceException {
        List<FileTemplate> fileTemplates = fileTemplateFacade.list();

        assertNotNull(fileTemplates);

        for (FileTemplate fileTemplate : fileTemplates) {
            assertNull(fileTemplate);
        }
    }
}
