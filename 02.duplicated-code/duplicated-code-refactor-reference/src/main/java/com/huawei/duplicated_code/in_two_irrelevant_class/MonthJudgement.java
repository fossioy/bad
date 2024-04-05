/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.duplicated_code.in_two_irrelevant_class;

/**
 * 月份判断（代码片段中语句有可能增删改，功能不变）
 *
 * @since 2021-08-18
 */
class MonthJudgement {
    public boolean judgeMonth() {
        String date = DateFormatter.getDate();
        String month = date.split(" ")[0].split("-")[1];
        return "12".equals(month);
    }
}
