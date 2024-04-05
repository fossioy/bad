/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.global_data_ref.client;

import java.util.Arrays;

import com.huawei.global_data_ref.server.api.ClassManage;

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

        // classNumUpLimit = 0; // 限制了客户端对程序控制条件的直接访问
        classManage.addClassInfo("class2");
        classManage.addStudentsInfo("class2", Arrays.asList("XiaoMing", "XiaoZhang"));
        System.out.println(classManage.getStudentsInfo("class2"));
    }
}
