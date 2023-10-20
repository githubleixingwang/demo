package com.demo.test.abstractset;

/**
 * @author: lxw
 * @date: 2023-10-12  14:46
 */
public class Zi extends Fu{
    @Override
    protected void get() {
        System.out.println(timeOut);
    }

    @Override
    protected void set() {
        timeOut = 10000000;
    }

    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.get();
        zi.set();
        zi.get();
    }
}
