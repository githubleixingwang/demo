package com.demo.vue.test.base.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 回调
 */
@Component
public class ACallBackTest implements MyCallBack {

    @Autowired
    private BCallBackTest b;

    @Override
    public void callBack() {
        System.out.println("A被回调");
    }


    public void a() {
        System.out.println("接口的默认方法"+this.def());
        System.out.println("接口的默认方法"+this.def2());
        System.out.println("A a 方法开始");
         b.b(this);
        System.out.println("A a 方法结束");

    }
}
