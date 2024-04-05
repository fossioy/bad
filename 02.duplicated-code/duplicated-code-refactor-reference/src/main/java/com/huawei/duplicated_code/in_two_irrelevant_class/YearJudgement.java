/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.duplicated_code.in_two_irrelevant_class;

/**
 * 年份判断（代码片段中语句有可能增删改，功能不变）
 *
 * @since 2021-08-18
 */
class YearJudgement {
    public boolean judgeYear() {
        System.out.println("获得当前时间戳");
        String date = DateFormatter.getDate();
        return date.startsWith("2021");
    }
}
