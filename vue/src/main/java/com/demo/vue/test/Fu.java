package com.demo.vue.test;

public abstract class Fu {
    public String a;
    public String b;
    public String c;

    public String test1(){
        return  "父类public方法";
    }
    protected String test2(){
        return  "父类protected方法";
    }
    private String test3(){
        return  "父类private方法";
    }
    public static String test4(){
        return  "父类static方法";
    }

    public abstract String abstract1();
    protected abstract String abstract2();
}
