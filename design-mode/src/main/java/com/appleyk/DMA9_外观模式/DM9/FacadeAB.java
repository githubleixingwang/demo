package com.appleyk.DMA9_外观模式.DM9;

import com.appleyk.DMA9_外观模式.DM9.moduleA.FacadeA;
import com.appleyk.DMA9_外观模式.DM9.moduleB.FacadeB;

/**
 * <p>外观模式AB == 聚合子模块A和子模块B的功能，降低客户端使用模块A和模块B的复杂度</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 上午 8:59 2018-11-12
 */
public class FacadeAB {

    private FacadeA facadeA;
    private FacadeB facadeB;

    public FacadeAB() {
        facadeA = new FacadeA();
        facadeB = new FacadeB();
    }

    public void startSystem() {
        facadeA.initialize();
        facadeB.work();
    }
}
