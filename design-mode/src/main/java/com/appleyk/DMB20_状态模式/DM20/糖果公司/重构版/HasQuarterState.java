package com.appleyk.DMB20_状态模式.DM20.糖果公司.重构版;

import java.util.Random;

/**
 * <p>已投币状态</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/27:16:27
 */
public class HasQuarterState implements State {

    Random randomWinner = new Random(System.currentTimeMillis());
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("请勿重复投入25美分！");
    }

    @Override
    public void turnCrank() {
        System.out.println("您转动了曲柄...");
        int number = randomWinner.nextInt(10);
        /**只有50%概率会触发2次糖果发放*/
        if (number < 5 && gumballMachine.getCount()>=2){
            gumballMachine.setState(gumballMachine.getWinnerState());
        }else {
            /**如果没有中奖，就切换到sold状态*/
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    /**
     * 这个是机器内部行为，不对外暴露，但是既然作为接口中的方法，这里只能以不妥的方式实现了
     * 因为只有机器状态为售出状态时，才会对用户发放糖果，而不能直接投币就触发发送
     * 所以这个分发糖果的行为不能外部去直接调用，而是有机器内部的状态改变去驱动糖果分发行为的发生
     */
    @Override
    public void dispense() {
        System.out.println("糖果发送中。。。");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("已退币，请查收。");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
}
