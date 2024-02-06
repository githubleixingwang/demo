package com.appleyk.DMB17_责任链模式.DM17_管道模式.handler;

import com.appleyk.DMB17_责任链模式.DM17_管道模式.data.InstanceBuildContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * InstanceBuildContext处理器
 *
 * @author: lxw
 * @date: 2024-02-05  14:16
 */
@Component
@Slf4j
public class InputDataPreCheckerHandler implements ContextHandler<InstanceBuildContext> {

    @Override
    public boolean handle(InstanceBuildContext context) {
        log.info("--输入数据校验--");

        Map<String, Object> formInput = context.getFormInput();

        if (MapUtils.isEmpty(formInput)) {
            context.setErrorMsg("表单输入数据不能为空");
            return false;
        }

        String instanceName = (String) formInput.get("instanceName");

        if (StringUtils.isBlank(instanceName)) {
            context.setErrorMsg("表单输入数据必须包含实例名称");
            return false;
        }

        return true;
    }
}
