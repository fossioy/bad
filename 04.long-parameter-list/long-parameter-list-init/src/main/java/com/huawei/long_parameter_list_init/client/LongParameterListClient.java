/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_parameter_list_init.client;

import com.huawei.long_parameter_list_init.ticket.TicketInfo;
import com.huawei.long_parameter_list_init.ticket.age.AgeLimit;
import com.huawei.long_parameter_list_init.ticket.play.Performance;
import com.huawei.long_parameter_list_init.ticket.play.PlayType;

/**
 * 模拟Client端调用
 *
 * @since 2021-10-18
 */
public class LongParameterListClient {
    public static void main(String[] args) {
        AgeLimit ageLimit = new AgeLimit(8, 80);
        Performance performance = new Performance("a star", PlayType.TRAGEDY, "2022-02-05", 50);
        TicketInfo ticket = new TicketInfo(0.9);

        final String ticketInfo = ticket.getTicketInfo("Tony", 18, false, true,
            ageLimit.getAgeFloor(), ageLimit.getAgeCeiling(), performance, performance.getBasicPrice());

        System.out.println(ticketInfo);
    }
}