package com.appleyk.DMC23_中介者模式.基础版;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *     抽象的同事类，也叫抽象组件，以前互相依赖的各个对象或组件，互
 *     相之间以“同事” 称呼。主要定义一些各个具体同事类之间共有的方法。
 * </p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/22:14:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Colleague {
    /**聚合（弱关联）中介者对象*/
    private Mediator mediator;
    private String name;
    public Colleague(String name,Mediator mediator){
        this.name = name;
        this.mediator = mediator;
    }
    public void receiveMsg(String name,String message){
        String sex = this instanceof BoyColleague ? "男" : "女";
        System.out.println(String.format("%s同事%s收到来自%s的消息：%s",sex,getName(),name,message));
        doReceiveMsg(name,message);
    }
    public abstract void doReceiveMsg(String name,String message);
}
