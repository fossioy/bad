package com.huawei.mutable_data;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {
    @Test
    void should_amount_equals_sum_of_lines() {
        final ArrayList<InvoiceLine> lines = new ArrayList<>();
        lines.add(new InvoiceLineBuilder().setProduct("Product1")
                .setQuantity(BigDecimal.ONE)
                .setPrice(BigDecimal.valueOf(100))
                .setTaxRate(BigDecimal.valueOf(3, 2))
                .createInvoiceLine());
        lines.add(new InvoiceLineBuilder().setProduct("Product2")
                .setQuantity(BigDecimal.ONE)
                .setPrice(BigDecimal.valueOf(200))
                .setTaxRate(BigDecimal.valueOf(5, 2))
                .createInvoiceLine());
        Invoice invoice = new Invoice("Buyer", "Seller", lines);
        assertEquals(BigDecimal.valueOf(300), invoice.getAmount());
    }

    @Test
    void should_tax_amount_equals_sum_of_lines() {
        final ArrayList<InvoiceLine> lines = new ArrayList<>();
        lines.add( new InvoiceLineBuilder().setProduct("Product1")
                .setQuantity(BigDecimal.ONE)
                .setPrice(BigDecimal.valueOf(100))
                .setTaxRate(BigDecimal.valueOf(3, 2))
                .createInvoiceLine());
        lines.add(new InvoiceLineBuilder().setProduct("Product2")
                .setQuantity(BigDecimal.ONE)
                .setPrice(BigDecimal.valueOf(200))
                .setTaxRate(BigDecimal.valueOf(5, 2))
                .createInvoiceLine());
        Invoice invoice = new Invoice("Buyer", "Seller", lines);
        assertEquals(new BigDecimal("13.00"), invoice.getTaxAmount());
    }

    @Test
    void should_total_equals_sum_of_lines() {
        final ArrayList<InvoiceLine> lines = new ArrayList<>();
        lines.add(new InvoiceLineBuilder().setProduct("Product1")
                .setQuantity(BigDecimal.ONE)
                .setPrice(BigDecimal.valueOf(100))
                .setTaxRate(BigDecimal.valueOf(3, 2))
                .createInvoiceLine());
        lines.add(new InvoiceLineBuilder().setProduct("Product2")
                .setQuantity(BigDecimal.ONE)
                .setPrice(BigDecimal.valueOf(200))
                .setTaxRate(BigDecimal.valueOf(5, 2))
                .createInvoiceLine());
        Invoice invoice = new Invoice("Buyer", "Seller", lines);
        assertEquals(new BigDecimal("313.00"), invoice.getTotal());
    }

    @Test
    void should_adding_line_fail_when_using_get_lines() {
        final ArrayList<InvoiceLine> lines = new ArrayList<>();
        Invoice invoice = new Invoice("Buyer", "Seller", lines);
        InvoiceLine line1 = new InvoiceLineBuilder().setProduct("Product1")
                .setQuantity(BigDecimal.ONE)
                .setPrice(BigDecimal.valueOf(100))
                .setTaxRate(BigDecimal.valueOf(3, 2))
                .createInvoiceLine();
        assertThrows(UnsupportedOperationException.class, () -> invoice.getLines().add(line1));
    }
}