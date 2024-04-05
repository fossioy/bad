package com.huawei.mutable_data;

import java.math.BigDecimal;

public class InvoiceLineBuilder {
    private String product;

    private BigDecimal quantity;

    private BigDecimal price;

    private BigDecimal taxRate;

    public InvoiceLineBuilder setProduct(String product) {
        this.product = product;
        return this;
    }

    public InvoiceLineBuilder setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public InvoiceLineBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public InvoiceLineBuilder setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    public InvoiceLine createInvoiceLine() {
        return new InvoiceLine(product, quantity, price, taxRate);
    }
}