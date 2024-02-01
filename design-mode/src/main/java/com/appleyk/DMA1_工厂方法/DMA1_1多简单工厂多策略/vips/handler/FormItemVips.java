package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vips.handler;

import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vips.StrategyVips;

/**
 * @author: lxw
 * @date: 2024-01-31  16:31
 */
public interface FormItemVips extends StrategyVips<String> {

    @Override
    default String getId() { return getName(); }

    String getName();

    String handler();
}
