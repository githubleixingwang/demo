package com.appleyk.DMC21_解释器模式.高级版;

import java.util.Map;

/**
 * <p>加法表达式，计算加法操作符（+）两边的表达式的解释结果</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/17:12:45
 */
public class PlusExpression extends OperatorCharacterNoTerminalExpression{
   public PlusExpression(IExpression left, IExpression right){
       super(left,right);
   }
    @Override
    public int interpret(Map<String,Integer> variables) throws Exception {
        return getLeft().interpret(variables) + getRight().interpret(variables);
    }
}
