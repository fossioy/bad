/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.global_data_ref.server.api;

import java.util.List;

import com.huawei.global_data_ref.server.classinfo.ClassOtherInfoProcessor;
import com.huawei.global_data_ref.server.classinfo.ClassStudentsInfoProcessor;

/***
 * class信息管理类
 * 
 * @since 2021-11-01
 */
public class ClassManage {
    private final ClassOtherInfoProcessor classOtherInfoProcessor = new ClassOtherInfoProcessor();

    private final ClassStudentsInfoProcessor classStudentsInfoProcessor = new ClassStudentsInfoProcessor();

    /**
     * 添加班级
     *
     * @param className 班级名称
     */
    public void addClassInfo(String className) {
        if (className == null) {
            throw new IllegalArgumentException("className is null");
        }
        classStudentsInfoProcessor.addOneClass(className);
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
        classStudentsInfoProcessor.addStudents(className, studentNames);
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
        return classStudentsInfoProcessor.getStudents(className);
    }
}
