package org.fleck;

import org.fleck.models.CashDesk;

import java.io.File;
import java.io.IOException;

public class App {

    private static final String[] DEFAULT_BASKETS_PATHS = {
            "assets/input1.txt",
            "assets/input2.txt",
            "assets/input3.txt"
    };

    private static final String SEPARATOR = "-----------------------------------";

    public static void main(String[] importBasketsPaths) {

        String[] queuedBaskets = (importBasketsPaths.length > 0) ? importBasketsPaths : DEFAULT_BASKETS_PATHS;

        for (String basket : queuedBaskets) {
            if (new File(basket).exists()) {
                try {
                    CashDesk.getInstance().scanNewBasket(basket);
                    CashDesk.getInstance().checkoutAndPrintReceiptOfPurchase();
                    System.out.println(SEPARATOR);
                } catch (IOException ioException) {
                    System.err.println("Something went wrong with the " + basket + " file.");
                } catch (IllegalStateException illegalStateException) {
                    System.err.println("Bad formatted " + basket + " file.");
                }
            } else {
                System.err.println(basket + " does not exist.");
            }
        }
    }
}
