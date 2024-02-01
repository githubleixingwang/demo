package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vips.handler;

import org.springframework.stereotype.Component;

/**
 * @author: lxw
 * @date: 2024-01-31  16:37
 */
@Component
public class InputItemVips implements FormItemVips {
    @Override
    public String getName() {
        return "inputVips";
    }

    @Override
    public String handler() {
        return "运行" + getName() + "的业务逻辑";
    }
}
