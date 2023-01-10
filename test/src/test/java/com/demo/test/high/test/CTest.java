package com.demo.test.high.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Stack;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CTest {


    @Test
    public void test2() {
        String str = "ABC123ABC";

        char[] charArray = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder newStr = new StringBuilder();

        for (char item : charArray) {
            stack.push(item);
        }

        for (int i = 0; i < charArray.length; i++) {
            newStr.append(stack.pop());
        }

        System.out.println("反转前：" + str);
        System.out.println("反转后：" + newStr.toString());
    }

    @Test
    public void test3() {
        String str = "ABCCDEC";
        String s = "C";
        int length = str.length();
        String str2 = str.replace(s, "");
        int length1 = str2.length();
        System.out.println(str);
        System.out.println(str2);
        StringBuilder stringBuilder = new StringBuilder(str2);
        for (int i = 0; i < length - length1; i++) {
            stringBuilder.insert(0, s);
        }
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.reverse());
    }
}