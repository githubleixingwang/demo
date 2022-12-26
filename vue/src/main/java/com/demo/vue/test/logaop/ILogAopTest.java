package com.demo.vue.test.logaop;

import com.demo.vue.test.logaop.annotation.LogEye;

public interface ILogAopTest {
    @LogEye(desc = "aaaaaaaa")
    String a(String a, String b);
}
