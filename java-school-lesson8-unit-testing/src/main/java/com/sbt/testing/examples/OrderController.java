package com.sbt.testing.examples;

import static com.sbt.testing.examples.ClientCategory.*;

public class OrderController {

    private DiscountRegistry discountRegistry;

    public OrderController(DiscountRegistry discountRegistry) {

        this.discountRegistry = discountRegistry;
    }

    public int getItemDiscountForClient(Client client, Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        int itemDiscount = discountRegistry.getDiscount(item);
        int clientDiscount = PRIVILEGED == client.getCategory() ? 15 : 0;

        return Math.max(itemDiscount, clientDiscount);
    }

}
