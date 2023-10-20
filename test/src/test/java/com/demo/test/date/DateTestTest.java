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
            if (i == 5) {
                objects.set(5, 32L);
            }
        }
        objects.forEach(System.out::println);
    }

    @Test
    void getBetweenDay() {
        System.out.println(new DateTest().betweenDay(1695571200000L, 1695657600000L));
    }

    @Test
    void oooooo() {
        /* TMSSendAddress
       byte[] bytes = new byte[]{48, 40, 49, 98, 87, 12, 0, 36, 6, 85, 64, 7, 23, 22};

        String key = "deb12b";*/
        /*$tms_messageConfig
        byte[] bytes = new byte[]{70, 65, 11, 68, 105, 14, 7, 70, 21, 86, 81, 6, 33, 90, 8, 81, 95, 4};
        String key = "b5f76c";*/
       /* webinf.dir
        byte[] bytes = new byte[]{20, 80, 3, 15, 90, 83, 77, 81, 8, 20};
        String key = "c5af45";*/
        /*/_data/cache
        byte[] bytes = new byte[]{28, 106, 1, 3, 76, 84, 28, 86, 4, 1, 80, 80};
        String key = "35eb85";*/
        //TMSSendAddress is null.
        byte[] bytes = new byte[]{98, 126, 98, 97, 86, 87, 82, 114, 85, 86, 65, 92, 69, 64, 17, 91, 64, 25, 88, 70, 93, 94, 29};
        String key ="631239";
        int len = bytes.length;
        int keyLen = key.length();

        for (int i = 0; i < len; ++i) {
            bytes[i] = (byte) (bytes[i] ^ key.charAt(i % keyLen));
        }
        System.out.println(new String(bytes));
    }
}