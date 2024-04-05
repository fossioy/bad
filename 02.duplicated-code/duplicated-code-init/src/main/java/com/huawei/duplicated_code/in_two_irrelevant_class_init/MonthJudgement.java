/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.duplicated_code.in_two_irrelevant_class_init;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 月份判断（代码片段中语句有可能增删改，功能不变）
 *
 * @since 2021-08-18
 */
class MonthJudgement {
    public boolean judgeMonth() {
        Long timeStamp = System.currentTimeMillis();  // 获取当前时间戳
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        String month = date.split(" ")[0].split("-")[1];
        return "12".equals(month);
    }
}
