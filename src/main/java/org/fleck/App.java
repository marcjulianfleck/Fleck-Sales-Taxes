package org.fleck;

import org.fleck.models.CashDesk;

import java.io.File;

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
            if (new File(basket).exists()){
                CashDesk.getInstance().scanNewBasket(basket);
                CashDesk.getInstance().checkoutAndPrintReceiptOfPurchase();
                System.out.println(SEPARATOR);
            }
        }
    }
}
