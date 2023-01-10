package com.demo.test.designmode.celue;

public class MqttBroker implements BrokerInterface {
    @Override
    public String celue(String s) {
        return "mqtt发送消息" + s;
    }
}
