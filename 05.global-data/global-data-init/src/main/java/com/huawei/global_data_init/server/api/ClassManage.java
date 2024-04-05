/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.global_data_init.server.api;

import static com.huawei.global_data_init.server.classinfo.ClassStudentsInfo.classNumUpLimit;
import static com.huawei.global_data_init.server.classinfo.ClassStudentsInfo.classStudentsInfo;

import java.util.ArrayList;
import java.util.List;

import com.huawei.global_data_init.server.classinfo.ClassOtherInfoProcessor;
import com.huawei.global_data_init.server.classinfo.Students;

/***
 * class信息管理类
 * 
 * @since 2021-11-01
 */
public class ClassManage {
    private final ClassOtherInfoProcessor classOtherInfoProcessor = new ClassOtherInfoProcessor();

    /**
     * 添加班级
     * 
     * @param className 班级名称
     */
    public void addClassInfo(String className) {
        if (className == null) {
            throw new IllegalArgumentException("className is null");
        }

        if (classStudentsInfo.containsKey(className)) {
            throw new IllegalArgumentException("class already exist");
        }

        if (classStudentsInfo.size() >= classNumUpLimit) {
            throw new IllegalArgumentException("the number of classes has reached upLimit");
        }

        classStudentsInfo.put(className, new Students(new ArrayList<>()));
        classOtherInfoProcessor.someProcess(className);
    }

    /**
     * 为班级添加学生
     *
     * @param className 班级名称
     * @param studentNames 学生姓名
     */
    public void addStudentsInfo(String className, List<String> studentNames) {
        if (className == null || studentNames == null) {
            throw new IllegalArgumentException("className or studentNames is null");
        }

        if (!classStudentsInfo.containsKey(className)) {
            throw new IllegalArgumentException("class not exist");
        }

        classStudentsInfo.get(className).addStudents(studentNames);
        classOtherInfoProcessor.someProcess(studentNames);
    }

    /**
     * 获取某班级的学生
     * 
     * @param className 班级名称
     * @return 班上的学生
     */
    public List<String> getStudentsInfo(String className) {
        if (className == null) {
            throw new IllegalArgumentException("className is null");
        }

        return classStudentsInfo.containsKey(className)
            ? classStudentsInfo.get(className).getStudentNames()
            : new ArrayList<>();
    }
}
