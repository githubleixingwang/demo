/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.demo.test.huawei.loops.refactor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 苹果信息
 *
 * @since 2021-09-02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apple {
    private int id;

    // 苹果颜色
    private String color;

    // 苹果重量
    private int weight;

    private String origin;


}
