package com.huawei.mutable_data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Invoice {
    private final String buyer;

    private final String seller;

    private final List<InvoiceLine> lines;

    public Invoice(String buyer, String seller, List<InvoiceLine> lines) {
        this.buyer = buyer;
        this.seller = seller;
        this.lines = new ArrayList<>(lines);
    }

    public List<InvoiceLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public BigDecimal getAmount() {
        return lines.stream().map(InvoiceLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTaxAmount() {
        return lines.stream().map(InvoiceLine::getTaxAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotal() {
        return getAmount().add(getTaxAmount());
    }
}
