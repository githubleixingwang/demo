package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vips.factory;

import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vips.StrategyVipsFactory;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vips.handler.ModuleVips;
import org.springframework.stereotype.Component;

/**
 * @author: lxw
 * @date: 2024-01-31  16:28
 */
@Component
public class ModuleVipsFactory extends StrategyVipsFactory<String, ModuleVips> {

}