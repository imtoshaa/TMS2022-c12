package com.tms.service;

import com.tms.model.Customer;
import com.tms.model.LeastQueueCashBoxStrategy;
import com.tms.model.RandomCashBoxStrategy;
import com.tms.model.Shop;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Shop shop = new Shop(3);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Customer b = new Customer(shop, "Customer" + i, new String[]{"Вода", "Колбаса"},
                    random.nextInt(2) == 0 ? new LeastQueueCashBoxStrategy() : new RandomCashBoxStrategy());
            b.start();
            Thread.sleep(100);
        }
    }
}
