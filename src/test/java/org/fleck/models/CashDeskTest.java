package org.fleck.models;

import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

public class CashDeskTest extends TestCase{

    private final String EXPECTED_CONSOLE_OUTPUT =
            "1 book: 9.99\n" +
            "1 imported bottle of perfume: 83.00\n" +
            "Sales Taxes: 10.90\n" +
            "Total: 92,99\n" +
            "-----------------------------------\n";

    private final Product testProductBook = new Product("book", false, 9.99);
    private final Product testProductPerfumeImported = new Product("bottle of perfume", true, 72.10);

    private LinkedList<Product> importedTestBasket;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        importedTestBasket = CashDesk.getInstance().scanNewBasket("assets/testInput");

        System.setOut(new PrintStream(outContent));
    }

    public void testStaticGetInstance() {
        assertEquals(CashDesk.getInstance(), CashDesk.getInstance());
    }

    public void testScanNewBasket() {
        assertEquals(2, importedTestBasket.size());
        assertTrue(importedTestBasket.contains(testProductBook));
        assertTrue(importedTestBasket.contains(testProductPerfumeImported));
    }

    public void testCheckoutAndPrintReceiptOfPurchase() {
        CashDesk.getInstance().checkoutAndPrintReceiptOfPurchase();
        //assertEquals(EXPECTED_CONSOLE_OUTPUT, outContent.toString());
        assertEquals(0, importedTestBasket.size());
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();

        System.setOut(originalOut);
    }
}