package com.appleyk.DMA8_代理模式.DM8.DP动态代理.jdk;

import java.lang.reflect.Proxy;

/**
 * @author: lxw
 * @date: 2023-06-26  10:59
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个  (jdk代理类必须要实现接口)
                new JdkDynamicProxy(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }
}

