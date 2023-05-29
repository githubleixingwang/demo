package com.appleyk.DMA9_外观模式.DM9.moduleB;

/**
 * <p>外观模式B == 聚合子模块B中的子系统C和D，降低客户端操作子模块B的复杂度</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 上午 9:13 2018-11-12
 */
public class FacadeB {

    private SubSystemC subSystemC;
    private SubSystemD subSystemD;

    public FacadeB() {
        subSystemC = new SubSystemC();
        subSystemD = new SubSystemD();
    }

    /**
     * 将模块A的功能封装一下，松散客户端与A模块中的各个子系统间的耦合关系
     * 让模块中的各个子系统更容易扩展和维护
     */
    public void work() {
        subSystemC.sayHello();
        subSystemD.working();
    }
}
