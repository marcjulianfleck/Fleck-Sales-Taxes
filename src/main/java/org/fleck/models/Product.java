package org.fleck.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Product {

    public static final String IMPORTED_PREFIX = "imported ";
    public static final BigDecimal BASIC_SALES_TAX_RATE = new BigDecimal(10);
    public static final BigDecimal IMPORTED_SALES_TAX_RATE = new BigDecimal(5);

    private final String productName;
    private final ProductCategory productCategory;
    private final boolean imported;
    private final BigDecimal netPrice;

    public Product(String productName, boolean imported, Double netPrice) {
        this.productName = productName;
        this.productCategory = ProductCategory.getProductCategory(this.productName);
        this.imported = imported;
        this.netPrice = new BigDecimal(netPrice).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     *This method returns the product name of the product with the prefix "imported" if applicable.
     *
     * @return the product name with the prefix "imported" if applicable as a String.
     */
    public String getProductName() {
        return imported ? IMPORTED_PREFIX + productName : productName;
    }

    /**
     *This method returns the gross price of the product correctly rounded.
     *
     * @return the gross price of the product correctly rounded as a Double.
     */
    public Double getGrossPrice() {
        return  netPrice.add(calcBasicSalesTaxes().add(calcImportedSalesTaxes())).doubleValue();
    }

    /**
     *This method returns just the applied taxes of the product correctly rounded.
     *
     * @return the applied taxes of the product correctly rounded as a Double.
     */
    public Double getAllAppliedTaxes() {
        return  calcBasicSalesTaxes().add(calcImportedSalesTaxes()).doubleValue();
    }

    private BigDecimal calcBasicSalesTaxes() {
        BigDecimal basicSalesTaxes = productCategory.taxable
                ? netPrice.multiply(BASIC_SALES_TAX_RATE).divide(new BigDecimal(100))
                : BigDecimal.ZERO;

        return roundToNearest5ct(basicSalesTaxes.setScale(2, RoundingMode.HALF_UP));
    }

    private BigDecimal calcImportedSalesTaxes() {
        BigDecimal importedSalesTaxes = imported
                ? netPrice.multiply(IMPORTED_SALES_TAX_RATE).divide(new BigDecimal(100))
                : BigDecimal.ZERO;

        return roundToNearest5ct(importedSalesTaxes.setScale(2, RoundingMode.HALF_UP));
    }

    private BigDecimal roundToNearest5ct(BigDecimal value) {
        Double nearest5ct = Math.ceil((value.doubleValue() * 20.0)) / 20.0;
        return new BigDecimal(nearest5ct).setScale(2, RoundingMode.HALF_UP);
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

