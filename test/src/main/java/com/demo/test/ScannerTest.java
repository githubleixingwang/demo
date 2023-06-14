package com.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.test.easypoi.service.A;
import com.google.common.collect.Maps;

import java.util.Map;

public class ScannerTest {
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        StringBuilder stringBuilder = new StringBuilder(next);
        System.out.println("输入信息反向输出：" + stringBuilder.reverse());
        */
        String str = "{\"s\":1}";
        JSONObject jsonObject = JSON.parseObject(str);
        if (jsonObject.isEmpty()) {
            System.out.println("空");
        }else {
            System.out.println("非空");
        }
        System.out.println(String.class);
        System.out.println(str.getClass());
        Map<Object, Object> map = Maps.newHashMap();
        System.out.println(Map.class);
        System.out.println(map.getClass());

        System.out.println(str instanceof Object ? "String属于Object":"String不属于Object");
        System.out.println(String.class instanceof Object ? "String属于Object":"String不属于Object");
        System.out.println(map instanceof Object ? "Map属于Object":"Map不属于Object");
        System.out.println(Map.class instanceof Object ? "Map属于Object":"Map不属于Object");

        A a = new A();
        System.out.println(a instanceof Map);
        System.out.println(map instanceof Map);

    }
}
