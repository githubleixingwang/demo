package com.demo.test.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext ctx) {
        context = ctx;
    }

    // 通过类名获取 Bean
    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    // 通过全路径类名获取 Bean
    public static Object getBean(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        return context.getBean(clazz);
    }
}
