package com.appleyk.DMC21_解释器模式.基础版;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     通常包含各个解释器需要的数据或是公共的功能，
 *     一般用来传递被所有解释器共享的数据，后面的解释器可以从这里获取这些值。
 * </p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 19:50 2022/10/16
 */
@Slf4j
public class Context {
    private String word1 = "解释器";
    private String word2 = "设计模式";
    private AbstractExpression expression;
    public Context() {
        expression = new NoTerminalExpression(
                new TerminalExpression(word1),
                new TerminalExpression(word2));
    }

    /**
     * 外部可定义这两个单词，以满足其他场景句子解析的需要
     */
    public Context(String word1,String word2){
        this();
        this.word1 = word1;
        this.word2 = word2;
    }

    public void operation(String sentence){
        boolean bMatch = expression.interpret(sentence);
        log.info("句子是否和解释器设计模式有关：{}",(bMatch ? "有" : "没有"));
    }
}
