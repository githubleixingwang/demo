package com.demo.test.aop.logaop;

import com.demo.test.aop.logaop.annotation.LogEye;

public interface ILogAopTest {
    @LogEye(desc = "aaaaaaaa")
    String a(String a, String b);
}
