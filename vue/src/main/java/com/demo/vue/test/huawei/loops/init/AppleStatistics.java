package com.demo.vue.test.huawei.loops.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统计苹果信息
 *
 * @since 2021-09-02
 */
public class AppleStatistics {
    /**
     * 求每种颜色苹果的平均重量
     *
     * @param appleStore 苹果信息
     * @return 每种颜色苹果的平均重量
     */
    public Map<String, Integer> averageWeightByColor(List<Apple> appleStore) {
        Map<String, Integer> result = new HashMap<>();

        // 按颜色分组.
        Map<String, List<Apple>> applesMap = new HashMap<>();

        for (Apple apple : appleStore) {
            //computeIfAbsent key存在返回旧值，不存在返回新值
            List<Apple> apples = applesMap.computeIfAbsent(apple.getColor(), key -> new ArrayList<>());
            apples.add(apple);
        }

        // 求平均重量
        for (Map.Entry<String, List<Apple>> entry : applesMap.entrySet()) {
            int weights = 0;
            for (Apple apple : entry.getValue()) {
                weights += apple.getWeight();
            }
            // get average
            result.put(entry.getKey(), weights / entry.getValue().size());
        }
        return result;
    }
}
