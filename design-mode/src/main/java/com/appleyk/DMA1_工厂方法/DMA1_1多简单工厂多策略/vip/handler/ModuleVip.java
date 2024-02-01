package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.handler;

import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.StrategyVip;

/**
 * @author: lxw
 * @date: 2024-01-31  16:40
 */
public interface ModuleVip extends StrategyVip<String> {

    @Override
    default String getId() { return getModule(); }
    String getModule();
    String handler();

}
