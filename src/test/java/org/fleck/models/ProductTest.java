package org.fleck.models;

import junit.framework.TestCase;

public class ProductTest extends TestCase {

    private final Product testProductBook = new Product("book", false, 9.99);
    private final Product testProductBookImported = new Product("book", true, 9.99);
    private final Product testProductCD = new Product("CD", false, 14.98);
    private final Product testProductCDImported = new Product("music CD", true, 14.98);
    private final Product testProductChocolate = new Product("chocolate bar", false, 1.12);
    private final Product testProductChocolateImported = new Product("chocolate bar", true, 1.12);
    private final Product testProductPerfume = new Product("bottle of perfume", false, 72.10);
    private final Product testProductPerfumeImported = new Product("bottle of perfume", true, 72.10);

    public void testGetProductName() {
        assertEquals("book", testProductBook.getProductName());
        assertEquals("imported book", testProductBookImported.getProductName());
        assertEquals("CD", testProductCD.getProductName());
        assertEquals("imported music CD", testProductCDImported.getProductName());
        assertEquals("chocolate bar", testProductChocolate.getProductName());
        assertEquals("imported chocolate bar", testProductChocolateImported.getProductName());
        assertEquals("bottle of perfume", testProductPerfume.getProductName());
        assertEquals("imported bottle of perfume", testProductPerfumeImported.getProductName());
    }

    public void testGetGrossPrice() {
        assertEquals(9.99, testProductBook.getGrossPrice());
        assertEquals(10.49, testProductBookImported.getGrossPrice());
        assertEquals(16.48, testProductCD.getGrossPrice());
        assertEquals(17.23, testProductCDImported.getGrossPrice());
        assertEquals(1.12, testProductChocolate.getGrossPrice());
        assertEquals(1.22, testProductChocolateImported.getGrossPrice());
        assertEquals(79.35, testProductPerfume.getGrossPrice());
        assertEquals(83.00, testProductPerfumeImported.getGrossPrice());
    }

    public void testGetAllAppliedTaxes() {
        assertEquals(0.00, testProductBook.getAllAppliedTaxes());
        assertEquals(0.50, testProductBookImported.getAllAppliedTaxes());
        assertEquals(1.50, testProductCD.getAllAppliedTaxes());
        assertEquals(2.25, testProductCDImported.getAllAppliedTaxes());
        assertEquals(0.00, testProductChocolate.getAllAppliedTaxes());
        assertEquals(0.10, testProductChocolateImported.getAllAppliedTaxes());
        assertEquals(7.25, testProductPerfume.getAllAppliedTaxes());
        assertEquals(10.90, testProductPerfumeImported.getAllAppliedTaxes());
    }
}