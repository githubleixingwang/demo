package com.demo.test.conditional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@ConditionalOnProperty(name = "conditional.isEnable",havingValue = "true")
@Component
public class ConditionalTest {


    @PostConstruct
    public void init() {
        System.out.println("aaaaaaaaaaaaa");
    }
}

