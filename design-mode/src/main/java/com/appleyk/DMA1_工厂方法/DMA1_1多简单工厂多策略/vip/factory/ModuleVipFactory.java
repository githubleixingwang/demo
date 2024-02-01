package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.factory;

import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.StrategyVipFactory;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.handler.ModuleVip;
import org.springframework.stereotype.Component;

/**
 * @author: lxw
 * @date: 2024-01-31  16:28
 */
@Component
public class ModuleVipFactory extends StrategyVipFactory<String, ModuleVip> {

    @Override
    protected Class<ModuleVip> getStrategyType() {
        return ModuleVip.class;
    }
}