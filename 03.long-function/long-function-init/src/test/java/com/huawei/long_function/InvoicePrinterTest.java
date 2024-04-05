/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_function;

import com.huawei.long_function.invoice_printer.Invoice;
import com.huawei.long_function.invoice_printer.InvoiceLine;
import com.huawei.long_function.invoice_printer.InvoicePrinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

class InvoicePrinterTest {
    private static final String lineSep = System.lineSeparator();

    @Test
    void invoice_should_printed_with_details_and_total () throws IOException {
        Invoice invoice = new Invoice("buyer", "seller",
            Arrays.asList(new InvoiceLine("a", 10, 10),
                new InvoiceLine("b", 2, 20)));
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            InvoicePrinter.print(invoice, new PrintStream(outputStream, true, "UTF-8"));
            String content = outputStream.toString("UTF-8");
            assertEquals(content,"====== INVOICE ======" + lineSep +
                    "Buyer: buyer" + lineSep +
                    "Seller: seller" + lineSep +
                    "------ Detail ------" + lineSep +
                    "ln\tProduct\tPrice\tQt\tAmount" + lineSep +
                    "0\ta\t10.0\t10.0\t100.0" + lineSep +
                    "1\tb\t20.0\t2.0\t40.0" + lineSep +
                    "------ Total ------" + lineSep +
                    "140.0" + lineSep);
        }
    }
}