package com.appleyk.DMC21_解释器模式.高级版.测试;

import com.appleyk.DMC21_解释器模式.高级版.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>高级版解释器模式测试</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/17:8:43
 */
public class InterpreterAdvanceTest {
    public static void main(String[] args) throws Exception{
        String expression = "a-c+b+e";
        Map<String,Integer> vars = new HashMap<>();
        vars.put("a",10);
        vars.put("b",25);
        vars.put("c",20);
        vars.put("e",1);
        Context context = new Context(expression);
        int result = context.calculate(vars);
        System.out.println(expression+" = "+result);
    }
}
