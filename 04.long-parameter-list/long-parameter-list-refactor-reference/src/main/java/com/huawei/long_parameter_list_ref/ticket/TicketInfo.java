/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_parameter_list_ref.ticket;

import static com.huawei.long_parameter_list_ref.ticket.constant.Constant.LINE_SEPARATOR;

import java.math.BigDecimal;

import com.huawei.long_parameter_list_ref.ticket.age.AgeLimit;
import com.huawei.long_parameter_list_ref.ticket.consumer.Consumer;
import com.huawei.long_parameter_list_ref.ticket.play.Performance;

/**
 * 功能描述 计算某表演项目的票价, 只有符合年龄要求才可以购买, 儿童票5折, 学生可以打9折, 二者取最小
 *
 * @since 2021-10-18
 */
public class TicketInfo {
    private final double baseDiscount;

    public TicketInfo(double baseDiscount) {
        this.baseDiscount = baseDiscount;
    }

    /**
     * 获取票据信息
     * 
     * @param customer 客户信息
     * @param performance 演出信息
     * @param ageLimit 年龄限制
     * @return 票据信息
     */
    public String getTicketInfo(Consumer customer, Performance performance, AgeLimit ageLimit) {
        ageLimit.checkAge(customer.getAge());

        return performance.getPerformanceInfo()
            + customer.getConsumerInfo()
            + getPriceInfo(customer, performance);
    }

    private String getPriceInfo(Consumer customer, Performance performance) {
        final double discount = getDiscount(customer);
        final double ticketPrice = getTicketPrice(discount, performance.getBasicPrice());
        return "priceInfo" + LINE_SEPARATOR
            + "\tprice: " + ticketPrice + LINE_SEPARATOR
            + "\tdiscount: " + discount + LINE_SEPARATOR;
    }

    private double getDiscount(Consumer customer) {
        double childDiscount = calculateChildDiscount(customer);
        double studentDiscount = calculateStudentDiscount(customer);
        return BigDecimal.valueOf(Math.min(childDiscount, studentDiscount))
            .setScale(2, BigDecimal.ROUND_HALF_UP)
            .doubleValue();
    }

    private double calculateChildDiscount(Consumer customer) {
        return customer.isChild() ? 0.5 : baseDiscount;
    }

    private double calculateStudentDiscount(Consumer customer) {
        return customer.isStudent() ? 0.9 * baseDiscount : baseDiscount;
    }

    private double getTicketPrice(double discount, double basicPrice) {
        return BigDecimal.valueOf(discount * basicPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
