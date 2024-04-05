/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_parameter_list_ref.client;

import com.huawei.long_parameter_list_ref.ticket.TicketInfo;
import com.huawei.long_parameter_list_ref.ticket.age.AgeLimit;
import com.huawei.long_parameter_list_ref.ticket.consumer.Consumer;
import com.huawei.long_parameter_list_ref.ticket.play.Performance;
import com.huawei.long_parameter_list_ref.ticket.play.PlayType;

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

        final String ticketInfo = ticket.getTicketInfo(
            new Consumer("Tony", 18, false, true), performance, ageLimit);

        System.out.println(ticketInfo);
    }
}