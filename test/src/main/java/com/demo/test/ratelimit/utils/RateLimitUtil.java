package com.demo.test.ratelimit.utils;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: lxw
 * @date: 2023-01-10  10:54
 */
@Component
public class RateLimitUtil {
    private ConcurrentHashMap<String, RateLimiter> map = new ConcurrentHashMap<>();

    public RateLimiter getRateLimiter(Double limit, String methodName) {
        RateLimiter rateLimiter = null;
        if (map.containsKey(methodName)) {
            rateLimiter = map.get(methodName);
        } else {
            map.put(methodName, RateLimiter.create(limit));
            rateLimiter = map.get(methodName);
        }
        return rateLimiter;
    }
}
