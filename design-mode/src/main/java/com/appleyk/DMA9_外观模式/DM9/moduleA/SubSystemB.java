package com.appleyk.DMA9_外观模式.DM9.moduleA;

/**
 * <p>模块A下的子系统B</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 上午 9:00 2018-11-12
 */
public class SubSystemB {

    public void loadDatas() {
        System.out.println("人工智能系统已经启动，正在加载数据 =====>" + this);
        System.out.println(".........");
        System.out.println("数据已完成加载");
    }

    @Override
    public String toString() {
        return "人工智能系统，模块A，子系统B，主要负责加载数据";
    }
}
