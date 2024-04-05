/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.duplicated_code.in_two_irrelevant_class_init;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 年份判断（代码片段中语句有可能增删改，功能不变）
 *
 * @since 2021-08-18
 */
class YearJudgement {
    public boolean judgeYear() {
        Long time = System.currentTimeMillis();  // 获取当前时间戳
        System.out.println("获得当前时间戳");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date(Long.parseLong(String.valueOf(time))));
        return date.startsWith("2021");
    }
}
