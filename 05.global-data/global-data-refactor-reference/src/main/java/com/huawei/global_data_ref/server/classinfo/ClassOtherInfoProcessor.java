/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.global_data_ref.server.classinfo;

import java.util.List;
import java.util.Map;

/**
 * 模拟其他模块对班级相关信息的处理逻辑
 *
 * @since 2021-11-02
 */
public class ClassOtherInfoProcessor {
    private Map<String, String> classStudentInfo;

    /**
     * 表示对班级信息的某些处理，具体略
     *
     * @param className 班级名称
     */
    public void someProcess(String className) {
        // process……
        // classStudentsInfo = new HashMap<>(); // 限制程序其他位置任意更改
        // process……
    }

    /**
     * 表示对学生的某些处理，具体略
     *
     * @param studentNames 学生姓名
     */
    public void someProcess(List<String> studentNames) {
        // process……
        // classStudentsInfo.put("class1", null); // 限制程序其他位置任意更改
        // process……
    }
}
