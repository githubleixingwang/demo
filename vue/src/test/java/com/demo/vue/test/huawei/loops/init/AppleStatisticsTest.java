package com.demo.vue.test.huawei.loops.init;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AppleStatisticsTest {
    private List<Apple> appleStore;

    @Test
    void should_color_equals_avg() {
        List<Apple> appleStore = new ArrayList<>();
        appleStore.add(new Apple(1, "red", 500, "河南"));
        appleStore.add(new Apple(2, "red", 400, "河南"));
        appleStore.add(new Apple(3, "green", 300, "河南"));
        appleStore.add(new Apple(4, "green", 200, "天津"));
        appleStore.add(new Apple(5, "green", 100, "天津"));

        AppleStatistics appleStatistics = new AppleStatistics();
        Map<String, Integer> result = appleStatistics.averageWeightByColor(appleStore);

        assertEquals(result.get("red"), java.util.Optional.of(450));
        assertEquals(result.get("green"), java.util.Optional.of(200));
    }
}