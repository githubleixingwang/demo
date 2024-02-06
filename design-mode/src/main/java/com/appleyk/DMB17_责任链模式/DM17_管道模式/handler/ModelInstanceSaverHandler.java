package com.appleyk.DMB17_责任链模式.DM17_管道模式.handler;

import com.appleyk.DMB17_责任链模式.DM17_管道模式.data.InstanceBuildContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * InstanceBuildContext处理器
 * @author: lxw
 * @date: 2024-02-05  14:18
 */
@Component
@Slf4j
public class ModelInstanceSaverHandler implements ContextHandler<InstanceBuildContext>{
    @Override
    public boolean handle(InstanceBuildContext context) {
        log.info("--保存模型实例到相关DB表--");
        // 假装保存模型实例
        return true;
    }
}
