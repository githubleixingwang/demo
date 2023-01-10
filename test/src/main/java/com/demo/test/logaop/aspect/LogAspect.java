package com.demo.test.logaop.aspect;

import com.demo.test.logaop.annotation.LogEye;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

@Aspect
@Component
@Slf4j

public class LogAspect {


    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.demo.test.logaop.annotation.LogEye)")
    public void logPointcut() {
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     *
     * @param joinPoint join point for advice
     */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        //获取注解相关
        LogEye logEye = method.getAnnotation(LogEye.class);
        String desc = logEye.desc();
        String declaringTypeName = signature.getDeclaringTypeName();
        String name = signature.getName();
        Parameter[] parameters = method.getParameters();
        Object proceed = joinPoint.proceed();
        System.out.println("自定义注解相关信息："+desc);
        System.out.println("类完整路径："+declaringTypeName);
        System.out.println("方法名称："+name);
        System.out.println("方法形参：");
        Arrays.stream(parameters).forEach(System.out::println);
        System.out.println("返回值："+proceed);
        return proceed;
    }
}