package com.demo.test.schedule.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * ☆☆☆☆☆需要重试的方案必须与调用的地方不在一个类，否则无法生效☆☆☆☆☆
 */
@Component
@Slf4j
public class RetryMethod {
    private int time = 1;

    @Retryable(value = {Exception.class},
            maxAttempts = 5, //重试次数
            backoff = @Backoff(value = 1,delay = 2000)) //重试间隔，单位毫秒
    public Boolean b() {
        Boolean result = true;
        try {
            time++;
            log.info("b方法业务步骤1");
            if (time < 3) {
                int b = 1 / 0;
            }
            log.info("b方法业务步骤2");
            result = true;
        } catch (Exception e) {
            log.info("b方法catch");
            result = false;
            throw new RuntimeException();//当必须使用finall时，catch中必须要手动throw否则Retryable捕捉不到异常无法重试
        } finally {
            log.info("b方法finally");
        }
        return result;
    }

    /**
     * 重试失败后的回调方法，若成功不会调用
     *
     * @param e
     * @return
     */
    @Recover
    public Boolean recoverOperation(Exception e) {
        //会以该方法的返回作为b方法的最终返回结果
        log.info("重试完了");
        return false;
    }
}
