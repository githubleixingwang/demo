package com.appleyk.DMB17_责任链模式.DM17_管道模式.handler;

import com.appleyk.DMB17_责任链模式.DM17_管道模式.data.InstanceBuildContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * InstanceBuildContext处理器
 * @author: lxw
 * @date: 2024-02-05  14:21
 */
@Component
@Slf4j
public class ModelInstanceCreatorHandler implements ContextHandler<InstanceBuildContext> {


    @Override
    public boolean handle(InstanceBuildContext context) {
        log.info("--根据输入数据创建模型实例--");

        // 假装创建模型实例

        return true;
    }
}