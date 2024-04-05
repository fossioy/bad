/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.duplicated_code.in_subclass_init;

/**
 * 香蕉利润（两个互为兄弟的子类含有相同的表达式）
 *
 * @since 2021-08-18
 */
class Banana extends Fruits {
    public Banana(double costPrices, double prices, double minSaleableNum) {
        this.costPrices = costPrices;
        this.minSaleableNum = minSaleableNum;
        this.prices = prices;
    }

    public double profitMoney(int number) {
        return Math.max(0, number - minSaleableNum) * this.prices - this.costPrices * number;
    }
}