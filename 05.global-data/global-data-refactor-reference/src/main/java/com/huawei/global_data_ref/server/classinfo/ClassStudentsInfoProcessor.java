/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.global_data_ref.server.classinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 班级学生信息处理
 *
 * @since 2021-11-04
 */
public class ClassStudentsInfoProcessor {
    private static final Map<String, Students> CLASS_STUDENTS_INFO = new HashMap<>();

    private static final int CLASS_NUM_UP_LIMIT = 3;

    /**
     * 添加一个班级
     * 
     * @param className 班级名称
     */
    public void addOneClass(String className) {
        if (CLASS_STUDENTS_INFO.containsKey(className)) {
            throw new IllegalArgumentException("class already exist");
        }
        if (CLASS_STUDENTS_INFO.size() >= CLASS_NUM_UP_LIMIT) {
            throw new IllegalArgumentException("the number of classes has reached upLimit");
        }
        CLASS_STUDENTS_INFO.put(className, new Students(new ArrayList<>()));
    }

    /**
     * 为某班级添加学生
     * 
     * @param className 班级名称
     * @param studentNames 学生姓名
     */
    public void addStudents(String className, List<String> studentNames) {
        if (!CLASS_STUDENTS_INFO.containsKey(className)) {
            throw new IllegalArgumentException("class not exist");
        }
        CLASS_STUDENTS_INFO.get(className).addStudents(studentNames);
    }

    /**
     * 查询某班级的学生
     * 
     * @param className 班级名称
     * @return 学生
     */
    public List<String> getStudents(String className) {
        return CLASS_STUDENTS_INFO.containsKey(className)
            ? CLASS_STUDENTS_INFO.get(className).getStudentNames()
            : new ArrayList<>();
    }
}
