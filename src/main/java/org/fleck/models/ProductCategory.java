package org.fleck.models;

public enum ProductCategory {
    BOOK(false),
    FOOD(false),
    MEDICAL(false),
    ENTERTAINMENT(true),
    BODYCARE(true),
    UNKNOWN(true);

    boolean taxable;

    ProductCategory(boolean taxable) {
        this.taxable = taxable;
    }

    public static ProductCategory getProductCategory(String productName) {
        return BOOK;
    }
}
