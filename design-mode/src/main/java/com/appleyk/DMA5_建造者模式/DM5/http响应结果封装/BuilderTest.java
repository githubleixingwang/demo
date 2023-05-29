package com.appleyk.DMA5_建造者模式.DM5.http响应结果封装;

import com.appleyk.utils.JsonUtils;

public class BuilderTest {
    public static void main(String[] args) {
        MyResult result = new MyResult.Builder().status(404).data(null).message("data not found").build();
        System.out.println(JsonUtils.objectToJson(result));
    }
}
