package com.appleyk.DMA6_适配器模式.DM6.鸭鹅适配器.impl;

import com.appleyk.DMA6_适配器模式.DM6.鸭鹅适配器.Quackable;

/**
 * <p>橡皮鸭</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  下午10:38 2022/10/29
 */
public class RubberDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("橡皮鸭叫：吱吱吱");
    }
}
