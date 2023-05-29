package com.appleyk.DMB20_状态模式.DM20.开关案例;

/**
 * <p>具体实现的状态类A</p>
 *
 * @author appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2019/12/6 11:00 PM
 */
public class ConcreteStateA extends AState {
    @Override
    public void handle(Context context) {
        System.out.println("我是状态A,开");
        // 状态切换到关
        context.setState(new ConcreteStateB());
    }
}
