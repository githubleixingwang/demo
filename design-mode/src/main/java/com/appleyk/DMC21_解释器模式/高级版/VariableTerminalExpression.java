package com.appleyk.DMC21_解释器模式.高级版;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * <p>变量表达式,通过key找值</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/17:8:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VariableTerminalExpression implements IExpression{

    private String character;

    @Override
    public int interpret(Map<String,Integer> variables) throws Exception{
        if (variables == null){
            throw new NullPointerException("variables == null ！");
        }
        if (!variables.containsKey(character)){
            throw new IllegalArgumentException("variables not contain the key of "+character);
        }
        return variables.get(character);
    }

}
