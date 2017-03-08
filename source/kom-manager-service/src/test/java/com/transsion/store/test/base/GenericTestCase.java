package com.transsion.store.test.base;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuzh on 17-3-8.
 */
public class GenericTestCase extends TestCase {

    private static ApplicationContext ctx;

    static{
        String[] str = {"kom-service-context.xml", "kom-message-context.xml", "kom-right-context.xml"};
        ctx =  new ClassPathXmlApplicationContext(str);
    }

    protected <T>T getBean(String beanId)
    {
        return (T) ctx.getBean(beanId);
    }

}
