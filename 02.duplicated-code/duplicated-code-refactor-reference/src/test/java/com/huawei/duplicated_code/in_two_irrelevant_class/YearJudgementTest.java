/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.duplicated_code.in_two_irrelevant_class;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 年份判断测试
 *
 * @since 2021-08-18
 */
class YearJudgementTest {
    @Test
    public void judge_current_year_is_2021() {
        YearJudgement yearJudgement = new YearJudgement();

        boolean result = yearJudgement.judgeYear();

        if (Calendar.getInstance().get(Calendar.YEAR) == 2021) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }
}