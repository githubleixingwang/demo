package com.appleyk.DMC21_解释器模式.基础版;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 *     非终端表达式类也是抽象表达式的子类，用来实现文法中与非终结符相关的操作，
 *     文法中的每条规则都对应于一个非终结符表达式。
 *
 *     白话：终结符我们知道了，那非终结符是什么呢？所谓的非终结就是组合各种
 *     终端表达式类（当然也可以是非终端表达式类）来构建一个新的终端表达式（组合优于继承），
 *     比如拿我们这个基础版的例子来说，终端表达式就是判断一个句子中是否含有某个word（具体落地到word），
 *     如果我想判断含有N个word怎么办？那就使用非终端表达式类组合多个终端表达式类
 *     即可，秉承设计模式面向接口（抽象）开发的良好习惯来说，我们直接使用抽象类AbstractExpression即可。
 * </p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 19:50 2022/10/16
 */
@Data
@AllArgsConstructor
public class NoTerminalExpression extends AbstractExpression{

    /**表达式1*/
    private AbstractExpression expression1;
    /**表达式2*/
    private AbstractExpression expression2;
    /**当然也可以是表达式N....*/

    @Override
    public boolean interpret(String sentence) {
        /**这里解释规则基于不同的场景可以定义不同的实现方式：比如这里的是并集，当然也可以是或或者其他*/
        return expression1.interpret(sentence) && expression2.interpret(sentence);
    }
}
