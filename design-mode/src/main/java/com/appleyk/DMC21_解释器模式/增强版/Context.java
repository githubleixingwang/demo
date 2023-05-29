package com.appleyk.DMC21_解释器模式.增强版;

/**
 * <p>上下文对象，主要包含数据和提供客户端调用的一个快捷操作方法</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/16:21:39
 */
public class Context {
    private final String[] specificSymbols = new String[]{"&","%","#","@","?"};
    private final String[] enLetters = new String[]{"a","A","b","B","c","C"};
    private final String[] lessThanTenNumbers = new String[]{"1","2","3","4","5","6","7","8","9","10"};
    IExpression finalExpression;
    public Context(){
        IExpression specificSymbolsExp = new
                CharacterTerminalExpression(specificSymbols);
        IExpression enLettersExp = new
                CharacterTerminalExpression(enLetters);
        IExpression specificNumbersExp = new
                NumberTerminalExpression(lessThanTenNumbers);
        this.finalExpression = new NoTerminalExpression(specificSymbolsExp,
                enLettersExp,specificNumbersExp);
    }

    public boolean operation(String input){
        System.out.println("输入表达式是："+input);
        if (!input.contains("/")){
            System.out.println("输入的表达式必须满足*/*/*/格式，否则无法识别！");
            return false;
        }
        return finalExpression == null ? false : finalExpression.interpret(input);
    }
}
