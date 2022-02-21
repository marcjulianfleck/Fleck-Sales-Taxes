package org.fleck.models;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object otherProduct) {
        if (this == otherProduct) return true;
        if (otherProduct == null || getClass() != otherProduct.getClass()) return false;
        Product product = (Product) otherProduct;
        return imported == product.imported
                && Objects.equals(productName, product.productName)
                && productCategory == product.productCategory
                && Objects.equals(netPrice, product.netPrice);
    }

}

