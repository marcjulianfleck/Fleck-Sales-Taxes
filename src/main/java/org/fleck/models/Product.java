package org.fleck.models;

import java.math.BigDecimal;

public final class Product {

    private final String productName;
    private final ProductCategory productCategory;
    private final boolean imported;
    private final BigDecimal netPrice;

    public Product(String productName, boolean imported, Double netPrice) {
        this.productName = productName;
        this.productCategory = ProductCategory.getProductCategory(this.productName);
        this.imported = imported;
        this.netPrice = new BigDecimal(netPrice);
    }

    public String getProductName() {
        // TODO: generate and return name properly
        return productName;
    }

    public Double getGrossPrice() {
        // TODO: calc and Round properly
        return 12.49;
    }

    public Double getAllAppliedTaxes() {
        // TODO: calc and round properly
        return 0.00;
    }

}

