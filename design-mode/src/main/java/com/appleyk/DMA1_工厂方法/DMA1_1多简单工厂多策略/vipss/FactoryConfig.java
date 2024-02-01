package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vipss;

import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vipss.handler.FormItemVipss;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vipss.handler.ModuleVipss;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lxw
 * @date: 2024-02-01  15:58
 */
@Configuration
public class FactoryConfig {

    @Bean
    public StrategyVipssFactory<String, FormItemVipss> formItemVipssFactory() {
        return new StrategyVipssFactory<>(FormItemVipss.class);
    }

    @Bean
    public StrategyVipssFactory<String, ModuleVipss> moduleVipssFactory() {
        return new StrategyVipssFactory<>(ModuleVipss.class);
    }


}