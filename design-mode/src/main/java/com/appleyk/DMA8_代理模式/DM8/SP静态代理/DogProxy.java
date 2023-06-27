package com.appleyk.DMA8_代理模式.DM8.SP静态代理;

import com.appleyk.DMA8_代理模式.DM8.DP动态代理.jdk.service.CommodityService;
import com.appleyk.DMA8_代理模式.DM8.DP动态代理.jdk.service.impl.DogImpl;

/**
 * <p>宠物狗代理类 == 静态代理模式</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 2018年11月10日 - 下午8:25:51
 */
public class DogProxy implements CommodityService {

    private DogImpl dog;

    public DogProxy() {
        // 预先确定代理与被代理者的关系 -- 被代理的对象是宠物狗
        dog = new DogImpl();
    }

    @Override
    public void getCommodity(String name) {
        System.out.println("我是UU跑腿的工作人员，我去超市帮助狗狗取狗粮：" + name);
        dog.getCommodity(name);
        System.out.println("商品已成功交给狗狗，期待狗狗的主人好评");
    }

}
