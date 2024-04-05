/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_parameter_list_init.ticket;

import static com.huawei.long_parameter_list_init.ticket.constant.Constant.LINE_SEPARATOR;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.huawei.long_parameter_list_init.ticket.age.AgeLimit;
import com.huawei.long_parameter_list_init.ticket.play.Performance;
import com.huawei.long_parameter_list_init.ticket.play.PlayType;

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

        String ticketInfo = ticket.getTicketInfo("Amy", 19, false, true, ageLimit.getAgeFloor(),
            ageLimit.getAgeCeiling(), performance, performance.getBasicPrice());

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

        String ticketInfo = ticket.getTicketInfo("Jack", 10, true, false, ageLimit.getAgeFloor(),
            ageLimit.getAgeCeiling(), performance, performance.getBasicPrice());

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

        String ticketInfo = ticket.getTicketInfo("Louis", 30, false, false, ageLimit.getAgeFloor(),
            ageLimit.getAgeCeiling(), performance, performance.getBasicPrice());

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