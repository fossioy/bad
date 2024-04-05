/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.duplicated_code.in_two_irrelevant_class;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换
 *
 * @since 2021-08-18
 */
public class DateFormatter {
    public static String getDate() {
        Long timeStamp = System.currentTimeMillis();  // 获取当前时间戳
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
    }
}
