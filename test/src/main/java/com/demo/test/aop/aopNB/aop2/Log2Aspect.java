package com.demo.test.aop.aopNB.aop2;

import com.demo.test.aop.aopNB.BaseMethodAspect;
import com.demo.test.aop.aopNB.MethodAdviceHandler;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: lxw
 * @date: 2023-06-30  17:04
 */
@Aspect
@Order(1)
@Component
public class Log2Aspect extends BaseMethodAspect {

    /**
     * 指定切点（处理打上 InvokeRecordAnno 的方法）
     */
    @Override
    @Pointcut("@annotation(com.demo.test.aop.aopNB.aop2.LogAnno)")
    protected void pointcut() {
    }

    /**
     * 指定该切面绑定的方法切面处理器为 InvokeRecordHandler
     */
    @Override
    protected Class<? extends MethodAdviceHandler<?>> getAdviceHandlerType() {

        return LogHandler.class;
    }
}
