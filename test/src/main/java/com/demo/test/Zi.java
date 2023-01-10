package com.demo.test;

public class Zi extends Fu {

    public String x;
    public String y;
    public String z;

    public String testZi1() {
        return "子类public方法";
    }

    protected String testZi2() {
        return "子类protected方法";
    }

    private String testZi3() {
        return "子类private方法";
    }

    @Override
    public String abstract1() {
        return "public抽象方法";
    }

    @Override
    protected String abstract2() {
        return "protected抽象方法";
    }
}
