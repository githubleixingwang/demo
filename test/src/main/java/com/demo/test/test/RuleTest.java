package com.demo.test.test;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author: lxw
 * @date: 2022-12-30  15:24
 */
public class RuleTest {

    public static Integer test(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String ss = String.valueOf(s.charAt(i));
            list.add(ss);
        }
        List<Integer> list1 = list.stream().filter(e1 -> e1.matches("^[0-9]*$")).map(e2 -> Integer.valueOf(e2)).collect(Collectors.toList());
        List<String> list2 = list.stream().filter(e1 -> !e1.matches("^[0-9]*$")).collect(Collectors.toList());
        int result = 0;
        for (int i = 0; i < list2.size(); i++) {
            if (i == 0) {
                result = list1.get(i) + list1.get(i + 1);
            } else {
                result = result + list1.get(i + 1);
            }

            if ("+".equals(list2.get(i))) {
                if (result == 2) {
                    result = 1;
                } else {
                    result = 0;
                }
            } else {
                if (result > 0) {
                    result = 1;
                } else {
                    result = 0;
                }
            }
        }
        return result;
    }

    public static Integer test1(String s,int result) {
       // int result = 0;
        //包含括号
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String ss = String.valueOf(s.charAt(i));
            list.add(ss);
        }
        Stack<Integer> leftStack = new Stack<>();
        List<Integer> rightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ("(".equals(list.get(i))) {
                leftStack.push(i);
            } else if (")".equals(list.get(i))) {
                rightList.add(i);
            }
            if (leftStack.size() != 0 && rightList.size() != 0 && leftStack.size() == rightList.size()) {
                break;
            }
        }

        if (leftStack.size() != 0 && rightList.size() != 0 && leftStack.size() == rightList.size()) {
            Integer left = leftStack.pop();
            Integer right = rightList.get(0);
            //rightList.remove(0);
            String substring = s.substring(left + 1, right);
            String zhi = String.valueOf(test(substring));
            String replaceStr = replaceStr(s, zhi, left, right);
            if (replaceStr.contains("(")) {
                Integer integer = test1(replaceStr, Integer.valueOf(zhi));
                return integer;

            }else {
                result = test(replaceStr);
                return result;
            }
        }else {
            return result;
        }


    }

    public static String replaceStr(String str, String zhi, int a, int b) {

        StringBuffer buffer = new StringBuffer(str);
        buffer.replace(a, b + 1, zhi);
        return buffer.toString();

    }

    public static void main(String[] args) throws IOException {

        int result=0;
        String a = "1||(((1&&0)&&1)&&0)&&1&&(1||0)&&(1||0)&&(1&&(1||0)&&0)";
        //String a ="0&&1||0&&1||0&&1";
        //String a = "1&&0&&1&&1||0||1&&1||0&&0";
        String s = a.replace("&&", "+").replace("||", "-");

        if (s.contains("(") || s.contains(")")) {
            result = test1(s,result);
        } else {
            result = test(s);
        }
        System.out.println(result);






    }

}
