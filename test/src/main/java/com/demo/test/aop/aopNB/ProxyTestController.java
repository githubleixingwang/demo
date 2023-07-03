package com.demo.test.aop.aopNB;

import com.demo.test.aop.aopNB.aop1.InvokeRecordAnno;
import com.demo.test.aop.aopNB.aop2.LogAnno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lxw
 * @date: 2023-06-30  17:08
 */
@RestController
@RequestMapping("proxy")
public class ProxyTestController {

    @GetMapping("test1")
    @InvokeRecordAnno("测试代理模式")
    public Map<String, Object> testProxy() {
        Map<String, Object> result = new HashMap<>(4);
        result.put("id", 123);
        result.put("nick", "之叶");

        return result;
    }

    @GetMapping("test2")
    @LogAnno("测试日志模式")
    public Map<String, Object> testProxy2() {
        Map<String, Object> result = new HashMap<>(4);
        result.put("id", 123);
        result.put("aa", "aa");
        return result;
    }
}