/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.global_data_init.client;

import static com.huawei.global_data_init.server.classinfo.ClassStudentsInfo.classNumUpLimit;

import java.util.Arrays;

import com.huawei.global_data_init.server.api.ClassManage;

/**
 * 模拟Client端调用
 *
 * @since 2021-11-02
 */
public class Client {
    public static void main(String[] args) {
        ClassManage classManage = new ClassManage();

        classManage.addClassInfo("class1");
        classManage.addStudentsInfo("class1", Arrays.asList("ZhangSan", "LiSi"));
        classManage.addStudentsInfo("class1", Arrays.asList("WangWu", "ZhaoLiu"));
        System.out.println(classManage.getStudentsInfo("class1"));

        // classNumUpLimit = 0; // 客户端任意位置都可以随意改变系统行为和功能，
        classManage.addClassInfo("class2");
        classManage.addStudentsInfo("class2", Arrays.asList("XiaoMing", "XiaoZhang"));
        System.out.println(classManage.getStudentsInfo("class2"));
    }
}
