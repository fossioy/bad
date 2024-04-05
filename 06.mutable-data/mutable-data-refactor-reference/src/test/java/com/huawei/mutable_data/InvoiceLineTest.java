package com.huawei.mutable_data;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceLineTest {
    @Test
    void should_amount_equals_production_of_quantity_and_price() {
        InvoiceLine line = new InvoiceLineBuilder().setProduct("Product")
                .setQuantity(BigDecimal.valueOf(10))
                .setPrice(BigDecimal.valueOf(20))
                .setTaxRate(BigDecimal.ZERO)
                .createInvoiceLine();

        assertEquals(BigDecimal.valueOf(200), line.getAmount());
    }

    @Test
    void should_tax_amount_equals_production_of_amount_and_tax_rate() {
        InvoiceLine line = new InvoiceLineBuilder().setProduct("Product")
                .setQuantity(BigDecimal.valueOf(10))
                .setPrice(BigDecimal.valueOf(20))
                .setTaxRate(BigDecimal.valueOf(3, 2))
                .createInvoiceLine();

        assertEquals(new BigDecimal("6.00"), line.getTaxAmount());
    }

    @Test()
    void should_raise_exception_when_tax_rate_lt_zero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new InvoiceLineBuilder().setProduct("Product")
                    .setQuantity(BigDecimal.valueOf(10))
                    .setPrice(BigDecimal.valueOf(20))
                    .setTaxRate(new BigDecimal("-0.03"))
                    .createInvoiceLine();
        });
    }
}