package com.demo.test.logaop;

import com.demo.test.logaop.annotation.LogEye;

public interface ILogAopTest {
    @LogEye(desc = "aaaaaaaa")
    String a(String a, String b);
}
