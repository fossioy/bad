/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_parameter_list_ref.ticket.play;

import static com.huawei.long_parameter_list_ref.ticket.constant.Constant.LINE_SEPARATOR;

/**
 * 功能描述 表演项目的相关信息
 *
 * @since 2021-10-27
 */
public class Performance {
    private final String playName;

    private final PlayType playType;

    private final String playDate;

    private final double basicPrice;

    public Performance(String playName, PlayType playType, String playDate, double basicPrice) {
        this.playName = playName;
        this.playType = playType;
        this.playDate = playDate;
        this.basicPrice = basicPrice;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    /**
     * 获取演出信息
     * 
     * @return 演出信息
     */
    public String getPerformanceInfo() {
        return "playInfo" + LINE_SEPARATOR
            + "\tplayName: " + playName + LINE_SEPARATOR
            + "\tplayType: " + playType + LINE_SEPARATOR
            + "\tdate: " + playDate + LINE_SEPARATOR;
    }
}
