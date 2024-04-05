package com.huawei.mutable_data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class InvoiceLineTest {
    @Test
    void should_amount_equals_production_of_quantity_and_price() {
        InvoiceLine line = new InvoiceLine("Product");
        line.setQuantity(BigDecimal.valueOf(10));
        line.setPrice(BigDecimal.valueOf(20));

        assertEquals(BigDecimal.valueOf(200), line.amount);
    }

    @Test
    void should_tax_amount_equals_production_of_amount_and_tax_rate() {
        InvoiceLine line = new InvoiceLine("Product");
        line.setQuantity(BigDecimal.valueOf(10));
        line.setPrice(BigDecimal.valueOf(20));
        line.setTaxRate(BigDecimal.valueOf(3, 2));

        assertEquals(new BigDecimal("6.00"), line.taxAmount);
    }

    @Test()
    void should_raise_exception_when_tax_rate_lt_zero() {
        assertThrows(IllegalArgumentException.class, () -> {
            InvoiceLine line = new InvoiceLine("Product");
            line.setQuantity(BigDecimal.valueOf(10));
            line.setPrice(BigDecimal.valueOf(20));
            line.setTaxRate(new BigDecimal("-0.03"));
        });
    }
}