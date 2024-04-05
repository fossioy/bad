package com.huawei.mutable_data;

import java.math.BigDecimal;

public class InvoiceLine {
    private final String product;
    private final BigDecimal quantity;
    private final BigDecimal price;
    private final BigDecimal taxRate;

    public InvoiceLine(String product, BigDecimal quantity,
            BigDecimal price, BigDecimal taxRate) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        if (taxRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Tax rate should >= 0");
        }
        this.taxRate = taxRate;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public BigDecimal getAmount() {
        return this.getQuantity().multiply(getPrice());
    }

    public BigDecimal getTaxAmount() {
        return this.getAmount().multiply(getTaxRate());
    }
}
