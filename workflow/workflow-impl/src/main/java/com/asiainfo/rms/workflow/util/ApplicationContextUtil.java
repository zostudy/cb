package com.asiainfo.rms.workflow.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * ApplicationContextUtil
 * 
 * juchunsheng
 * juchunsheng
 * 2015-7-20 下午03:37:14
 * 
 * @version 1.0.0
 * 
 */
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext ac;
    
    public static ApplicationContext getAc() {
        return ac;
    }

    public static void setAc(ApplicationContext ac) {
        ApplicationContextUtil.ac = ac;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       
        ApplicationContextUtil.ac = applicationContext;
    }
    
    public static Object getBean(String beanName) {
        return ac.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz) {
        return ac.getBean(clazz);
    }
}
