package com.appleyk.DMB20_状态模式.DM20.糖果公司.原始版;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     糖果机器（投币、转动摇臂、售出糖果）
 *     案例来自于《Head First》一书
 * </p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/27:13:38
 */
@Slf4j
public class GumballMachine {

    /**========= 基于需求流程图，确定糖果机器的状态有4种 ==========*/

    /**已售罄状态，机器安装的初始状态，因为安装的时候是不带糖果的*/
    final static int SOLD_OUT = 0;
    /**没有投入25美分的状态*/
    final static int NO_QUARTER = 1;
    /**投入了25美分的状态*/
    final static int HAS_QUARTER = 2;
    /**售出糖果的状态（这个含义就是：用户投钱了，且糖果机器有糖果，后面就是触发发放糖果action了）*/
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0){
            /**如果糖果机安装的时候内部放的有糖果，则状态就是未投钱状态*/
            this.state = NO_QUARTER;
        }
    }

    /**========= 基于需求流程图，确定糖果机器的行为有4种：投币、转动曲柄、退币、糖果发放 ==========*/

    /** 1. 投币动作，这里没考虑用户投的是多少，先按25美分处理 */
    public void insertQuarter(){
        if (state == HAS_QUARTER){
            log.info("您已经投过一次25美分了，请勿再投！");
        }else if (state == NO_QUARTER){
            log.info("您成功投入了25美分！");
            state = HAS_QUARTER;
        }else if (state == SOLD_OUT){
            log.info("您成功投入了25美分，但是我们没有糖果了，请进行退币操作！");
        }else if (state == SOLD){
            log.info("机器正在分发糖果中，请稍后再投币...");
        }
    }

    /** 2. 转动曲柄动作 */
    public void turnCrank(){
        log.info("您选择了转动曲柄，机器正在处理...");
        if (state == HAS_QUARTER){
            state = SOLD;
            dispense();
        }else if (state == NO_QUARTER){
            log.info("抱歉，你还没投币呢，不能给你发放糖果！");
        }else if (state == SOLD_OUT){
            log.info("抱歉，糖果已售罄！");
        }else if (state == SOLD){
            log.info("您已经转动过一次曲柄了，请耐心等待糖果的发放！");
        }
    }

    /** 3.发放糖果行为（这个属于机器内部操作，所以private修饰） ： 发放糖果时，状态必须处于SOLD，否则其他状态是不正常的 */
    private void dispense(){
        if (state == SOLD){
            log.info("一个糖果已售出，请拿好慢走，欢迎再次购买！");
            --count;
            if (0 == count){
                log.info("糖果机已经没有糖果了，后来的兄弟们不要投钱了！");
                state = SOLD_OUT;
            }else{
                state = NO_QUARTER;
            }
        }else if (state == NO_QUARTER){
            log.info("想要获得糖果请先投币！");
        }else if (state == SOLD_OUT){
            log.info("没有糖果可以发放！");
        }else if (state == HAS_QUARTER){
            log.info("非正常状态，请联系管理员！");
        }
    }

    /** 4.退币操作 */
    public void ejectQuarter(){
        log.info("您选择了退币操作，机器正在处理...");
        if (state == SOLD){
            log.info("抱歉，你的糖果已售出，无法退款！");
        }else if (state == HAS_QUARTER){
            log.info("已退币，请取！");
            state = NO_QUARTER;
        }else if (state == NO_QUARTER){
            log.info("您好，我们不支持白嫖，我们不欠你的！");
        }else if (state == SOLD_OUT){
            log.info("您好，糖果都没有了，你不可能发起退币操作的！");
        }
    }

    @Override
    public String toString() {
        switch (state){
            case 0 : return "GumballMachine{" +
                        "状态=已售罄, 糖果数=" + count +
                        '}';
            case 1: return "GumballMachine{" +
                    "状态=等待投币, 糖果数=" + count +
                    '}';
            case 2: return "GumballMachine{" +
                    "状态=已投币, 糖果数=" + count +
                    '}';
            case 3: return "GumballMachine{" +
                    "状态=已售出, 糖果数=" + count +
                    '}';
            default: return "GumballMachine{" +
                    "状态=未知状态, 糖果数=" + count +
                    '}';
        }
    }
}
