package com.appleyk.DMC21_解释器模式.增强版.测试;

import com.appleyk.DMC21_解释器模式.增强版.Context;
import lombok.extern.slf4j.Slf4j;


/**
 * <p>解释器高级版测试</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/16:22:19
 */
@Slf4j
public class InterpreterPlusTest {
    public static void main(String[] args) {
        Context context = new Context();
        String input1 = "1-a-&";
        String input2 = "d/%/5";
        String input3 = "c/#/8";
        String input4 = "d/#/8";
        show(context.operation(input1));
        show(context.operation(input2));
        show(context.operation(input3));
        show(context.operation(input4));
    }
    static void show(boolean bMatch){
        System.out.println("是否满足第一个字符含有大小写英文字母（aA-cC），" +
                "第二个字符含有特殊符号，" +
                "第三个字符在[1-10]区间且是偶数："+(bMatch ? "是" : "否"));
        System.out.println(" ======================== ====================");
    }
}
