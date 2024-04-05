/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_function.invoice_printer;

import java.io.PrintStream;

/**
 * @version 1.0
 * @description
 * @since 2021/9/6
 */
public class InvoicePrinter {
    public static void print(Invoice invoice, PrintStream printStream) {
        printStream.println("====== INVOICE ======");
        printStream.println("Buyer: " + invoice.getBuyer());
        printStream.println("Seller: " + invoice.getSeller());

        printStream.println("------ Detail ------");
        printStream.println("ln\tProduct\tPrice\tQt\tAmount");
        float total = 0;
        for (int lineId = 0; lineId < invoice.getLines().size(); ++lineId) {
            final InvoiceLine line = invoice.getLines().get(lineId);
            String product = line.getProduct();
            float price = line.getPrice();
            float quantity = line.getQuantity();
            float amount = price * quantity;
            if (product == null || "".equals(product.trim())
                    || price <= 0 || quantity <= 0) {
                printStream.println(lineId + "\tInvalid");
            } else {
                printStream.println(lineId + "\t" + product + "\t" + price
                        + "\t" + quantity + "\t" + amount);
            }
            total += amount;
        }
        printStream.println("------ Total ------");
        printStream.println(total);
    }
}
