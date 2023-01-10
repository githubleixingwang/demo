package com.demo.test.enum1;


import java.util.HashMap;
import java.util.Map;

public enum TestEnum {
    SYSTEM(0,"aa"),
    CUSTOM(1,"bb");

    private int code;
    private String key;
    private static Map<Integer, TestEnum> map = new HashMap<>();
    private static Map<String, TestEnum> map2 = new HashMap<>();

    TestEnum(int code, String key) {
        this.code = code;
        this.key = key;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public static String getName(Integer code) {
        TestEnum orgSourceEnum = map.get(code);
        return orgSourceEnum.getKey();
    }
    public static Integer getCode(String key ) {
        TestEnum orgSourceEnum = map2.get(key);
        return orgSourceEnum.getCode();
    }

    static {
        for (TestEnum value : values()) {
            map.put(value.getCode(), value);
        }
        for (TestEnum value : values()) {
            map2.put(value.getKey(), value);
        }
    }
}
