package com.appleyk.DMA7_装饰器模式.DM7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lxw
 * @date: 2023-06-30  11:24
 */

public class BBBB {

    public static Map<String, String> map = new HashMap<>();

    public BBBB() {
        System.out.println("BBBB加载了");
    }

    static {
        map.put("BBBB", "BBBB");
        System.out.println(map);
    }
}
