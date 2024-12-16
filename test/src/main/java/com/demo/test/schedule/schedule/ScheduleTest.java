package com.demo.test.schedule.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduleTest {
    @Autowired
    private RetryMethod retryMethod;

    @Scheduled(cron = "0 */1 * * * ?")
    // @SchedulerLock(name = "lockTest", lockAtMostForString = "PT2M", lockAtLeastForString = "PT1M")
    public void a() {
        log.info("a方法业务步骤1");
        Boolean b = retryMethod.b();//Retryable会处理异常，此处不会再抛异常
        log.info("b方法的执行结果{}", b);
        log.info("a方法业务步骤2");
    }
}
