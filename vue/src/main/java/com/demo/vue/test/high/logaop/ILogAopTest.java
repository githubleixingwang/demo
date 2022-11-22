package com.demo.vue.test.high.logaop;

import com.demo.vue.test.high.logaop.annotation.LogEye;

public interface ILogAopTest {
    @LogEye(desc = "aaaaaaaa")
    String a(String a, String b);
}
