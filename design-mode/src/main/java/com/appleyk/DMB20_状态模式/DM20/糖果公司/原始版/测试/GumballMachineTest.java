package com.appleyk.DMB20_状态模式.DM20.糖果公司.原始版.测试;

import com.appleyk.DMB20_状态模式.DM20.糖果公司.原始版.GumballMachine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GumballMachineTest {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        log.info(gumballMachine.toString());

        /**第一种情况：用户投币+转动曲柄 */
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        log.info(gumballMachine.toString());

        log.info("===============分隔符=================");

        /**第二种情况：用户投币+退币*/
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        log.info(gumballMachine.toString());

        log.info("===============分隔符=================");

        /**第三种情况：用户投币+转动曲柄+转动曲柄*/
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.turnCrank();
        log.info(gumballMachine.toString());

        log.info("===============分隔符=================");

        /**第四种情况：用户投币+用户投币+转动曲柄*/
        gumballMachine.insertQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        log.info(gumballMachine.toString());


        log.info("===============分隔符=================");

        /**第四种情况（售罄）：用户投币+转动曲柄+用户投币+转动曲柄*/
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        log.info(gumballMachine.toString());

    }
}
