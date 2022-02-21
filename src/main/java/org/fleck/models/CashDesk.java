package org.fleck.models;

import java.util.Iterator;
import java.util.LinkedList;

final public class CashDesk {

    private static CashDesk INSTANCE;

    public static CashDesk getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CashDesk();
        }

        return INSTANCE;
    }

    private final LinkedList<Product> purchase;

    private CashDesk() {
        purchase = new LinkedList<>();
    }

    public LinkedList<Product> scanNewBasket(String basketPath) {
        //TODO: retrieve and create products from "basketPath" and add them to the current purchase
        Product demoProduct = new Product("book", false, 12.49);
        purchase.add(demoProduct);

        return purchase;
    }

    public void checkoutAndPrintReceiptOfPurchase() {
        //TODO: calculate total and taxes and print the receipt to the console and delete the current purchase
        Double salesTaxes = 0.00;
        Double total = 0.00;

        Iterator basketIt = purchase.iterator();
        while (basketIt.hasNext()) {
            Product nextProduct = (Product) basketIt.next();
            salesTaxes += nextProduct.getAllAppliedTaxes();
            total += nextProduct.getGrossPrice();
            System.out.println("1 " + nextProduct.getProductName() + ": " + nextProduct.getGrossPrice());
        }

        System.out.println("Sales Taxes: " + salesTaxes);
        System.out.println("Total: 29.83" + total);

        purchase.clear();
    }

}
