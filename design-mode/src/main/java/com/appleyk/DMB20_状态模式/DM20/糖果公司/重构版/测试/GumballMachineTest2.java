package com.appleyk.DMB20_状态模式.DM20.糖果公司.重构版.测试;

import com.appleyk.DMB20_状态模式.DM20.糖果公司.重构版.GumballMachine;

/**
 * <p>糖果机程序重构版测试</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/28:9:42
 */
public class GumballMachineTest2 {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        System.out.println("============== 分隔符 ===============");

        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        System.out.println(gumballMachine);
        System.out.println("============== 分隔符 ===============");
    }
}
