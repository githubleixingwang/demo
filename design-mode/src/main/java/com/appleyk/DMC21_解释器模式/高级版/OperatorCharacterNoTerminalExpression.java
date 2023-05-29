package com.appleyk.DMC21_解释器模式.高级版;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * <p>具体数值终结符表达式</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/17:13:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperatorCharacterNoTerminalExpression implements IExpression {
    private IExpression left;
    private IExpression right;
    @Override
    public int interpret(Map<String,Integer> variables) throws Exception {
        return 0;
    }
}
