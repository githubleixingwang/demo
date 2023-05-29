package com.appleyk.DMA6_适配器模式.DM6.鸭鹅适配器.impl;

import com.appleyk.DMA6_适配器模式.DM6.鸭鹅适配器.Quackable;

/**
 * <p>玩具鸭</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  下午10:41 2022/10/29
 */
public class TonyDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("玩具鸭叫：哇哇哇");
    }
}
