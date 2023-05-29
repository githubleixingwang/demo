package com.appleyk.DMB20_状态模式.DM20.糖果公司.重构版;

/**
 * <p>状态接口</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/27:16:16
 */
public interface State {
    void insertQuarter();
    void turnCrank();
    void dispense();
    void ejectQuarter();
}
