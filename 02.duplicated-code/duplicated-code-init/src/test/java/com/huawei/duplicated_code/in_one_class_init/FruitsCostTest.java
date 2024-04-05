/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.duplicated_code.in_one_class_init;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 计算水果总价测试
 *
 * @since 2021-08-18
 */
class FruitsCostTest {
    @Test
    public void compute_money_when_type_is_apple_numbers_is_5_without_privileges() {
        FruitsCost fruitsCost = new FruitsCost();
        Double totalMoney = fruitsCost.computeMoneyWithoutPrivileges("apple", 5);
        assertEquals(27.5, totalMoney);
    }

    @Test
    public void compute_money_when_type_is_banana_numbers_is_5_without_privileges() {
        FruitsCost fruitsCost = new FruitsCost();
        Double totalMoney = fruitsCost.computeMoneyWithoutPrivileges("banana", 5);
        assertEquals(20.0, totalMoney);
    }

    @Test
    public void compute_money_when_type_is_strawberry_numbers_is_5_without_privileges() {
        FruitsCost fruitsCost = new FruitsCost();
        Double totalMoney = fruitsCost.computeMoneyWithoutPrivileges("strawberry", 5);
        assertEquals(52.5, totalMoney);
    }

    @Test
    public void compute_money_when_type_is_apple_numbers_is_5_with_privileges() {
        FruitsCost fruitsCost = new FruitsCost();
        Double totalMoney = fruitsCost.computeMoneyWithPrivileges("apple", 5, 0.8);
        assertEquals(22.0, totalMoney);
    }

    @Test
    public void compute_money_when_type_is_banana_numbers_is_5_with_privileges() {
        FruitsCost fruitsCost = new FruitsCost();
        Double totalMoney = fruitsCost.computeMoneyWithPrivileges("banana", 5, 0.8);
        assertEquals(16.0, totalMoney);
    }

    @Test
    public void compute_money_when_type_is_strawberry_numbers_is_5_with_privileges() {
        FruitsCost fruitsCost = new FruitsCost();
        Double totalMoney = fruitsCost.computeMoneyWithPrivileges("strawberry", 5, 0.8);
        assertEquals(42.0, totalMoney);
    }
}