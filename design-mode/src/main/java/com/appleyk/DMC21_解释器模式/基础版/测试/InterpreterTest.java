package com.appleyk.DMC21_解释器模式.基础版.测试;

import com.appleyk.DMC21_解释器模式.基础版.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>基础版解释器模式测试</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 19:50 2022/10/16
 */
public class InterpreterTest {
    public static void main(String[] args) throws Exception{
        Context context = new Context();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.print("请输入:");
            String s = br.readLine();
            if ("q".equals(s)){
                break;
            }
            context.operation(s);
        }
    }
}
