package com.appleyk.DMA8_代理模式.DM8.NP非代理;

import com.appleyk.DMA8_代理模式.DM8.service.CommodityService;

/**
 * <p>用户自己去超市取商品 </p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 2018年11月10日 - 下午5:37:53
 */
public class UserOwn implements CommodityService {

    @Override
    public void getCommodity(String name) {
        goSuperMarket();
        choose(name);
        pay();
        System.out.println("用户获得商品：" + name);
        goHome();
    }

    private void goSuperMarket() {
        System.out.println("去超市");
    }

    private void choose(String name) {
        System.out.println("选商品: " + name);
    }

    private void pay() {
        System.out.println("付钱");
    }

    private void goHome() {
        System.out.println("买完商品，回家");
    }

}
