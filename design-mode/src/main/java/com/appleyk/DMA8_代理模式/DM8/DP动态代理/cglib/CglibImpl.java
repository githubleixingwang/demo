package com.appleyk.DMA8_代理模式.DM8.DP动态代理.cglib;

/**
 * @author: lxw
 * @date: 2023-06-26  11:15
 */
public class CglibImpl {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
