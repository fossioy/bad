package com.huawei.mutable_data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class InvoiceTest {
    @Test
    void should_amount_equals_sum_of_lines(){
        InvoiceLine line1 = new InvoiceLine("Product1", BigDecimal.ONE, BigDecimal.valueOf(100), BigDecimal.valueOf(3, 2));
        InvoiceLine line2 = new InvoiceLine("Product2", BigDecimal.ONE, BigDecimal.valueOf(200), BigDecimal.valueOf(5, 2));
        Invoice invoice = new Invoice("Buyer", "Seller");
        invoice.putLine(line1);
        invoice.putLine(line2);
        assertEquals(BigDecimal.valueOf(300), invoice.getAmount());
    }

    @Test
    void should_tax_amount_equals_sum_of_lines(){
        InvoiceLine line1 = new InvoiceLine("Product1", BigDecimal.ONE, BigDecimal.valueOf(100), BigDecimal.valueOf(3, 2));
        InvoiceLine line2 = new InvoiceLine("Product2", BigDecimal.ONE, BigDecimal.valueOf(200), BigDecimal.valueOf(5, 2));
        Invoice invoice = new Invoice("Buyer", "Seller");
        invoice.putLine(line1);
        invoice.putLine(line2);
        assertEquals(new BigDecimal("13.00"), invoice.getTaxAmount());
    }

    @Test
    void should_total_equals_sum_of_lines(){
        InvoiceLine line1 = new InvoiceLine("Product1", BigDecimal.ONE, BigDecimal.valueOf(100), BigDecimal.valueOf(3, 2));
        InvoiceLine line2 = new InvoiceLine("Product2", BigDecimal.ONE, BigDecimal.valueOf(200), BigDecimal.valueOf(5, 2));
        Invoice invoice = new Invoice("Buyer", "Seller");
        invoice.putLine(line1);
        invoice.putLine(line2);
        assertEquals(new BigDecimal("313.00"), invoice.getTotal());
    }
}