package com.demo.vue.test.designpattern.celue;


public class Broker {

    private BrokerInterface brokerInterface;

    public Broker(BrokerInterface a) {
        this.brokerInterface = a;
    }

    public String send(String s){
        return brokerInterface.celue(s);
    }
}
