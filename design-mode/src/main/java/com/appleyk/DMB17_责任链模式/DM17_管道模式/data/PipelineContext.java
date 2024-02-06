package com.appleyk.DMB17_责任链模式.DM17_管道模式.data;

/**
 * @author: lxw
 * @date: 2024-02-05  13:52
 */

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 传递到管道的上下文
 */
@Data
public class PipelineContext {

    /**
     * 处理开始时间
     */
    private LocalDateTime startTime;

    /**
     * 处理结束时间
     */
    private LocalDateTime endTime;

    /**
     * 获取数据名称
     */
    public String getName() {
        return this.getClass().getSimpleName();
    }
}