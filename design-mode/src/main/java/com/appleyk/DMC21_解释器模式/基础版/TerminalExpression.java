package com.appleyk.DMC21_解释器模式.基础版;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *     终端表达式类是抽象表达式的子类，用来实现文法中与终结符相关的操作，
 *     文法中的每一个终结符都有一个具体终结表达式与之相对应。
 *
 *     白话翻译：终结的意思就是必须对XXX规则做出具体的解释，
 *     比如你client传来一句话，终结表达式子类必须对其做出解释，比如
 *     这个句子中是否含有 "解释器" 这个词，如果是就返回true,反之返回false！
 * </p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 19:50 2022/10/16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TerminalExpression extends AbstractExpression{
    /**单词，简单起见，这里就不搞集合或数组了，就一个单词吧*/
    private String word;

    @Override
    public boolean interpret(String sentence) {
        return sentence == null ? false : sentence.contains(word);
    }
}
