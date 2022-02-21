package org.fleck.models;

import junit.framework.TestCase;

public class ProductCategoryTest extends TestCase {

    public void testGetProductCategory() {
        assertEquals(ProductCategory.BOOK, ProductCategory.getProductCategory("book"));
        assertEquals(ProductCategory.ENTERTAINMENT, ProductCategory.getProductCategory("music CD"));
        assertEquals(ProductCategory.FOOD, ProductCategory.getProductCategory("chocolate bar"));
        assertEquals(ProductCategory.FOOD, ProductCategory.getProductCategory("box of chocolates"));
        assertEquals(ProductCategory.BODYCARE, ProductCategory.getProductCategory("bottle of perfume"));
        assertEquals(ProductCategory.MEDICAL, ProductCategory.getProductCategory("headache pills"));
        assertEquals(ProductCategory.UNKNOWN, ProductCategory.getProductCategory("beer"));
    }

    public void testIsProductCategoryTaxable() {
        assertTrue(ProductCategory.ENTERTAINMENT.taxable);
        assertTrue(ProductCategory.BODYCARE.taxable);
        assertTrue(ProductCategory.UNKNOWN.taxable);

        assertFalse(ProductCategory.BOOK.taxable);
        assertFalse(ProductCategory.FOOD.taxable);
        assertFalse(ProductCategory.MEDICAL.taxable);
    }

}