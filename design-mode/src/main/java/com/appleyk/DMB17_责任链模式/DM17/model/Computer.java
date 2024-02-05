package com.appleyk.DMB17_责任链模式.DM17.model;

import lombok.Data;

/**
 * 电脑组合
 *
 * @author Appleyk
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 1:59 2018-11-6
 * @version v0.1.1
 */
@Data
public class Computer extends AbstractObject{

    /**
     * 公司
     */
    private String company;

    /**
     * 价钱
     */
    private Double price;

    /**
     * 组成 -- 显示器
     */
    private Monitor monitor;

    /**
     * 组成 -- 键盘
     */
    private Keyboard keyboard;

    /**
     * 组成 -- 鼠标
     */
    private Mouse mouse;

    public Computer(String company,Double price){
        this.company = company;
        this.price = price;
    }

    @Override
    public void show() {
        System.out.println("电脑");
    }
}
