package com.appleyk.DMB20_状态模式.DM20.糖果公司.重构版;

/**
 * <p>未投币状态</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/27:16:26
 */
public class NoQuarterState implements State {

    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("您投入了25美分！");
        gumballMachine.setState(gumballMachine.getQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("请先投入25美分！");
    }

    @Override
    public void dispense() {
        System.out.println("我们无法为你发放糖果，请先投币然后再转动曲柄！");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你不能有白嫖的行为，不投币无法退币！");
    }

}
