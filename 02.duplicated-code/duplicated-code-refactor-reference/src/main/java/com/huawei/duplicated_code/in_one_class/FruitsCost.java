/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.duplicated_code.in_one_class;

/**
 * 计算水果总价（同一个类的两个函数含有相同的表达式）
 *
 * @since 2021-08-18
 */
public class FruitsCost {
    public double computeMoneyWithoutPrivileges(String type, int numbers){
        return getPrices(type) * numbers;
    }

    public double computeMoneyWithPrivileges(String type, double numbers, double discount){
        return getPrices(type) * numbers * discount;
    }

    private double getPrices(String type) {
        double prices;
        switch (type) {
            case "apple":
                prices = 5.5;
                break;
            case "banana":
                prices = 4.0;
                break;
            case "strawberry":
                prices = 10.5;
                break;
            default:
                throw new IllegalArgumentException("Illegal type : " + type);
        }
        return prices;
    }
}