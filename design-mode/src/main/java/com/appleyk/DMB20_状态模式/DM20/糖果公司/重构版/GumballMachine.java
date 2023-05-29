package com.appleyk.DMB20_状态模式.DM20.糖果公司.重构版;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class GumballMachine {

    HasQuarterState quarterState;
    NoQuarterState noQuarterState;
    SoldOutState soldOutState;
    SoldState soldState;
    WinnerState winnerState;
    State state ;

    int count = 0;

    public GumballMachine(int count){
        quarterState = new HasQuarterState(this);
        noQuarterState = new NoQuarterState(this);
        soldOutState = new SoldOutState(this);
        winnerState = new WinnerState(this);
        soldState = new SoldState(this);
        this.count = count;
        if (count <= 0){
            this.state = soldOutState;
        }else{
            this.state = noQuarterState;
        }
    }

    public void releaseBall(){
        if (count <=0 ){
            System.out.println("糖果已售罄！");
            this.state = soldOutState;
            return;
        }else{
            --count;
            /**如果减成功了，就把状态重置为未投币状态*/
            this.state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();;
    }

    public void turnCrank() {
        state.turnCrank();
        dispense();
    }

    private void dispense() {
        state.dispense();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    @Override
    public String toString() {
        if (state instanceof SoldOutState){
            return "GumballMachine{" +
                    "状态=已售罄, 糖果数=" + count +
                    '}';
        }else if (state instanceof SoldState){
            return "GumballMachine{" +
                    "状态=已售出, 糖果数=" + count +
                    '}';
        }else if (state instanceof HasQuarterState){
            return "GumballMachine{" +
                    "状态=已投币, 糖果数=" + count +
                    '}';
        }else if (state instanceof NoQuarterState){
            return "GumballMachine{" +
                    "状态=未投币状态, 糖果数=" + count +
                    '}';
        }else{
            return "";
        }
    }
}
