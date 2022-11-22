package com.demo.vue.test;

public class Test11 {

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        oper(a, b);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    public static void oper(StringBuffer x, StringBuffer y) {
        x.append(y);
        y =x;
        System.out.println("x: " + x);
        System.out.println("y: " + y);
    }
}
