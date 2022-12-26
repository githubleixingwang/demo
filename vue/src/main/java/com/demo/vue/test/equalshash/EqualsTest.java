package com.demo.vue.test.equalshash;


public class EqualsTest {
    public static void main(String[] args) {
        Student student1 = new Student("a",1);
        Student student2 = new Student("a",1);
        System.out.println(student1.equals(student2));
    }
}

