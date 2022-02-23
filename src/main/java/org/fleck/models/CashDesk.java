package org.fleck.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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

    /**
     *This method scans a txt file given as a {@code "String"} and adds the found
     * {@code "Products"} in it to the purchase list. Afterwards it returns the list.
     *
     * @param  basketPath
     *         A {@code "String"} which contains the path to a txt file.
     *
     *@return the current Instance of the purchase as a {@code "LinkedList<Product>"}.
     *
     * @throws IOException
     */
    public LinkedList<Product> scanNewBasket(String basketPath) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(basketPath))) {
            stream.forEach(this::addNewProduct);
        }

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

    private void addNewProduct(String newProductString) {
        short quantity = scanQuantity(newProductString);
        String productName = scanProductName(newProductString);
        boolean isImported = isImported(newProductString);
        double netPrice = scanNetPrice(newProductString);

        for (short s = 0; s < quantity; s++) {
            Product newProduct = new Product(productName, isImported, netPrice);
            purchase.add(newProduct);
        }
    }

    private short scanQuantity(String newProductString) {
        Pattern quantityPattern = Pattern.compile("^[\\d+]+");
        Matcher quantityMatcher = quantityPattern.matcher(newProductString);
        quantityMatcher.find();

        return Short.parseShort(quantityMatcher.group(0));
    }

    private String scanProductName(String newProductString) {
        Pattern productNamePattern = Pattern.compile("(?!^\\d)[A-Za-z].+(?=\\sat\\s\\d+.\\d+$)");
        Matcher productNameMatcher = productNamePattern.matcher(newProductString);
        productNameMatcher.find();
        return  productNameMatcher.group(0).replaceFirst(" imported|imported ", "");
    }

    private Boolean isImported(String newProductString) {
        Pattern importedPattern = Pattern.compile("imported");

        return importedPattern.matcher(newProductString).find();
    }

    private Double scanNetPrice(String newProductString) {
        Pattern pricePattern = Pattern.compile("\\d+.\\d+$");
        Matcher priceMatcher = pricePattern.matcher(newProductString);
        priceMatcher.find();

        return Double.parseDouble(priceMatcher.group(0));
    }
}
