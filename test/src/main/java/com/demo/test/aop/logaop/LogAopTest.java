package com.demo.test.aop.logaop;

import com.demo.test.aop.logaop.annotation.LogEye;
import com.demo.test.aop.logaop.aspect.AA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component

@Scope("prototype")
public class LogAopTest {

    @Autowired
    private AA aa;
    //@Override
    @LogEye(desc = "aaaaaaaa")
    public String a(String a, String b){
        System.out.println(aa.getClass());
        return "返回值";
    }

}
