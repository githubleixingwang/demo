package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.normal.handler;

import org.springframework.stereotype.Component;

/**
 * @author: lxw
 * @date: 2024-01-31  16:37
 */
@Component
public class InputItemNormal extends FormItemNormal {
    @Override
    public String getName() {
        return "input";
    }

    @Override
    public String handler() {
        return "运行" + getName() + "的业务逻辑";
    }
}
