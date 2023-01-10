/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.demo.test.huawei.loops.refactor;

import java.util.ArrayList;
import java.util.List;

/**
 * 苹果信息统计client方调用
 *
 * @since 2021-09-02
 */
public class Client {
    public static void main(String[] args) {
        List<Apple> appleStore = new ArrayList<>();
        appleStore.add(new Apple(1, "red", 500, "河南"));
        appleStore.add(new Apple(2, "red", 400, "河南"));
        appleStore.add(new Apple(3, "green", 300, "河南"));
        appleStore.add(new Apple(4, "green", 200, "天津"));
        appleStore.add(new Apple(5, "green", 100, "天津"));

        AppleStatistics appleStatistics = new AppleStatistics();
        appleStatistics.averageWeightByColor(appleStore).forEach((key, value) -> {
            System.out.print(key + ":");
            System.out.println(value);
        });
    }
}
