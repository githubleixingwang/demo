package com.appleyk.DMB20_状态模式.DM20.猫科B_组合_状态.behavior;

/**
 * <p>爬树的行为接口</p>
 *
 * @author appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 13:45 2019/12/6
 */
public interface IClimbBehavior {
    /**
     * 具体谁来实现，会爬还是不会我不管，我只定义，不实现
     */
    String climbing();
}
