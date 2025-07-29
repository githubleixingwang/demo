package com.demo.test.scope;

import com.demo.test.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scope")
//@org.springframework.context.annotation.Scope(value = "prototype")
public class Scope {

   //CGlib代理，代理对象是一个，但代理对象指向的对象不是一个
   @Autowired
    private ScopeB scopeB;

    @RequestMapping("/test")
    public void a() {
        ScopeB b1 = SpringUtils.getBean(ScopeB.class);
        ScopeB b2 = SpringUtils.getBean(ScopeB.class);
        int i = scopeB.hashCode();
        int i1 = scopeB.hashCode();
    }
}
