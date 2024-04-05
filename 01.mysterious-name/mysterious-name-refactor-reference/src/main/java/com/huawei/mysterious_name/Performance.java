/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.mysterious_name;

/**
 * 演出信息
 *
 * @since 2021-05-07
 */
public class Performance {
    private final int audienceNum;

    public Performance(int audienceNum) {
        this.audienceNum = audienceNum;
    }

    int getAudienceNum() {
        return audienceNum;
    }
}
