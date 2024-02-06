package com.appleyk.DMB17_责任链模式.DM17_管道模式.data;

import lombok.Data;

import java.util.Map;

/**
 * 模型实例构建的上下文
 *
 * @author: lxw
 * @date: 2024-02-05  14:14
 */
@Data
public class InstanceBuildContext extends PipelineContext {

    /**
     * 模型 id
     */
    private Long modelId;

    /**
     * 用户 id
     */
    private long userId;

    /**
     * 表单输入
     */
    private Map<String, Object> formInput;

    /**
     * 保存模型实例完成后，记录下 id
     */
    private Long instanceId;

    /**
     * 模型创建出错时的错误信息
     */
    private String errorMsg;

    // 其他参数

    @Override
    public String getName() {
        return "模型实例构建上下文";
    }
}