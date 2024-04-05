/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_parameter_list_ref.ticket;

import static com.huawei.long_parameter_list_ref.ticket.constant.Constant.LINE_SEPARATOR;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.huawei.long_parameter_list_ref.ticket.age.AgeLimit;
import com.huawei.long_parameter_list_ref.ticket.consumer.Consumer;
import com.huawei.long_parameter_list_ref.ticket.play.Performance;
import com.huawei.long_parameter_list_ref.ticket.play.PlayType;

/**
 * TicketInfo测试类
 *
 * @since 2021-10-28
 */
class TicketInfoTest {
    @Test
    void testGetTicketInfoOfStudent() {
        AgeLimit ageLimit = new AgeLimit(3, 90);
        Performance performance = new Performance("panda", PlayType.COMEDY, "2022-07-19", 50);
        TicketInfo ticket = new TicketInfo(1);

        String ticketInfo = ticket.getTicketInfo(new Consumer("Amy", 19, false, true),
            performance, ageLimit);

        String expect = "playInfo" + LINE_SEPARATOR
            + "\tplayName: panda" + LINE_SEPARATOR
            + "\tplayType: COMEDY" + LINE_SEPARATOR
            + "\tdate: 2022-07-19" + LINE_SEPARATOR
            + "consumerInfo" + LINE_SEPARATOR
            + "\tname: Amy" + LINE_SEPARATOR
            + "\tage: 19" + LINE_SEPARATOR
            + "\tisStudent: true" + LINE_SEPARATOR
            + "\tisChild: false" + LINE_SEPARATOR
            + "priceInfo" + LINE_SEPARATOR
            + "\tprice: 45.0" + LINE_SEPARATOR
            + "\tdiscount: 0.9" + LINE_SEPARATOR;
        Assertions.assertEquals(expect, ticketInfo);
    }

    @Test
    void testGetTicketInfoOfChild() {
        AgeLimit ageLimit = new AgeLimit(8, 60);
        Performance performance = new Performance("farewell", PlayType.COMEDY, "2022-1-1", 60);
        TicketInfo ticket = new TicketInfo(0.9);

        String ticketInfo = ticket.getTicketInfo(new Consumer("Jack", 10, true, false),
            performance, ageLimit);

        String expect = "playInfo" + LINE_SEPARATOR
            + "\tplayName: farewell" + LINE_SEPARATOR
            + "\tplayType: COMEDY" + LINE_SEPARATOR
            + "\tdate: 2022-1-1" + LINE_SEPARATOR
            + "consumerInfo" + LINE_SEPARATOR
            + "\tname: Jack" + LINE_SEPARATOR
            + "\tage: 10" + LINE_SEPARATOR
            + "\tisStudent: false" + LINE_SEPARATOR
            + "\tisChild: true" + LINE_SEPARATOR
            + "priceInfo" + LINE_SEPARATOR
            + "\tprice: 30.0" + LINE_SEPARATOR
            + "\tdiscount: 0.5" + LINE_SEPARATOR;
        Assertions.assertEquals(expect, ticketInfo);
    }

    @Test
    void testGetTicketInfoOfNormal() {
        AgeLimit ageLimit = new AgeLimit(8, 60);
        Performance performance = new Performance("farewell", PlayType.TRAGEDY, "2021-11-19", 30);
        TicketInfo ticket = new TicketInfo(0.9);

        String ticketInfo = ticket.getTicketInfo(new Consumer("Louis", 30, false, false),
            performance, ageLimit);

        String expect = "playInfo" + LINE_SEPARATOR
            + "\tplayName: farewell" + LINE_SEPARATOR
            + "\tplayType: TRAGEDY" + LINE_SEPARATOR
            + "\tdate: 2021-11-19" + LINE_SEPARATOR
            + "consumerInfo" + LINE_SEPARATOR
            + "\tname: Louis" + LINE_SEPARATOR
            + "\tage: 30" + LINE_SEPARATOR
            + "\tisStudent: false" + LINE_SEPARATOR
            + "\tisChild: false" + LINE_SEPARATOR
            + "priceInfo" + LINE_SEPARATOR
            + "\tprice: 27.0" + LINE_SEPARATOR
            + "\tdiscount: 0.9" + LINE_SEPARATOR;
        Assertions.assertEquals(expect, ticketInfo);
    }
}