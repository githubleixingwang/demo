package com.demo.vue.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 反射相关
 */
public class Test {
    private String a;

    public Test() {
    }

    public Test(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void BB(String a) {
        System.out.println(a);
    }


    public static void main(String[] args) {
        Test test = new Test();
        Class<? extends Test> class1 = test.getClass();

        Class<Test> class2 = Test.class;

        Class<?> class3 = null;
        try {
            class3 = Class.forName("com.demo.vue.test.reflect.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Method getA = class3.getMethod("BB", String.class);
            getA.invoke(class3.newInstance(), "invoke");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(class1);
        System.out.println(class2);
        System.out.println(class3);

        try {
            Test test1 = class1.newInstance();

            System.out.println(test1.getA());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Constructor<? extends Test> constructor = class1.getConstructor(String.class);
            Test test2 = constructor.newInstance("aaa");

            System.out.println(test2.getA());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
