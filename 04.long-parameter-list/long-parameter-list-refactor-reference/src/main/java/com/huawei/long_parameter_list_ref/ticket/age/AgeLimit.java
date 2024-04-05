/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_parameter_list_ref.ticket.age;

/**
 * 功能描述 买票的年龄限制
 *
 * @since 2021-10-18
 */
public class AgeLimit {
    // 年龄下限
    private final int ageFloor;

    // 年龄上限
    private final int ageCeiling;

    public AgeLimit(int ageFloor, int ageCeiling) {
        this.ageFloor = ageFloor;
        this.ageCeiling = ageCeiling;
    }

    /**
     * 年龄是否达标检查
     * 
     * @param age 年龄
     */
    public void checkAge(int age) {
        if ((age < ageFloor || age > ageCeiling)) {
            throw new IllegalArgumentException("age is out of valid range, cannot buy ticket!");
        }
    }
}
