package com.appleyk.DMC21_解释器模式.增强版;

/**
 * <p>表达式（解释）接口</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/16:21:40
 */
public interface IExpression {
    boolean interpret(String expression);
}
