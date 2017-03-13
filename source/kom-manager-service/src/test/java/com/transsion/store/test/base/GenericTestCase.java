package com.transsion.store.test.base;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.context.UserContext;
import com.transsion.store.manager.UserManager;
import com.transsion.store.utils.MD5Utils;
import junit.framework.TestCase;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuzh on 17-3-8.
 */
public class GenericTestCase extends TestCase {

    private static ApplicationContext ctx;

    private UserManager userManager;

    static{
        String[] str = {"kom-service-context.xml", "kom-message-context.xml", "kom-right-context.xml"};
        ctx =  new ClassPathXmlApplicationContext(str);
    }

    @Before
    protected void setUp() throws Exception {
        userManager = getBean("userManager");
    }

    protected <T>T getBean(String beanId)
    {
        return (T) ctx.getBean(beanId);
    }

    protected UserContext getUserContext(String userCode, String password) throws ServiceException {

        return userManager.executeLogin(userCode, MD5Utils.encrypt(password));
    }
}
