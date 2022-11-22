package com.demo.vue.test.designpattern.celue;

public class MqttBroker implements BrokerInterface {
    @Override
    public String celue(String s) {
        return "mqtt发送消息" + s;
    }
}
