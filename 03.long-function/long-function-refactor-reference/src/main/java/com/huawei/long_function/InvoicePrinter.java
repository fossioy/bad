/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_function;

import java.io.PrintStream;

/**
 * @version 1.0
 * @description
 * @since 2021/9/6
 */
public class InvoicePrinter {
    public static void print(Invoice invoice, PrintStream printStream) {
        printHeader(invoice, printStream);

        printDetail(invoice, printStream);

        printFooter(invoice, printStream);
    }

    private static void printDetail(Invoice invoice, PrintStream printStream) {
        printTableHeader(printStream);
        printInvoiceLines(invoice, printStream);
    }

    private static void printInvoiceLines(Invoice invoice, PrintStream printStream) {
        for (int lineId = 0; lineId < invoice.getLines().size(); ++lineId) {
            final InvoiceLine line = invoice.getLines().get(lineId);
            printInvoiceLine(printStream, lineId, line);
        }
    }

    private static void printInvoiceLine(PrintStream printStream, int lineId, InvoiceLine line) {
        if (line.isValid()) {
            printStream.println(lineId + "\tInvalid");
        } else {
            printStream.println(lineId + "\t" + line.getProduct() + "\t" + line.getPrice()
                    + "\t" + line.getQuantity() + "\t" + line.getAmount());
        }
    }

    private static void printTableHeader(PrintStream printStream) {
        printStream.println("------ Detail ------");
        printStream.println("ln\tProduct\tPrice\tQt\tAmount");
    }

    private static void printFooter(Invoice invoice, PrintStream printStream) {
        printStream.println("------ Total ------");
        printStream.println(invoice.calcAmount());
    }

    private static void printHeader(Invoice invoice, PrintStream printStream) {
        printStream.println("====== INVOICE ======");
        printStream.println("Buyer: " + invoice.getBuyer());
        printStream.println("Seller: " + invoice.getSeller());
    }
}
