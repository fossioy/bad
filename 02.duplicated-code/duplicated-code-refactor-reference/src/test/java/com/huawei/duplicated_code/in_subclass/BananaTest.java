/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.duplicated_code.in_subclass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 香蕉利润测试
 *
 * @since 2021-08-18
 */
class BananaTest {
    @Test
    public void compute_total_money_when_fruit_is_banana_and_numbers_less_then_minSaleableNum(){
        Banana banana = new Banana(2, 4, 2);
        Double profit = banana.profitMoney(1);
        assertEquals(-2.0, profit);
    }

    @Test
    public void compute_total_money_when_fruit_is_banana_and_numbers_more_then_minSaleableNum(){
        Banana banana = new Banana(2, 4, 2);
        Double profit = banana.profitMoney(8);
        assertEquals(8.0, profit);
    }
}