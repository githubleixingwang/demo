package com.demo.test.xmldigester.bean;

/**
 * @author: lxw
 * @date: 2023-10-20  10:20
 */
public class Node {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Node{" +
                "str='" + str + '\'' +
                '}';
    }
}
