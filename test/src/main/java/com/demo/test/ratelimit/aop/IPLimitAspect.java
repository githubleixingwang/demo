package com.demo.test.ratelimit.aop;

import com.demo.test.ratelimit.service.LoadingCacheService;
import com.demo.test.ratelimit.utils.IPUtil;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制ip的令牌桶
 * @author: lxw
 * @date: 2023-01-10  10:50
 */
@Component
@Scope
@Aspect
public class IPLimitAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private LoadingCacheService loadingCacheService;

    @Pointcut("@annotation(com.demo.test.ratelimit.annotation.IpLimit)")
    public void ipLimit() {

    }

    @Around("ipLimit()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;
        String ipAddr = IPUtil.getIpAddr(request);
        RateLimiter limiter = loadingCacheService.getIPLimiter(ipAddr);
        if (limiter.tryAcquire()) {
            // 获得令牌（不限制访问）
            obj = joinPoint.proceed();
        } else {
            // 未获得令牌（限制访问）
            obj = "error";
        }
        return obj;
    }

}
