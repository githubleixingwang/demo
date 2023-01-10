package com.demo.test.ratelimit.aop;


import java.lang.reflect.Method;

import com.demo.test.ratelimit.annotation.RateLimit;
import com.demo.test.ratelimit.utils.RateLimitUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.util.concurrent.RateLimiter;


/**
 * 控制某个方法的令牌桶
 * @author: lxw
 * @date: 2023-01-10  10:51
 */
@Component
@Scope
@Aspect
public class RateLimitAspect {

    private RateLimiter rateLimiter;

    @Autowired
    private RateLimitUtil rateLimitUtil;

    @Pointcut("@annotation(com.demo.test.ratelimit.annotation.RateLimit)")
    public void rateLimit() {
    }

    @Around("rateLimit()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;
        // 获取拦截的方法名
        Signature sig = joinPoint.getSignature();
        // 获取拦截的方法名
        MethodSignature msig = (MethodSignature) sig;
        // 返回被织入增加处理目标对象
        Object target = joinPoint.getTarget();
        // 为了获取注解信息
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        // 获取注解信息
        RateLimit annotation = currentMethod.getAnnotation(RateLimit.class);
        Double limitNum = annotation.limitNum();
        rateLimiter = rateLimitUtil.getRateLimiter(limitNum, msig.getName());
        if (rateLimiter.tryAcquire()) {
            // 获得令牌（不限制访问）
            obj = joinPoint.proceed();
        } else {
            // 未获得令牌（限制访问）
            obj = "error";
        }
        return obj;
    }

}
