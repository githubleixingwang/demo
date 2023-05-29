package com.appleyk.DMC21_解释器模式.高级版;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Stack;

/**
 * <p>上下文对象，主要包含数据和提供客户端调用的一个快捷操作方法</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/17:8:39
 */
@Slf4j
public class Context {

    private IExpression finalExp;

    public Context(String expression){
        char[] charArray = expression.toCharArray();
        Stack<IExpression> stack = new Stack<>();
        IExpression left;
        IExpression right;
        char ch;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]){
                case '+':
                    /**取出栈中的表达式，即操作符+号左边的变量表达式*/
                    left = stack.pop();
                    /**取出右边相邻的字符*/
                    ch = charArray[++i];
                    if (nonNumber(ch)){
                        log.error("操作符不允许连续出现，表达式不合法！");
                        throw new RuntimeException();
                    }
                    right = new VariableTerminalExpression(""+ch);
                    stack.push(new PlusExpression(left,right));
                    break;
                case '-':
                    /**取出栈中的表达式，即操作符-号左边的变量表达式*/
                    left = stack.pop();
                    /**取出右边相邻的字符*/
                    ch = charArray[++i];
                    if (nonNumber(ch)){
                        log.error("操作符不允许连续出现，表达式不合法！");
                        throw new RuntimeException();
                    }
                    right = new VariableTerminalExpression(""+ch);
                    /**把新表达式对象放入栈中*/
                    stack.push(new SubExpression(left,right));
                    break;
                default:
                    /**非操作符的一律按变量表达式处理*/
                    stack.push(new VariableTerminalExpression(""+charArray[i]));
                    break;
            }
        }
        this.finalExp = stack.pop();
    }

    public int calculate(Map<String,Integer> variables) throws Exception{
        variables.forEach((k,v)->{
            System.out.println(k+" = "+ v);;
        });
        return this.finalExp.interpret(variables);
    }

    private boolean nonNumber(char ch){
        return '+' == ch || '-' == ch;
    }

}
