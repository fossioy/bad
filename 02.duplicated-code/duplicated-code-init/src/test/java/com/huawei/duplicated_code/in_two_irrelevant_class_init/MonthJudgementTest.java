/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.duplicated_code.in_two_irrelevant_class_init;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 月份判断测试
 *
 * @since 2021-08-18
 */
class MonthJudgementTest {
    @Test
    public void judge_current_month_is_12() {
        MonthJudgement monthJudgement = new MonthJudgement();

        boolean result = monthJudgement.judgeMonth();

        if (Calendar.getInstance().get(Calendar.MONTH) == Calendar.DECEMBER) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }
}