package com.demo.vue.test.designpattern.celue;

public class KafkaBroker implements BrokerInterface{
    @Override
    public String celue(String s) {
        return "kafka发送消息" + s;
    }
}
