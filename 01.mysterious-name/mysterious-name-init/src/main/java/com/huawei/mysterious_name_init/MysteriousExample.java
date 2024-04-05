/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.mysterious_name_init;

public class MysteriousExample {
    public int amont(Perf perf, Type type) {
        switch (type) {
            case TYPE1:
                return resfortype1(perf);
            case TYPE2:
                return resfortype2(perf);
            default:
                throw new IllegalArgumentException("Illegal type : " + type);
        }
    }

    private int resfortype1(Perf perf) {
        int s = 40000;
        if (perf.getAud() > 30) {
            s += 1000 * (perf.getAud() - 30);
        }
        return s;
    }

    private int resfortype2(Perf perf) {
        int s = 30000;
        if (perf.getAud() > 20) {
            s += 1000 + 500 * (perf.getAud() - 20);
        }
        return s;
    }
}
