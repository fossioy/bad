/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.global_data_ref.server.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * ClassManage测试类
 *
 * @since 2021-11-18
 */
class ClassManageTest {
    @Test
    public void test_addInfo_when_add_class_and_student() {
        ClassManage classManage = new ClassManage();
        classManage.addClassInfo("class1");
        classManage.addStudentsInfo("class1", Arrays.asList("ZhangSan", "LiSi"));
        List<String> result = classManage.getStudentsInfo("class1");
        List<String> except = Arrays.asList("ZhangSan", "LiSi");
        assertEquals(result, except);
    }

    @Test
    public void test_addInfo_when_add_class_and_student_throw_error() {
        ClassManage classManage = new ClassManage();
        classManage.addClassInfo("class2");
        try {
            classManage.addClassInfo("class2");
        } catch (IllegalArgumentException e) {
            assertEquals("class already exist", e.getMessage());
        }
    }
}