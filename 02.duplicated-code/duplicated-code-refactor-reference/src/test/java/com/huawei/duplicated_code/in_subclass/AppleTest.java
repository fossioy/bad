/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.duplicated_code.in_subclass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 苹果利润测试
 *
 * @since 2021-08-18
 */
class AppleTest {
    @Test
    public void compute_total_money_when_fruit_is_apple_and_numbers_less_then_minSaleableNum() {
        Apple apple = new Apple(2, 4, 4);
        Double profit = apple.profitMoney(3);
        assertEquals(-6.0, profit);
    }

    @Test
    public void compute_total_money_when_fruit_is_apple_and_numbers_more_then_minSaleableNum() {
        Apple apple = new Apple(2, 4, 4);
        Double profit = apple.profitMoney(12);
        assertEquals(8.0, profit);
    }
}