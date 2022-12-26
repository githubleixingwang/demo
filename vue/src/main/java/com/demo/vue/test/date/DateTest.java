package com.demo.vue.test.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTest {

    /*
    * jdk8时间处理方式
    * LocalDateTime、LocalDate、LocalTime
    * */
    public void dateTest(){
        //jdk8获取时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime: "+ now);
        System.out.println("LocalDate: "+ LocalDate.now());
        System.out.println("LocalTime: "+ LocalTime.now());
        System.out.println("now.getYear(): "+now.getYear());
        System.out.println("now.getMonthValue(): "+now.getMonthValue());
        System.out.println("now.getDayOfYear(): "+now.getDayOfYear());
        System.out.println("now.getDayOfMonth(): "+now.getDayOfMonth());
        System.out.println("now.getDayOfWeek(): "+now.getDayOfWeek());
        System.out.println("now.getHour(): "+now.getHour());
        System.out.println("now.getMinute(): "+now.getMinute());
        System.out.println("now.getSecond(): "+now.getSecond());

        System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());

        System.out.println(LocalDateTime.now().withDayOfMonth(1));
        System.out.println(now.isAfter(LocalDateTime.now().withDayOfMonth(1)));


        LocalDate today = LocalDate.now();
        LocalDate firstDay1 = LocalDate.of(today.getYear(), today.getMonthValue(), 1);
        System.out.println(firstDay1);
        LocalDate firstDay2 = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDay2);
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);
        System.out.println(firstDay1.compareTo(lastDay));
        System.out.println(lastDay.compareTo(firstDay1));
        System.out.println(firstDay1.isBefore(lastDay));
        System.out.println(firstDay1.isAfter(lastDay));
        LocalDateTime yesterdayNow = LocalDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth() - 1, now.getHour(), now.getMinute(), now.getSecond());
        System.out.println(yesterdayNow);
        System.out.println(now.plusDays(1));
        System.out.println(now.minusDays(1));

        Integer f1 =100,f2=100,f3=300,f4=300;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }
}
