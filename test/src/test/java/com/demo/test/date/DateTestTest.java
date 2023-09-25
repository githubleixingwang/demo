package com.demo.test.date;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class DateTestTest {

    @Test
    void dateTest() {
        new DateTest().dateTest();
    }

    @Test
    void getTimeListTest() {
        List<String> list = new DateTest().getTimeList(8, DateTest.YY_MM2);
        list.forEach(System.out::println);
    }

    @Test
    void getTimeTest() {
        Map time = new DateTest().getTime("23_09", DateTest.YY_MM2);
        System.out.println(time);

    }

    @Test
    void getTimweTest() {
        List<Long> objects = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            objects.add(0L);
            if(i==5){
                objects.set(5,32L);
            }
        }
        objects.forEach(System.out::println);
    }

    @Test
    void getBetweenDay(){
        System.out.println(new DateTest().betweenDay(1695571200000L, 1695657600000L));
    }
}