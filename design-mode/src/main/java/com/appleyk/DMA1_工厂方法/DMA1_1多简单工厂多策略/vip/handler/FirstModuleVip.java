package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.handler;

import org.springframework.stereotype.Component;

/**
 * @author: lxw
 * @date: 2024-01-31  16:41
 */
@Component
public class FirstModuleVip implements ModuleVip {
    @Override
    public String getModule() {
        return "firstVip";
    }

    @Override
    public String handler() {
        return "运行" + getModule() + "的业务逻辑";
    }
}
