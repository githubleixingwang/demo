package com.appleyk.DMA6_适配器模式.DM6.鸭鹅适配器.impl;

import com.appleyk.DMA6_适配器模式.DM6.鸭鹅适配器.Goose;
import com.appleyk.DMA6_适配器模式.DM6.鸭鹅适配器.Quackable;

/**
 * <p>大鹅适配器（对象适配器（组合方式））</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  下午10:53 2022/10/29
 */
public class GooseAdapter implements Quackable {
    Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();;
    }
}
