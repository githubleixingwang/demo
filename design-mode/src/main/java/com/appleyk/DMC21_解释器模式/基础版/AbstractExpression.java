package com.appleyk.DMC21_解释器模式.基础版;

/**
 * <p>
 *     定义解释器的接口，约定解释器的解释操作，主要包含解释方法 interpret()。
 * </p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 19:50 2022/10/16
 */
public abstract class AbstractExpression {
    /**
     * 对指定的句子进行解析
     * @param sentence 句子字符串
     */
    public abstract boolean interpret(String sentence);
}
