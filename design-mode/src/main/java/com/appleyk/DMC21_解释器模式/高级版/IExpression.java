package com.appleyk.DMC21_解释器模式.高级版;

import java.util.Map;

/**
 * <p>表达式接口</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/17:12:33
 */
public interface IExpression {
    int interpret(Map<String,Integer> variables) throws Exception;
}
