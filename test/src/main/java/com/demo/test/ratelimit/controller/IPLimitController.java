package com.demo.test.ratelimit.controller;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import com.demo.test.ratelimit.annotation.IpLimit;
import com.demo.test.ratelimit.service.LoadingCacheService;
import com.demo.test.ratelimit.utils.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.util.concurrent.RateLimiter;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lxw
 * @date: 2023-01-10  10:55
 */
@RestController
public class IPLimitController {

    @Autowired
    private LoadingCacheService loadingCacheService;

    /**
     * 控制每秒N个许可(不限制IP)
     *
     * @return
     */
    @RequestMapping("/ratelimiter")
    @ResponseBody
    public String ratelimiter() {
        if (loadingCacheService.tryAcquire()) {
            // 获得令牌（不限制访问）
            return "success";
        } else {
            // 未获得令牌（限制访问）
            return "error";
        }
    }

    /**
     * 控制每个IP的每秒N个许可(限制IP访问接口频率)
     *
     * @param request
     * @return
     */
    @RequestMapping("/iplimiter")
    @ResponseBody
    public String ipLimiter(HttpServletRequest request) {
        String ipAddr = IPUtil.getIpAddr(request);
        try {
            RateLimiter limiter = loadingCacheService.getIPLimiter(ipAddr);
            if (limiter.tryAcquire()) {
                // 获得令牌（不限制访问）
                return "success";
            } else {
                // 未获得令牌（限制访问）
                return "error";
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return ipAddr;
    }

    /**
     * 基于 自定义注解+切面 的方式实现
     *
     * @return
     */
    @ResponseBody
    @IpLimit // 可以非常方便的通过这个注解来实现限流
    @RequestMapping("/annotation")
    public String test() {
        return "success";
    }
}
