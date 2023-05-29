package com.appleyk.DMC21_解释器模式.增强版;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>非终端表达式，组合其他表达式来构建一个新的expression</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/16:21:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoTerminalExpression implements IExpression{
    /**特殊字符表达式*/
    private IExpression specificSymbolExp;
    /**英文字母（a A b B....）表达式*/
    private IExpression enLetterExp;
    /**特殊数字（1-10且为偶数的）表达式*/
    private IExpression specificNumberExp;
    /**同时符合上述三个表达式解释规则的才返回true*/
    @Override
    public boolean interpret(String input) {
        if (input == null || "".equals(input.trim())){
            return false;
        }
        String[] split = input.split("/");
        if (split.length != 3){
            return false;
        }
        /**
         * 1、输入表达式必须带/
         * 2、第1个输入必须满足英文字母的规则
         * 3、第2个输入必须满足特殊字符的规则
         * 4、第3个输入必须满足特殊数字的规则
         */
        return enLetterExp.interpret(split[0])
                && specificSymbolExp.interpret(split[1])
                && specificNumberExp.interpret(split[2]);
    }
}
