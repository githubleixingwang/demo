package com.appleyk.DMA6_适配器模式.DM6.鸭鹅适配器;

import com.appleyk.DMA6_适配器模式.DM6.鸭鹅适配器.impl.GooseAdapter;
import com.appleyk.DMA6_适配器模式.DM6.鸭鹅适配器.impl.MallardDuck;
import com.appleyk.DMA6_适配器模式.DM6.鸭鹅适配器.impl.RubberDuck;
import com.appleyk.DMA6_适配器模式.DM6.鸭鹅适配器.impl.TonyDuck;

/**
 * <p>鸭子模拟器（创建不同的实例来模拟鸭子叫）</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  下午10:43 2022/10/29
 */
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulatorQuack(new MallardDuck());
        duckSimulator.simulatorQuack(new TonyDuck());
        duckSimulator.simulatorQuack(new RubberDuck());
        /**
         * 此时我们有一个鹅类，它和鸭子很像，都会叫，都会游泳，且走路姿势都是左晃右晃的。
         * 这时候我们想用模拟器来模拟鸭子叫，不对，是鹅叫，但是鹅子类并没有实现鸭子的叫行为啊？
         * 但我就想用模拟鸭子叫的模拟器来模拟鹅叫什么办呢？用什么设计模式呢？那必然首当其选的就是
         * 适配器模式啊，适配器类实现主题接口，然后适配器类中组合被适配的对象，适配器实现主题接口时
         * 使用被适配对象的行为即可，当然主题接口的行为和被适配对象的行为要相似，不能主题接口实现
         * 的方法是鸭子叫，而被适配对象实现的是游泳那就过分了哈！
         */
        GooseAdapter gooseAdapter = new GooseAdapter(new Goose());
        duckSimulator.simulatorQuack(gooseAdapter);
    }

    void simulatorQuack(Quackable quackable){
        quackable.quack();
    }
}
