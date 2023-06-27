package com.appleyk.DMA8_代理模式.DM8.DP动态代理.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author: lxw
 * @date: 2023-06-26  11:18
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}

