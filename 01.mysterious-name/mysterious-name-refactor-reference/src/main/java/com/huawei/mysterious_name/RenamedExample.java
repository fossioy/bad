/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.mysterious_name;

public class RenamedExample {
    public int calculateAmount(Performance performance, PlayType playType) {
        switch (playType) {
            case TRAGEDY:
                return calculateTragedyAmount(performance);
            case COMEDY:
                return calculateComedyAmount(performance);
            default:
                throw new IllegalArgumentException("Illegal type : " + playType);
        }
    }

    private int calculateTragedyAmount(Performance performance) {
        int totalAmount = 40000;
        if (performance.getAudienceNum() > 30) {
            totalAmount += 1000 * (performance.getAudienceNum() - 30);
        }
        return totalAmount;
    }

    private int calculateComedyAmount(Performance performance) {
        int totalAmount = 30000;
        if(performance.getAudienceNum() > 20){
            totalAmount += 1000 + 500 * (performance.getAudienceNum() - 20);
        }
        return totalAmount;
    }
}



