package com.appleyk.DMB20_状态模式.DM20.糖果公司.重构版;

/**
 * <p>
 *     赢家状态
 *     这个是第一版糖果机重构后糖果机公司新增的一个功能：
 *        用户投入25美分，转动曲柄时，机器有50%的几率会发放两颗糖果（营销手段），
 *        这样做的目的就是让糖果机更受用户欢迎！
 *     使用状态模式，我们可以很容易的扩展糖果机程序（虽然破坏了开闭原则，但是核心的状态和行为二者是松耦合的）
 * </p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/28:9:22
 */
public class WinnerState implements State {

    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("机器正在分发糖果中，请稍后再投币...");
    }

    @Override
    public void turnCrank() {
        System.out.println("机器正在分发糖果中，转动曲柄无效！");
    }

    /**除了糖果分发和Sold状态处理的不一样外，其余action的内容和SoldState对应的行为一模一样*/
    @Override
    public void dispense() {
        System.out.println("恭喜你，你被抽选为幸运儿，你将获取两颗糖果！");
         gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0){
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }else{
            /**如果糖果够，再减一次*/
            gumballMachine.releaseBall();
        }
    }

    @Override
    public void ejectQuarter() {
        System.out.println("机器正在分发糖果种，无法退币！");
    }
}
