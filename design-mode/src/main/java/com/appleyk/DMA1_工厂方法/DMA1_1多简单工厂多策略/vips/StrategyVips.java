package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vips;

/**
 * 策略抽象：各工厂对应的业务类中方法名称不统一，故抽象一层，用于适配所有工厂对应的业务类
 *
 * @author: lxw
 * @date: 2024-01-31  17:10
 */
public interface StrategyVips<T> {

    /**
     * 获得策略的标识
     */
    T getId();
}