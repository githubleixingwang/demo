package com.appleyk.DMB17_责任链模式.DM17_管道模式.handler;

/**
 * @author: lxw
 * @date: 2024-02-05  13:53
 */

import com.appleyk.DMB17_责任链模式.DM17_管道模式.data.PipelineContext;

/**
 * 管道中的上下文处理器
 */
public interface ContextHandler<T extends PipelineContext> {

    /**
     * 处理输入的上下文数据
     *
     * @param context 处理时的上下文数据
     * @return 返回 true 则表示由下一个 ContextHandler 继续处理，返回 false 则表示处理结束
     */
    boolean handle(T context);
}