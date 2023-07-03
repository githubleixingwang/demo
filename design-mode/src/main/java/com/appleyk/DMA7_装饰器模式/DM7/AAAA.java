package com.appleyk.DMA7_装饰器模式.DM7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lxw
 * @date: 2023-06-29  15:02
 */
public class AAAA {

    public static  final Map<String,String> map = new HashMap<>();
    public static String str = "ssss";
    private static AAAA me = new AAAA();

    private AAAA() {
        System.out.println("调用无参构造方法");
        System.out.println(str);
    }

    public static AAAA me() {
        System.out.println("获取实例");
        return me;
    }

}
