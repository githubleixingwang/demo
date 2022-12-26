package com.demo.vue.test.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 回调
 */
@Component
public class BCallBackTest {

    @Autowired
    private ACallBackTest aCallBackTest;

    public void b(MyCallBack callBack) {
        System.out.println("B b执行...");
        System.out.println("B回调A的方法开始");
        //callBack.callBack();
        aCallBackTest.callBack();
        System.out.println("B回调A的方法结束");

    }

}
