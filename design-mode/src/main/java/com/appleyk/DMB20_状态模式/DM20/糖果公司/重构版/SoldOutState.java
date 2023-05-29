package com.appleyk.DMB20_状态模式.DM20.糖果公司.重构版;

/**
 * <p>已售罄状态</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/27:16:29
 */
public class SoldOutState implements State {

    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("请勿投入25美分，因为机器中的糖果已售罄！");
    }

    @Override
    public void turnCrank() {
        System.out.println("无效操作，糖果已售罄！");
    }

    @Override
    public void dispense() {
        System.out.println("无效操作，糖果已售罄！");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("都售罄了，还想着退币，想什么呢？");
    }
}
