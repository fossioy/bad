/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_function.invoice_printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version 1.0
 * @description
 * @since 2021/9/6
 */
public class Invoice {
    private final String buyer;

    private final String seller;

    private final List<InvoiceLine> lines;

    public Invoice(String buyer, String seller, List<InvoiceLine> lines) {
        this.buyer = buyer;
        this.seller = seller;
        this.lines = new ArrayList<>(lines);
    }

    public String getBuyer() {
        return buyer;
    }

    public String getSeller() {
        return seller;
    }

    public List<InvoiceLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
