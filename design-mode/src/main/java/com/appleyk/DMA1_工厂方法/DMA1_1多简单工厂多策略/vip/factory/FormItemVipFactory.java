package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.factory;

import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.StrategyVipFactory;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.handler.FormItemVip;
import org.springframework.stereotype.Component;

/**
 * @author: lxw
 * @date: 2024-01-31  16:27
 */
@Component
public class FormItemVipFactory extends StrategyVipFactory<String, FormItemVip> {

    @Override
    protected Class<FormItemVip> getStrategyType() {
        return FormItemVip.class;
    }
}