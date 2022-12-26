package com.demo.vue.test.designmode.celue;

import org.springframework.stereotype.Component;

/**
 * 策略模式
 */
@Component
public class CeLueTest {

/*
* 可优化if-else
* 策略模式 ：定义一系列算法，将每一个算法封装起来，并让它们可以相互替换。策略模式让算法独立于使用它的客户而变化。
* 1.  定义策略接口，抽象方法
* 2.  根据需求定义不同的策略实现类
* 3.  定义上下文类，以策略接口做参数实现上下文类的构造方法
* 4.  使用上下文类，传具体的策略实现类
* */
    public void send(String s){
        Broker mqttBroker = new Broker(new MqttBroker());
        String mqttMsg = mqttBroker.send(s);
        System.out.println(mqttMsg);
        Broker kafkaBroker = new Broker(new KafkaBroker());
        String kafkaMsg = kafkaBroker.send(s);
        System.out.println(kafkaMsg);
    }

}
