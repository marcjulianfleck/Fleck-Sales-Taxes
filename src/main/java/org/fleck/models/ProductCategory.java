package org.fleck.models;

import java.util.regex.Pattern;

public enum ProductCategory {
    BOOK(false),
    FOOD(false),
    MEDICAL(false),
    ENTERTAINMENT(true),
    BODYCARE(true),
    UNKNOWN(true);

    public final boolean taxable;

    ProductCategory(boolean taxable) {
        this.taxable = taxable;
    }

    public static ProductCategory getProductCategory(String productName) {
        if (Pattern.compile("pills|headache").matcher(productName).find()) {
            return ProductCategory.MEDICAL;
        } else if (Pattern.compile("chocolate").matcher(productName).find()) {
            return ProductCategory.FOOD;
        } else if(Pattern.compile("perfume").matcher(productName).find()) {
            return ProductCategory.BODYCARE;
        } else if(Pattern.compile("book").matcher(productName).find()) {
            return ProductCategory.BOOK;
        } else if(Pattern.compile("CD|music").matcher(productName).find()) {
            return ProductCategory.ENTERTAINMENT;
        } else {
            return ProductCategory.UNKNOWN;
        }

    }
}
