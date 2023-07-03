package com.demo.test.aop.aopNB.aop2;

import com.alibaba.fastjson.JSON;
import com.demo.test.aop.aopNB.BaseMethodAdviceHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: lxw
 * @date: 2023-06-30  17:03
 */
@Slf4j
@Component
public class LogHandler extends BaseMethodAdviceHandler<Object> {

    /**
     * 记录方法出入参和调用时长
     */
    @Override
    public void onComplete(ProceedingJoinPoint point, long startTime, boolean permitted, boolean thrown, Object result) {
        String methodDesc = getMethodDesc(point);
        Object[] args = point.getArgs();
        long costTime = System.currentTimeMillis() - startTime;

        log.warn("记录日志\n{} 执行结束，耗时={}ms，入参={}, 出参={}",
                methodDesc, costTime,
                JSON.toJSONString(args, true),
                JSON.toJSONString(result, true));
    }

    @Override
    protected String getMethodDesc(ProceedingJoinPoint point) {
        Method targetMethod = getTargetMethod(point);
        // 获得方法上的 InvokeRecordAnno
        LogAnno anno = targetMethod.getAnnotation(LogAnno.class);
        String description = anno.value();

        // 如果没有指定方法说明，那么使用默认的方法说明
        if (StringUtils.isBlank(description)) {
            description = super.getMethodDesc(point);
        }

        return description;
    }
}
