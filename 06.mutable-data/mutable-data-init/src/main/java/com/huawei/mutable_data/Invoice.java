package com.huawei.mutable_data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private final String buyer;

    private final String seller;

    private final List<InvoiceLine> lines;

    public Invoice(String buyer, String seller) {
        this.buyer = buyer;
        this.seller = seller;
        this.lines = new ArrayList<>();
    }

    // 修改了Invoice内部数据
    public void putLine(InvoiceLine line) {
        this.lines.add(line);
    }

    // 此方法返回了集合引用，外部可通过操作这个引用来改变Invoice对象
    public List<InvoiceLine> getLines() {
        return lines;
    }

    public BigDecimal getAmount() {
        return lines.stream().map(line -> line.amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTaxAmount() {
        return lines.stream().map(line -> line.taxAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotal() {
        return getAmount().add(getTaxAmount());
    }
}
