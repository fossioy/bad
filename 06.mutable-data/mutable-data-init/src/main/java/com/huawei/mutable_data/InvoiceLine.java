package com.huawei.mutable_data;

import java.math.BigDecimal;

public class InvoiceLine {
    public String product;
    public BigDecimal quantity = BigDecimal.ZERO;
    public BigDecimal price = BigDecimal.ZERO;
    public BigDecimal taxRate = BigDecimal.ZERO;

    // 冗余字段，可通过其它字段计算得
    public BigDecimal amount = BigDecimal.ZERO;
    // 冗余字段，可通过其它字段计算得
    public BigDecimal taxAmount = BigDecimal.ZERO;

    public InvoiceLine(String product) {
        this.product = product;
    }

    public InvoiceLine(String product, BigDecimal quantity, BigDecimal price, BigDecimal taxRate) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.taxRate = taxRate;
        this.amount = this.quantity.multiply(price);
        this.taxAmount = this.amount.multiply(taxRate);
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        // sum职责1：计算总额
        BigDecimal sum = this.quantity.multiply(price);
        this.amount = sum;
        // sum职责2：计算税额
        sum = this.amount.multiply(taxRate);
        this.taxAmount = sum;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        this.amount = this.quantity.multiply(price);
        this.taxAmount = this.amount.multiply(taxRate);
    }

    public void setTaxRate(BigDecimal taxRate) {
        if (taxRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Tax rate should >= 0");
        }
        this.taxRate = taxRate;
        this.amount = this.quantity.multiply(price);
        this.taxAmount = this.amount.multiply(taxRate);
    }
}
