/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.global_data_init.server.classinfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 学生信息
 *
 * @since 2021-11-01
 */
public class Students {
    private final List<String> studentNames;

    public Students(List<String> studentNames) {
        if (studentNames == null) {
            throw new IllegalArgumentException("className or studentNames is null");
        }
        this.studentNames = new ArrayList<>(studentNames);
    }

    /**
     * 批量添加学生信息
     * 
     * @param studentNames 学生姓名
     */
    public void addStudents(List<String> studentNames) {
        if (studentNames == null) {
            throw new IllegalArgumentException("students is null");
        }
        this.studentNames.addAll(studentNames);
    }

    /**
     * 添加一位学生
     * 
     * @param studentName 学生姓名
     */
    public void addOneStudent(String studentName) {
        studentNames.add(studentName);
    }

    /**
     * 获取学生姓名
     * 
     * @return 学生姓名
     */
    public List<String> getStudentNames() {
        return Collections.unmodifiableList(studentNames);
    }
}
