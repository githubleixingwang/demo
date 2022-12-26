package com.demo.vue.test.list.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStreamTest {

    /**
     * 流的方式合并集合，计算两个集合的差集
     */
    public void test1(){
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        list2.add("4");
        list2.add("5");
        list2.add("6");
        List<String> collect = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
        System.out.println("list1 "+list1);
        System.out.println("list2 "+list2);
        System.out.println(collect);

        List<String> collect1 = collect.stream().
                filter(s1 -> !list1.contains(s1)).collect(Collectors.toList());

        List<String> collect2 = collect.stream().filter(s1 -> !list2.contains(s1)).collect(Collectors.toList());
        System.out.println("要删除元素 "+collect1);
        System.out.println("要新增元素 "+collect2);

    }
}
