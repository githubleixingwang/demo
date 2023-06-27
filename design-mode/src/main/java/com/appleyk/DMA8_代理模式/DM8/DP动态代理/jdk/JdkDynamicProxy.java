package com.appleyk.DMA8_代理模式.DM8.DP动态代理.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>jdk动态代理类 == 程序运行时，代理类才知道被代理的对象是哪个</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 2018年11月10日 - 下午7:08:16
 */
public class JdkDynamicProxy implements InvocationHandler {

    /**
     * 被代理的目标对象
     */
    private Object targetObj;

    /**
     * 暂时不知道被代理的对象是人还是动物或是其它...etc
     */

    public JdkDynamicProxy(Object delegate) {
        this.targetObj = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是UU跑腿的工作人员，我去超市帮助客户取商品：" + args[0]);
        Object object = method.invoke(targetObj, args);
        System.out.println("拿到被代理对象调用的方法名：" + method.getName() + ",方法参数个数：" + method.getParameterCount());
        System.out.println("商品已成功转交给被代理的对象，期待对象好评");
        return object;
    }

}
