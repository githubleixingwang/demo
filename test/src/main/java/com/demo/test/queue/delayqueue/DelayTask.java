package com.demo.test.queue.delayqueue;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author: lxw
 * @date: 2023-01-12  17:14
 */
@Data
public class DelayTask implements Delayed {
    @Override
    public long getDelay(TimeUnit timeUnit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed delayed) {
        return 0;
    }
}
