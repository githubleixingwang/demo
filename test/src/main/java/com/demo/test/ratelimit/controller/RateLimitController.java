package com.demo.test.ratelimit.controller;

import com.demo.test.ratelimit.annotation.RateLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author: lxw
 * @date: 2023-01-10  10:56
 */
@RestController
public class RateLimitController {
    @GetMapping(value = "/test")
    @RateLimit(limitNum = 5.0)
    public String test() {
        return "success";
    }

    @GetMapping(value = "/test2")
    @RateLimit(limitNum = 0.1)
    public String test2() {
        return  "success";
    }
}
