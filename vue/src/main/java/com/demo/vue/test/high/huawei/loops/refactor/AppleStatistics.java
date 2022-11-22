/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.demo.vue.test.high.huawei.loops.refactor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 统计苹果信息
 *
 * @since 2021-09-02
 */
public class AppleStatistics {
    /**\
     * 求每种颜色苹果的平均重量
     *
     * @param appleStore 苹果信息
     * @return 每种颜色苹果的平均重量
     */
    public Map<String, Integer> averageWeightByColor(List<Apple> appleStore) {
        Map<String, Integer> result = new HashMap<>();

        appleStore.stream()
            .collect(Collectors.groupingBy(Apple::getColor, // 按颜色分组
                Collectors.averagingInt(Apple::getWeight))) // 平均重量
            .forEach((k, v) -> result.put(k, v.intValue())); // 保存结果
        return result;
    }
}
