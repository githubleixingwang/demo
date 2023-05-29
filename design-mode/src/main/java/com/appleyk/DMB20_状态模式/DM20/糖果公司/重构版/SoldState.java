package com.appleyk.DMB20_状态模式.DM20.糖果公司.重构版;

/**
 * <p>已售状态</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/27:16:28
 */
public class SoldState implements State {

    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    /**
     * 这个状态案例说是很少见的，因为用户投币，转动曲柄，机器分发，这一过程是很快的
     * 除非用户转动曲柄的同时又投了一枚硬币！
     */
    @Override
    public void insertQuarter() {
        System.out.println("机器正在分发糖果中，请稍后再投币...");
    }

    @Override
    public void turnCrank() {
        System.out.println("机器正在分发糖果中，转动曲柄无效！");
    }

    @Override
    public void dispense() {
        System.out.println("糖果已发放，请及时取走，欢迎下次再次购买！");
        gumballMachine.releaseBall();;
    }

    @Override
    public void ejectQuarter() {
        System.out.println("机器正在分发糖果种，无法退币！");
    }
}
