package com.transsion.test.base;

import com.shangkang.tools.UtilHelper;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * Created by liuzh on 17-3-8.
 */
public class GenericTestCase extends TestCase {

    private static ApplicationContext ctx;

    static{
        String[] str = {"root-context.xml"};
        ctx =  new ClassPathXmlApplicationContext(str);
    }

    private static String[] legalTransactionMethodNames = new String[]{"query","list","get","find","delete","update","modify","build","cancel","insert","edit","save", "batch", "create","execute","ext","processBatch"};
    private static String[] ignoreMethodNames = new String[]{"equals","toString","hashCode","indexOf","isFrozen","addAdvisor","setTargetSource","setPreFiltered","setExposeProxy","isExposeProxy","isProxyTargetClass","addAdvice","isPreFiltered","isInterfaceProxied","removeAdvisor","removeAdvice","replaceAdvisor","toProxyConfigString","wait","notify","notifyAll","newProxyInstance","isProxyClass"};

    protected <T>T getBean(String beanId)
    {
        return (T) ctx.getBean(beanId);
    }

    public void testTransactionMethodNameIsLegal()
    {
        String[] str = ctx.getBeanDefinitionNames();
        String beanName = null;
        Class clazz = null;
        String methodName = null;
        for (String string : str)
        {
            if(string != null && !"".equals(string) && string.endsWith("Facade"))
            {
                beanName = string;
                Object bean = ctx.getBean(beanName);
                clazz = bean.getClass();


                Method[] methods = clazz.getMethods();
                if(!UtilHelper.isEmpty(methods))
                {
                    for (Method method : methods)
                    {
                        methodName = method.getName();
                        if(!isMethodNameLegal(methodName))
                        {
                            System.out.println(bean + "::" + methodName);
                        }
                    }
                }
            }
        }
    }

    private boolean isMethodNameLegal(String methodName)
    {
        if(methodName == null) return false;

        for(String s : ignoreMethodNames)
        {
            if(s.equals(methodName))
            {
                return true;
            }
        }
        boolean isLegal = false;
        for (String s:legalTransactionMethodNames)
        {
            if(methodName.startsWith(s))
            {
                isLegal = true;
                break;
            }
        }
        return isLegal;
    }
}
