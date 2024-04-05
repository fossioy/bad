/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_parameter_list_ref.ticket.consumer;

import com.huawei.long_parameter_list_ref.ticket.constant.Constant;

/**
 * 客户信息
 *
 * @since 2021-10-30
 */
public class Consumer {
    private final String name;

    private final int age;

    private final boolean isChild;

    private final boolean isStudent;

    public Consumer(String name, int age, boolean isChild, boolean isStudent) {
        this.name = name;
        this.age = age;
        this.isChild = isChild;
        this.isStudent = isStudent;
    }

    public int getAge() {
        return age;
    }

    public boolean isChild() {
        return isChild;
    }

    public boolean isStudent() {
        return isStudent;
    }

    /**
     * 获取客户信息
     * 
     * @return 客户信息
     */
    public String getConsumerInfo() {
        return "consumerInfo" + Constant.LINE_SEPARATOR
            + "\tname: " + name + Constant.LINE_SEPARATOR
            + "\tage: " + age + Constant.LINE_SEPARATOR
            + "\tisStudent: " + isStudent + Constant.LINE_SEPARATOR
            + "\tisChild: " + isChild + Constant.LINE_SEPARATOR;
    }
}
