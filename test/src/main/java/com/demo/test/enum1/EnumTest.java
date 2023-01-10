package com.demo.test.enum1;

import java.util.stream.Stream;

/**
 * @author: lxw
 * @date: 2023-01-10  15:43
 */
public class EnumTest {
    public static void main(String[] args) {
        boolean isEnum = Stream.of(TestEnum.values()).anyMatch(v -> v.getKey().equals("aa"));
        System.out.println(isEnum);
        String name = TestEnum.getName(1);
        System.out.println(name);
        Integer aa = TestEnum.getCode("aa");
        System.out.println(aa);
        TestEnum[] values = TestEnum.values();
        System.out.println(values);
    }
}
