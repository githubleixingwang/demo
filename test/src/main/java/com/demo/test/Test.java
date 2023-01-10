package com.demo.test;

public class Test {

    public static void main(String[] args) {
        Zi zi = new Zi();
        Fu fu = new Zi();
         /*子类调用父类普通方法*/
        System.out.println(zi.test1());
        System.out.println(zi.test2());

    }
}
